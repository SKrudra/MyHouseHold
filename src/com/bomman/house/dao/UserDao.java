package com.bomman.house.dao;

import com.bomman.house.bean.User;

public class UserDao {
	public boolean authenticate(User user) {
		System.out.println("Default: true");
		return true;
	}
}
