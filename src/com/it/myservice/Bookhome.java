package com.it.myservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.BookDAO;
import com.it.entity.Book;

/**
 * Servlet implementation class Bookhome
 */
public class Bookhome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Bookhome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	BookDAO bd = new BookDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String wd = "";
		if (request.getParameter("wd") != null) {
			wd = new String(request.getParameter("wd").getBytes("ISO-8859-1"), "utf-8");
		}
		System.out.println(wd);
		List<Book> list = bd.findBooks(wd);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/booklist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
