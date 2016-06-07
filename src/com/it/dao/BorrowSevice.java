package com.it.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class BorrowSevice {
	public String BorrowBook(String bookcode, String cardcode){
		return callPro("{CALL pro_book_borrow (?,?,?)}", bookcode, cardcode);
	}
	
	public String backBook(String bookcode, String cardcode){
		return callPro("{CALL pro_book_back (?,?,?)}", bookcode, cardcode);
	} 
	
	private String callPro(String proName,String bookcode, String cardcode){
		String msg = "";
		try {
			Connection coon = DriverManager.getConnection(com.it.dao.Config.DB_URL);
			CallableStatement cstmt = coon.prepareCall(proName);
			cstmt.setString(1, bookcode);
			cstmt.setString(2, cardcode);
			
			cstmt.executeQuery();
			msg = cstmt.getString(3);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return msg;
	}
}