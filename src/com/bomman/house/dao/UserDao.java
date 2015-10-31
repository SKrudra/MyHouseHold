package com.bomman.house.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bomman.house.bean.User;
import com.bomman.house.utils.HibernateSessionFactory;

public class UserDao {
	public boolean authenticate(User user) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select password from user where username =?");
		query.setString(0, user.getUsername());
		System.out.println(query);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		if(list.size()>0){
			if(list.get(0).equals(user.getPassword())){
				return true;
			}
		}
		return false;
	}
}
