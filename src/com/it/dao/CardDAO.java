package com.it.dao;

import java.util.List;

import com.it.entity.Card;
import com.kaishengit.tools.BeanRowMapper;
import com.kaishengit.tools.DBHelper;

public class CardDAO {
	DBHelper<Card> db = new DBHelper<>(Config.DB_URL);
	BeanRowMapper<Card> be = new BeanRowMapper<>(Card.class);

	public boolean add(Card card) {
		String sql = "insert into card(code,name,tel) values(?,?,?)";
		int result = db.doUpdate(sql, card.getCode(), card.getName(), card.getTel());
		return result == 1;
	}
	public boolean remove(int id) {
		String sql = "delete from card where id=?";
		int result = db.doUpdate(sql, id);
		return result == 1;
	}

	public Card findOne(String code){
		String sql = "select * from card where code=?";
		return db.queryOne(sql, be, code);
	}
	public Card findOne(int id){
		String sql = "select * from card where id=?";
		return db.queryOne(sql, be, id);
	}
	public List<Card> findAll(){
		String sql = "select * from card";
		return db.queryList(sql, be);
	}
	
	public boolean cardmodify(Card card){
		String sql = "update card set code=?, name=?, tel=? where id=?";
		int result = db.doUpdate(sql, card.getCode(), card.getName(), card.getTel(), card.getId());
		return result == 1;
	}
}
