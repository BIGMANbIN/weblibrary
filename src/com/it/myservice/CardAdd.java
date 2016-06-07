package com.it.myservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.CardDAO;
import com.it.entity.Card;
/**
 * Servlet implementation class CardAdd
 */
public class CardAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//页面跳转
		request.getRequestDispatcher("WEB-INF/views/cardadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	CardDAO cd = new CardDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新增会员的方法
		
		String code = request.getParameter("code");
		String name =request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Card card = new  Card();
		card.setCode(code);
		card.setName(name);
		card.setTel(tel);
		
		if(cd.add(card)){
			response.sendRedirect("/cardhome");
		}else{
			response.sendError(400, "新增异常");
		}
	}

}
