package com.it.myservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.CardDAO;
import com.it.entity.Card;

/**
 * Servlet implementation class CardEdit
 */
public class CardEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    CardDAO cd = new CardDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Card card = cd.findOne(id);
		request.setAttribute("card",card);
		request.getRequestDispatcher("/WEB-INF/views/cardedit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Card card = new Card();
		card.setId(id);
		card.setCode(code);
		card.setName(name);
		card.setTel(tel);
		
		if(cd.cardmodify(card)){
			response.sendRedirect("cardhome");
		}else{
			response.sendError(400, "ÐÞ¸ÄÒì³£");
		}
	}

}
