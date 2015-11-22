package com.wasiwasi.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.google.gson.Gson;
import com.wasiwasi.health.model.Sms;

public class SmsDaoImpl extends AbstractDao implements SmsDao {
	
	
	class SmsExtractor implements ResultSetExtractor<Sms>{

		public Sms extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				return populate(rs);
			} else {
				return null;
			}
		}
	}
	
	class SmsListExtractor implements ResultSetExtractor<List<Sms>>{
		
		public List<Sms> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Sms> vList = new ArrayList<Sms>();
			while (rs.next()) {
				vList.add(populate(rs));
			} 
			return vList;
		}
	}
	
	public Sms findById(String id) {
		String sql = "select * from sms where id = ?";
		Sms sms = getJdbcTemplate().query(sql,
				new Object[] { id }, new SmsExtractor());
		return sms;
	}

	public boolean insert(Sms sms) {
		if (sms.getId() != null) return false;
		boolean success = true;
		String id = UUID.randomUUID().toString() + System.currentTimeMillis();
		sms.setId(id);
		String sql = "insert into sms(id, json_data) values(?,?)";
		Gson gson = new Gson();
		int count = getJdbcTemplate().update(sql, id, gson.toJson(sms));
		success = count == 1;
		return success;
	}

	public boolean update(Sms sms) {
		return false;
	}

	public List<Sms> findOutstanding() {
		String sql = "select * from sms";
		List<Sms> smsList = getJdbcTemplate().query(sql,
				new Object[] { }, new SmsListExtractor());
		return smsList;
	}

	private Sms populate(ResultSet rs) throws SQLException {
		Gson gson = new Gson();
		Sms sms = gson.fromJson(rs.getString("json_data"), Sms.class);
		return sms;
	}
	
}
