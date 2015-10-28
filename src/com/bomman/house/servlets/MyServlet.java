package com.bomman.house.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomman.house.bean.Commodity;
import com.bomman.house.dao.CommodityDao;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	CommodityDao commodityDao = new CommodityDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Commodity commodity = new Commodity();

		commodity.setItems(req.getParameter("items"));
		commodity.setCost(Double.parseDouble(req.getParameter("cost")));
		commodity.setBuyer(req.getParameter("buyer"));
		commodity.setDate(Date.valueOf(req.getParameter("date")));
		
		System.out.println(req.getParameter("items"));
		System.out.println(req.getParameter("cost"));
		System.out.println(req.getParameter("buyer"));
		System.out.println(req.getParameter("date"));
		
		int i = commodityDao.insert(commodity);
		System.out.println(i + "rows affected.");
//		resp.sendRedirect("./home");
		RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
		dispatcher.forward(req, resp);
	}
}
