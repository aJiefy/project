package com.lafite.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lafite.entity.Root;
import com.lafite.util.BaseDao;

public class RootDao {

	// verify login
		public List<Root> checkLogin(String username,String password) {
			// TODO Auto-generated method stub
			Connection conn = BaseDao.getConn();
			List<Object> param = new ArrayList<Object>();
			
			String sql = "select * from t_root where root_name=? and root_password=?";
			param.add(username);
			param.add(password);
			
			
			List<Root> result = (List<Root>)BaseDao.select(sql, Root.class, param.toArray());
			
			System.out.println("result[0]="+result.get(0));
			
			BaseDao.close(null, null, conn);
			return result;
			
			
			
			
		}
}
