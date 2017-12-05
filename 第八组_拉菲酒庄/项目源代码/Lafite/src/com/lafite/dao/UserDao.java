package com.lafite.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lafite.entity.Order;
import com.lafite.entity.User;
import com.lafite.page.PageData;
import com.lafite.page.QueryObject;
import com.lafite.util.BaseDao;
import com.lafite.util.StringUtils;

public class UserDao {
	
	
	
	//queryUsername
    public List<User> queryUserByName(String username) {
		Connection conn = BaseDao.getConn();
		List<Object> param = new ArrayList<Object>();
		
		String sql = "select * from t_user where user_name=?";
		param.add(username);
		
		
		List<User> list = (List<User>)BaseDao.select(sql, User.class, param.toArray());
		
		//System.out.println("result[0]="+list.get(0));
		
		BaseDao.close(null, null, conn);
		return list;
        
    }
    
    //queryUser password
    public List<User> checkUserPwd(User user) {
    	List<Object> param = new ArrayList<Object>();
    	String sql = "select * from t_user where user_password=? and user_id=?";
    	param.add(user.getUSER_PASSWORD());
    	param.add(user.getUSER_ID());
    	List<User> list = (List<User>) BaseDao.select(sql, User.class, param.toArray());
    	
		return list;
    }
    
    //queryUser_Tel
    public List<User> queryUserByTel(String tel) {
		List<Object> param = new ArrayList<Object>();
		
		String sql = "select user_tel from t_user where user_tel=?";
		param.add(tel);
		
		
		List<User> list = (List<User>)BaseDao.select(sql, User.class, param.toArray());
		
		//System.out.println("result[0]="+list.get(0));
		
		return list;
    }
	
	
	
	
	//register
	public int addUser(User user)  {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		String sql = "insert into t_user values(user_id.nextval,?,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd') )";
		List<Object> param = new ArrayList<Object>();
		param.add(user.getUSER_REALNAME());
		param.add(user.getUSER_HEADIMG());
		param.add(user.getUSER_SEX());
		param.add(user.getUSER_NAME());
		param.add(user.getUSER_PASSWORD());
		param.add(user.getUSER_TEL());
		param.add(user.getUSER_LOC());
		param.add(user.getUSER_BIRTHDAY());
		
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
	
	
	// verify login
	public List<User> checkLogin(String username,String password) {
		// TODO Auto-generated method stub
		Connection conn = BaseDao.getConn();
		List<Object> param = new ArrayList<Object>();
		
		String sql = "select * from t_user where user_name=? and user_password=?";
		param.add(username);
		param.add(password);
		
		
		List<User> result = (List<User>)BaseDao.select(sql, User.class, param.toArray());
		
		System.out.println("result[0]="+result.get(0));
		
		BaseDao.close(null, null, conn);
		return result;
		
	}
	
	
	
	// 高级查询
		public PageData selectPage(QueryObject queryObject) throws Exception {
	
			String sql = "SELECT * FROM (SELECT a.*, ROWNUM rn FROM (SELECT * FROM T_USER "
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
					User.class, parames.toArray());
	
			PageData pageData = new PageData(list, totalCount,
					queryObject.getPageSize(), queryObject.getCurrentPage());
			return pageData;
		}
		
		// 查询数据总条数 
		public long queryTotalCount(QueryObject queryObject) {

			String sql = "SELECT USER_ID FROM T_USER" + queryObject.getSql();
			List<?> resultSet = (List<?>) BaseDao.select(sql, User.class,
					queryObject.getParames().toArray());
			Long count = Long.valueOf(resultSet.size());
			return count;
		}
	

		// 查询当前用户所有的订单信息
		public List<Order> queryUserOrder(String username) {
			List<Object> param = new ArrayList<Object>();
			String sql = "SELECT * FROM T_ORDER WHERE USER_NAME=?";
			param.add(username);
			List<Order> list = (List<Order>) BaseDao.select(sql, Order.class, param.toArray());
		
			return list;
		}



		// 更新客户信息
		public int updateUser(User user) {
			StringBuilder sql = new StringBuilder( "update T_USER set user_sex=?,user_birthday=to_date(?,'yyyy-MM-dd'),user_loc=?");
			if (StringUtils.hasLength(user.getUSER_HEADIMG())) {
				System.out.println("HeadImg="+user.getUSER_HEADIMG());
				sql.append(",USER_HEADIMG=?");
			}
			sql.append("where USER_ID = ?");
			
			ArrayList<Object> params = new ArrayList<Object>();
			params.add(user.getUSER_SEX());
			params.add(user.getUSER_BIRTHDAY());
			params.add(user.getUSER_LOC());
			if (StringUtils.hasLength(user.getUSER_HEADIMG())) {
				params.add(user.getUSER_HEADIMG());
			}
			params.add(user.getUSER_ID());
			int flag = BaseDao.execute(sql.toString(), params.toArray());
			return flag;

		}
		
		//修改密码
		public int updatePwd(User user) {
			ArrayList<Object> params = new ArrayList<Object>();
			String sql = "update T_USER set user_password=? where user_id=?";
			params.add(user.getUSER_PASSWORD());
			params.add(user.getUSER_ID());
			int ret = BaseDao.execute(sql, params.toArray());
			return ret;
		}

		//delete User
		public int deleteUser(int id) {
			// TODO Auto-generated method stub
			String sql = "delete from t_user where user_id = ?";
			List<Object> param = new ArrayList<Object>();
			param.add(id);
			int i = BaseDao.execute(sql, param.toArray());
			return i;
		}


}
