package com.bomman.house.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

import com.bomman.house.bean.Commodity;
import com.bomman.house.utils.HibernateSessionFactory;

public class CommodityDao {

	public int insert(Commodity commodity) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		int rowsInserted = (Integer) session.save(commodity);
		transaction.commit();
		return rowsInserted;
	}

	@SuppressWarnings("unchecked")
	public List<Commodity> getAll() {
		Query query = HibernateSessionFactory.getSession().createQuery(
				"from Commodity");
		return (List<Commodity>) query.list();
	}

	public boolean delete(int id) {
		return false;
	}

	public boolean update(Commodity commodity) {
		return false;
	}

	public Map<String, Double> individualInvestment() {
		System.out.println("In investment");
		SQLQuery query = HibernateSessionFactory
				.getSession()
				.createSQLQuery(
						"select buyer,sum(cost) as amount from commodity group by buyer");
		System.out.println(query);
		query.addScalar("buyer", new StringType());
		query.addScalar("amount", new DoubleType());

		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		if (list.size() > 0) {
			System.out.println("result not empty");
			Map<String, Double> map = new HashMap<String, Double>();
			for (Object[] object : list) {
				System.out.println(object[0].toString());
				System.out.println(Double.parseDouble(object[1].toString()));
				map.put(object[0].toString(),
						Double.parseDouble(object[1].toString()));
			}
			return map;
		}
		return null;
	}
}
