package com.it.dao;

import java.util.List;

import com.it.entity.Book;
import com.kaishengit.tools.BeanRowMapper;
import com.kaishengit.tools.DBHelper;

public class BookDAO {
	DBHelper<Book> db = new DBHelper<>(Config.DB_URL);
	BeanRowMapper<Book> be = new BeanRowMapper<>(Book.class);

	public boolean add(Book b) {
		String sql = "insert into book(code,title,author,publishing,total,count) values(?,?,?,?,?,?)";
		int result = db.doUpdate(sql, b.getCode(), b.getTitle(), b.getAuthor(), b.getPublishing(), b.getTotal(),
				b.getCount());
		return result == 1;
	}
	public boolean remove(int id) {
		String sql = "delete from book where id=?";
		int result = db.doUpdate(sql,id);
		return result == 1;
	}

	public Book findOne(String code) {
		String sql = "select * from book where code=?";
		return db.queryOne(sql, be, code);
	}
	public Book findOne(int id) {
		String sql = "select * from book where id=?";
		return db.queryOne(sql, be, id);
	}

	public List<Book> allBooks() {
		String sql = "select * from book";
		return db.queryList(sql, be);
	}

	public List<Book> findBooks(String str) {
		String sql = "select * from book where title like '%" + str + "%' or author like '%" + str
				+ "%' or code like '%" + str + "%'";
		return db.queryList(sql, be);
	}

	public boolean saveCount(Book b) {
		String sql = "update book set count=? where id=?";
		return db.doUpdate(sql, b.getCount(), b.getId()) == 1;
	}
	public boolean modify(Book b) {
		String sql = "update book set code=?,title=?,author=?,publishing=?,total=?,count=? where id=?";
		return db.doUpdate(sql, b.getCode(),b.getTitle(),b.getAuthor(),b.getPublishing(),b.getTotal(),b.getCount(), b.getId()) == 1;
	}

	public List<Book> findBooksByCard(String bCode) {
		String sql = "select book.* from book INNER JOIN borrow on borrow.bid=book.id INNER JOIN card ON card.id=borrow.cid where card.`code`=?";
		return db.queryList(sql, be, bCode);
	}
}
