package com.wasiwasi.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.wasiwasi.health.model.Admin;

public class AdminDaoImpl extends AbstractDao implements AdminDao {

	private static final Logger log = Logger.getLogger(AdminDaoImpl.class);
	class AdminExtractor implements ResultSetExtractor<Admin>{

		public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				return populate(rs);
			} else {
				return null;
			}
		}
	}
	class AdminCountExtractor implements ResultSetExtractor<Integer>{
		
		public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return null;
			}
		}
	}
	
	public boolean insert(Admin admin) {
		if (admin.getId() != null) return false;
		boolean success = true;
		String id = UUID.randomUUID().toString() + System.currentTimeMillis();
		admin.setId(id);
		String sql = "insert into admin_user(id, email, uid, pwd) values(?,?,?,?)";
		int count = getJdbcTemplate().update(sql, id, admin.getEmail(), admin.getUid(), admin.getPassword());
		success = count == 1;
		if (success) admin.setId(id);
		log.info("admin insert success ? " + success + " new admin " + admin.getEmail());
		return success;
	}

	public boolean update(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	private Admin populate(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getString("id"));
		admin.setEmail(rs.getString("email"));
		admin.setUid(rs.getString("uid"));
		admin.setPassword(rs.getString("pwd"));
		return admin;
	}

	public Admin findByEmail(String email) {
		String sql = "select * from admin_user where email = ?";
		Admin admin = getJdbcTemplate().query(sql,
				new Object[] { email }, new AdminExtractor());
		return admin;
	}

	public Admin findByUid(String uid) {
		String sql = "select * from admin_user where uid = ?";
		Admin admin = getJdbcTemplate().query(sql,
				new Object[] { uid }, new AdminExtractor());
		return admin;
	}

	public int count() {
		String sql = "select count(*) from admin_user";
		int count = getJdbcTemplate().query(sql,
				new Object[] { }, new AdminCountExtractor());
		return count;
	}
}
