package com.bomman.house.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bomman.house.bean.Commodity;
import com.bomman.house.dao.CommodityDao;

public class DisplayServlet extends HttpServlet {

	private static final long serialVersionUID = 2L;

	CommodityDao commodityDao = new CommodityDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Commodity> commodities = commodityDao.getAll();
		HttpSession session = req.getSession();
		session.setAttribute("commodity", commodities);

		Map<String, Double> map = commodityDao.individualInvestment();
		System.out.println("map: " + map);
		if (map.size() >0 ) {
			session.setAttribute("individual", map);
			double sInvest = map.get("Sandeep");
			double vInvest = map.get("Venkatesh");
			if (sInvest > vInvest) {
				session.setAttribute("sLiability", 0);
				session.setAttribute("vLiability", ((sInvest - vInvest) / 2));
			} else if (vInvest > sInvest) {
				session.setAttribute("vLiability", 0);
				session.setAttribute("sLiability", ((vInvest - sInvest) / 2));
			} else {
				session.setAttribute("sLiability", 0);
				session.setAttribute("vLiability", 0);
			}
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("./home.jsp");
		// resp.sendRedirect("home.jsp");
		dispatcher.forward(req, resp);
	}
}
