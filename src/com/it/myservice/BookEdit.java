package com.it.myservice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.dao.BookDAO;
import com.it.entity.Book;
/**
 * Servlet implementation class BookEdit
 */
public class BookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BookDAO bd = new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Book b = bd.findOne(id);
		request.setAttribute("book", b);
		request.getRequestDispatcher("/WEB-INF/views/bookedit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publishing = request.getParameter("publishing");
		int total = Integer.parseInt(request.getParameter("total"));
		int count = Integer.parseInt(request.getParameter("count"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Book book = new Book();
		book.setId(id);
		book.setCode(code);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublishing(publishing);
		book.setTotal(total);
		book.setCount(count);
		
		if(bd.modify(book)){
			response.sendRedirect("/bookhome");
		}else{
			response.sendError(400, "ÐÞ¸ÄÒì³£");
		}
	}

}
