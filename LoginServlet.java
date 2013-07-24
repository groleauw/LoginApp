package com.login;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("In the Login Servlet");
			LoginBean user = new LoginBean();
			user.setUserName(request.getParameter("uname"));
			user.setPassword(request.getParameter("password"));
			user = LoginDAO.login(user);
			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("LoginSuccess.jsp");
			} else
				response.sendRedirect("LoginFailed.jsp");
		} catch (Throwable exc) {
			System.out.println(exc);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}