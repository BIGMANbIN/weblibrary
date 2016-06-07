package com.it.myservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.AdminDAO;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		String username = null;
		String password = null;
		if(cookies != null){
			for (Cookie c : cookies) {
				if("username".equals(c.getName())){
					username = c.getValue();
				}else if("password".equals(c.getName())){
					password =c.getValue();
				}
			}
		}
		
		if(username != null && password != null){
			AdminDAO ad = new AdminDAO();
			if(ad.find(username, password)){
				request.getSession().setAttribute("username", username);
				response.sendRedirect("/home");
				return;
			}else{
			Cookie ck1 = new Cookie("username","");
			Cookie ck2 = new Cookie("password","");
			ck1.setPath("/");
			ck1.setHttpOnly(true);
			ck1.setMaxAge(0);
			ck2.setPath("/");
			ck2.setHttpOnly(true);
			ck2.setMaxAge(0);
			response.addCookie(ck1);
			response.addCookie(ck2);
				
			}
		}
		
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
