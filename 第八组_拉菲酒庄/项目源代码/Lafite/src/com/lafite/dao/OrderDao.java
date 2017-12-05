package com.lafite.dao;

import java.util.ArrayList;
import java.util.List;

import com.lafite.entity.Order;
import com.lafite.entity.Wine;
import com.lafite.page.PageData;
import com.lafite.page.QueryObject;
import com.lafite.util.BaseDao;

public class OrderDao {
	
	// 高级查询
	public PageData selectPage(QueryObject queryObject) throws Exception {

		String sql = "SELECT * FROM (SELECT a.*, ROWNUM rn FROM (SELECT * FROM T_ORDER "
				+ queryObject.getSql()
				+ ") a  WHERE ROWNUM <= ? ) "
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
				Order.class, parames.toArray());

		PageData pageData = new PageData(list, totalCount,
				queryObject.getPageSize(), queryObject.getCurrentPage());
		return pageData;
	}
	
	// 查询数据总条数 
	public long queryTotalCount(QueryObject queryObject) {

		String sql = "SELECT ID FROM T_ORDER" + queryObject.getSql();
		List<?> resultSet = (List<?>) BaseDao.select(sql, Order.class,
				queryObject.getParames().toArray());
		Long count = Long.valueOf(resultSet.size());
		return count;
	}
	
	//query order by username
	public List<Order> queryOrder(String username){
		BaseDao.getConn();
		List<Object> param = new ArrayList<Object>();
		String sql = "select id,cart_id,user_name,user_tel,wine_img,wine_name,order_count,user_loc," +
				"pay_status,order_status,order_createtime,null,order_totalprice from t_order where user_name=?";
		param.add(username);
		
		List<Order> list = 
				(List<Order>) BaseDao.select(sql, Order.class, param.toArray());
		
		System.out.println("dao_list="+list);
		return list;
		
	}
	
	//add to order
	public int addOrder(List<Order> orderList){
		String sql = "insert into t_order values(order_id.nextval,?,?,?,?,?,?,?,?,?,sysdate,null,?)";
			 List<Object> params = new ArrayList<Object>();
			 int ret = 0;
//			 for(int i=0;i<params.size();i++){
			 params.add(orderList.get(0).getCART_ID());
			 params.add(orderList.get(0).getUSER_NAME());
			 params.add(orderList.get(0).getUSER_TEL());
			 params.add(orderList.get(0).getWINE_IMG());
			 params.add(orderList.get(0).getWINE_NAME());
			 params.add(orderList.get(0).getORDER_COUNT());
			 params.add(orderList.get(0).getUSER_LOC());
			 params.add(orderList.get(0).getPAY_STATUS());
			 params.add(orderList.get(0).getORDER_STATUS());
			 params.add(orderList.get(0).getORDER_TOTALPRICE());
			 ret = BaseDao.execute(sql, params.toArray());
			 
			 System.out.println("ret="+ret);
//			 }
			 
			 return ret;
	} 
	
	
	//update  pay_statu
		public int updatePayStatus(String username) {
			// TODO Auto-generated method stub
			List<Object> param = new ArrayList<Object>();
//			StringBuilder sql = new StringBuilder("update t_cart set cart_count=?,cart_totalprice=?");
//			sql.append("where cart_id = ?");
			String sql = "update t_order set payment=1 where user_name = ?";
			param.add(username);
			int rel = 0;
			rel = BaseDao.execute(sql, param.toArray());
		 
			System.out.println("dao_rel="+rel);
			return rel;
			
		}
		
		
		//delete Order
		public int deleteOrder(int id) {
			String sql = "delete from t_order where id = ?";
			List<Object> param = new ArrayList<Object>();
			param.add(id);
			int i = BaseDao.execute(sql, param.toArray());
			return i;
		}
	

}
