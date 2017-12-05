package com.lafite.test;

import java.util.List;

import com.lafite.dao.WineDao;
import com.lafite.entity.Wine;

public class OracTest {
	public static void main(String[] args) {
		WineDao dao = new WineDao();
		List<Wine> showAllWine = dao.showAllWine();
		System.out.println(showAllWine);
		
		
		
	}

}
