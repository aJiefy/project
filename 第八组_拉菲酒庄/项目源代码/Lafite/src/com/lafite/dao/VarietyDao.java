package com.lafite.dao;

import java.util.List;

import com.lafite.entity.Variety;
import com.lafite.util.BaseDao;

public class VarietyDao {
	
	public VarietyDao(){
		BaseDao.getConn();
	}
	
	//得到品种信息
	public List<Variety> getVarietiesInfo(){
		String sql = "select * from t_varieties";
		List<Variety> list = (List<Variety>)BaseDao.select(sql, Variety.class, null);
		return list;
	}
	

}
