package com.it.myservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.entity.Card;
import com.it.dao.CardDAO;



/**
 * Servlet implementation class CardHome
 */
public class CardHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    CardDAO cd = new CardDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = "";
		if(request.getParameter("a") != null){
			a = new String(request.getParameter("a").getBytes("ISO-8859-1"),"UTF-8");
		}
		List<Card> list = cd.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/cardlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
