package com.lafite.test;

import java.util.List;

import com.lafite.dao.UserDao;
import com.lafite.entity.User;

public class UserTest {
	public static void main(String[] args) {
		
		UserDao dao = new UserDao();
		List<User> login = dao.checkLogin("abc", "abc");
		System.out.println(login);
		
		
	}

}
