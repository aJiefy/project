package com.lafite.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lafite.entity.Wine;
import com.lafite.page.PageData;
import com.lafite.page.QueryObject;
import com.lafite.page.QueryWineConditionSets;
import com.lafite.util.BaseDao;
import com.lafite.util.StringUtils;

public class WineDao {
	//QueryObject queryObject;
	
	//wine-manage.jsp
	
	public int addWineInfo(Wine wine,String born)  {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		String sql = "insert into t_wine values(wine_id.nextval,?,?,?,?," +
				"?,?,?,?,?,?,?,sysdate)";
		List<Object> param = new ArrayList<Object>();
		param.add(wine.getWINE_NAME());
		param.add(wine.getWINE_DESCRIBE());
		param.add(wine.getWINE_IMG());
		param.add(wine.getWINE_VARIETIES_ID());
		param.add(wine.getWINE_YIELD());
		param.add(wine.getWINE_PRICE());
		param.add(wine.getWINE_ADVICE());
		param.add(born);
		param.add(wine.getWINE_DETAIL());
		param.add(wine.getWINE_HOT());
		param.add(wine.getWINE_STOCK());
		
		int i;
		try {
			i = BaseDao.execute(sql, param.toArray());
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.close(null, null, conn);
		return 0;
	}
	
	public List<Wine> selectAllWineInfo() {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		String sql = "select * from t_wine";
		List<Wine> allWineInfo =(List<Wine>)BaseDao.select(sql, Wine.class, null);
		BaseDao.close(null, null, conn);
		return allWineInfo;
	}
	
	//delete wine
	public int deleteWineInfo(int wineId) {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		String sql = "delete from t_wine where wine_id = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(wineId);
		try {
			int i = BaseDao.execute(sql, param.toArray());
			conn.commit();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.close(null, null, conn);
		return 0;
	}

	public List<Wine> findOneWineInfo(int wineId) {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		String sql = "select * from T_WINE  where wine_id = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(wineId);
		List<Wine> select = (List<Wine>) BaseDao.select(sql,
				Wine.class, param.toArray());
		BaseDao.close(null, null, conn);
		return select;
	}

	//update wine
	public int updateOneWineInfo(Wine wine, String born) {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		StringBuilder sql = new StringBuilder(
				"update  T_WINE set WINE_NAME=?,WINE_DESCRIBE=?,WINE_VARIETIES_ID=?,WINE_YIELD=?"
						+ ",WINE_PRICE=?,WINE_ADVICE=?,WINE_DETAIL=?,WINE_HOT=?,WINE_STOCK=?,WINE_BORN = ? ");
		if (StringUtils.hasLength(wine.getWINE_IMG())) {
			System.out.println("wineIMG="+wine.getWINE_IMG());
			sql.append(",WINE_IMG=?");
		}
		sql.append("where WINE_ID = ?");
		List<Object> param = new ArrayList<Object>();
		param.add(wine.getWINE_NAME());
		param.add(wine.getWINE_DESCRIBE());
		param.add(wine.getWINE_VARIETIES_ID());
		param.add(wine.getWINE_YIELD());
		param.add(wine.getWINE_PRICE());
		param.add(wine.getWINE_ADVICE());
		param.add(wine.getWINE_DETAIL());
		param.add(wine.getWINE_HOT());
		param.add(wine.getWINE_STOCK());
		param.add(born);
		if (StringUtils.hasLength(wine.getWINE_IMG())) {
			param.add(wine.getWINE_IMG());
		}

		param.add(wine.getWINE_ID());
		int i = 0;
		i = BaseDao.execute(sql.toString(), param.toArray());
		BaseDao.close(null, null, conn);
		return i;
		
		
	}

	// 高级查询
	public PageData selectPage(QueryObject queryObject) throws Exception {

		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rn FROM (SELECT * FROM T_WINE "
				+ queryObject.getSql()
				+ ") a  WHERE ROWNUM <= ? order by WINE_ID DESC ) "
				+ "Where rn >= ? ";

		List<Object> parames = new ArrayList<Object>();
		if (queryObject.getSql() != null) {
			parames.addAll(queryObject.getParames());
		}
		Integer totalCount = (int) queryTotalCount(queryObject);
		int totalPage = totalCount % queryObject.getPageSize() == 0 ? (totalCount / queryObject
				.getPageSize()) : (totalCount / queryObject.getPageSize()) + 1;

		if (queryObject.getCurrentPage() > totalPage) {
			parames.add(totalPage * queryObject.getPageSize());
			System.out.println("total:" + totalPage);
		} else {
			parames.add(queryObject.getCurrentPage()
					* queryObject.getPageSize());
			System.out.println("CurrentPage:" + queryObject.getCurrentPage());
		}

		System.out.println(sql);

		if (queryObject.getCurrentPage() > totalPage) {
			parames.add(queryObject.getPageSize() * (totalPage - 1) + 1);
		} else {
			parames.add(queryObject.getPageSize()
					* (queryObject.getCurrentPage() - 1) + 1);
		}

		List<Object> list = (List<Object>) BaseDao.select(sql,
				Wine.class, parames.toArray());

		PageData pageData = new PageData(list, totalCount,
				queryObject.getPageSize(), queryObject.getCurrentPage());
		return pageData;
	}




	// 查询数据总条数 没用到
	public long queryTotalCount(QueryObject queryObject) {

		String sql = "SELECT WINE_ID FROM T_WINE" + queryObject.getSql();
		List<?> resultSet = (List<?>) BaseDao.select(sql, Wine.class,
				queryObject.getParames().toArray());
		Long count = Long.valueOf(resultSet.size());
		return count;
	}

	
	
		
	 //index.jsp  
	
	//查询红酒(名字，图片，id)
		public List<Wine> showAllWine() {
			StringBuilder sql = new StringBuilder("SELECT WINE_ID,WINE_NAME,WINE_IMG FROM T_WINE order by WINE_ID");
			List<Wine> list = (List<Wine>)BaseDao.select(sql.toString(), Wine.class, null);
			return list;
		}
		
		//高级查询-4个系列
		public List<Wine> showWine(Long WINE_VARIETIES_ID){
			StringBuilder sql = new StringBuilder("SELECT WINE_ID,WINE_NAME,WINE_IMG FROM T_WINE ");
			
			List<Object> parames = new ArrayList<Object>();
			if(StringUtils.hasLength(WINE_VARIETIES_ID.toString())){
				sql.append(" WHERE WINE_VARIETIES_ID = ?");
				parames.add(WINE_VARIETIES_ID);
			}
			List<Wine> list = (List<Wine>)BaseDao.select(sql.toString(), Wine.class, parames.toArray());
			return list;
		}
		
		
		public List<Wine> SeleteWineId(Long WINE_ID){
			String sql = "SELECT * FROM T_WINE WHERE WINE_ID = ?";
			
			List<Object> parames = new ArrayList<Object>();
			parames.add(WINE_ID);
			
			List<Wine> list = (List<Wine>)BaseDao.select(sql, Wine.class, parames.toArray());
			return list;
		}
	


}
