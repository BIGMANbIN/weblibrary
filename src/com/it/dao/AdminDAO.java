package com.it.dao;

import com.it.entity.Admin;
import com.kaishengit.tools.BeanRowMapper;
import com.kaishengit.tools.DBHelper;

public class AdminDAO {
	DBHelper<Admin> db = new DBHelper<>(Config.DB_URL);
	BeanRowMapper<Admin> be = new BeanRowMapper<>(Admin.class);

	public boolean find(String name, String pwd) {
		String sql = "select * from admin where name=? and password=?";
		Admin a = db.queryOne(sql, be, name, pwd);
		return a != null;
		// if (a != null) {
		// return true;
		// } else {
		// return false;
		// }
	}
}
