package com.it.myservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.BookDAO;
import com.it.dao.BorrowSevice;
import com.it.dao.CardDAO;

/**
 * Servlet implementation class BorrowBook
 */
public class BorrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    BorrowSevice bs = new BorrowSevice();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	BookDAO bd = new BookDAO();
	CardDAO cd = new CardDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookCode =request.getParameter("bookcode");
		String cardCode =request.getParameter("cardcode");
	
		response.sendRedirect("/home?msg=" + bs.BorrowBook(bookCode, cardCode));
	}

}
