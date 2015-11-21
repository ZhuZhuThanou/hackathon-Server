package com.wasiwasi.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.wasiwasi.health.model.HealthCareProvider;

public class HealthCareProviderDaoImpl extends AbstractDao implements HealthCareProviderDao {
	
	
	private static final Logger log = Logger.getLogger(HealthCareProviderDaoImpl.class);
	
	class VendorExtractor implements ResultSetExtractor<HealthCareProvider>{

		public HealthCareProvider extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				return populate(rs);
			} else {
				return null;
			}
		}
	}
	
	class MemberListExtractor implements ResultSetExtractor<List<HealthCareProvider>>{
		
		public List<HealthCareProvider> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<HealthCareProvider> vList = new ArrayList<HealthCareProvider>();
			while (rs.next()) {
				vList.add(populate(rs));
			} 
			return vList;
		}
	}
	
	public HealthCareProvider findById(String id) {
		String sql = "select * from vendor where id = ?";
		HealthCareProvider provider = getJdbcTemplate().query(sql,
				new Object[] { id }, new VendorExtractor());
		return provider;
	}

	public HealthCareProvider findByEmail(String email) {
		String sql = "select * from vendor where email = ?";
		HealthCareProvider provider = getJdbcTemplate().query(sql,
				new Object[] { email }, new VendorExtractor());
		return provider;
	}

	public boolean insert(HealthCareProvider provider) {
		if (provider.getId() != null) return false;
		boolean success = true;
		String id = UUID.randomUUID().toString() + System.currentTimeMillis();
		provider.setId(id);
		String sql = "insert into vendor(id, name, email, country, active, member_json) values(?,?,?,?,?,?)";
		String json = getGson().toJson(provider, HealthCareProvider.class);
		int count = getJdbcTemplate().update(sql, id, json);
		
		success = count == 1;
		
		if (success) provider.setId(id);
		log.info("vendor insert success ? " + success + " new vendor " + provider.getEmail());
		return success;
	}

	public boolean update(HealthCareProvider provider) {
		if (provider.getId() == null) return false;
		boolean success = true;
		String sql = "update vendor set name = ?, email = ?, country = ?," +
				" active = ?, member_json = ? where id = ?";
		String json = getGson().toJson(provider, HealthCareProvider.class);
		int count = getJdbcTemplate().update(sql, json, provider.getId());
		
		success = count == 1;
		log.info("vendor update success ? " + success);
		return success;
	}

	
	private HealthCareProvider populate(ResultSet rs) throws SQLException {
		String json = rs.getString("member_json");
		return getGson().fromJson(json, HealthCareProvider.class);
	}
}
