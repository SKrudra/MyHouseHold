package com.bomman.house.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bomman.house.bean.User;
import com.bomman.house.dao.UserDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3L;

	UserDao dao = new UserDao();
	User user = new User();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		user.setUsername(username);
		user.setPassword(password);
		try {
			if (dao.authenticate(user)) {
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("./home");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("./login.jsp");
				req.setAttribute("error",
						"Login Failed! Invalid username or password.");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("./login.jsp");
			req.setAttribute("error",
					"We are experiencing some internal issue, please try after some time.");
			dispatcher.forward(req, resp);
		}
	}

}
