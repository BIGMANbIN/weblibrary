package com.it.myservice;

import java.io.IOException;
import com.it.dao.BookDAO;
import com.it.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookAdd
 */
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将页面跳转至book.jsp
		request.getRequestDispatcher("/WEB-INF/views/bookadd.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	BookDAO  bd = new BookDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新增书籍的方法
		
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publishing = request.getParameter("publishing");
		int total = Integer.parseInt(request.getParameter("total"));
		
		Book book = new Book();
		book.setCode(code);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublishing(publishing);
		book.setTotal(total);
		book.setCount(total);
		
		if(bd.add(book)){
			response.sendRedirect("bookhome");
		}else{
			response.sendError(400, "新增异常");
		}
	}

}
