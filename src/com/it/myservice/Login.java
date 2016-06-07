package com.it.myservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.AdminDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		String rememberme = request.getParameter("rememberme");
		AdminDAO ad = new AdminDAO();
		if (ad.find(name, pwd)) {
			if ("yes".equals(rememberme)) {
				Cookie ck1 = new Cookie("username", name);
				Cookie ck2 = new Cookie("password", pwd);
				ck1.setPath("/");
				ck1.setHttpOnly(true);
				ck1.setMaxAge(60 * 60 * 24 * 3);
				ck2.setPath("/");
				ck2.setHttpOnly(true);
				ck2.setMaxAge(60 * 60 * 24 * 3);
				response.addCookie(ck1);
				response.addCookie(ck2);
			}
			request.getSession().setAttribute("username", name);
			response.sendRedirect("/home");
		}
		else{
			response.sendRedirect("/index?err=1001");
		}
	}
}
