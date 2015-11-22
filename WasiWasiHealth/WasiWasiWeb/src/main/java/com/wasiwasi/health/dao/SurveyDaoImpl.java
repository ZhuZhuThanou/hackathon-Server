package com.wasiwasi.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.wasiwasi.health.model.Survey;

public class SurveyDaoImpl extends AbstractDao implements SurveyDao {

	private static final Logger log = Logger.getLogger(SurveyDaoImpl.class);
	
	class SurveyExtractor implements ResultSetExtractor<Survey>{

		public Survey extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				return populate(rs);
			} else {
				return null;
			}
		}
	}
	
	class SurveyListExtractor implements ResultSetExtractor<List<Survey>>{
		
		public List<Survey> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Survey> vList = new ArrayList<Survey>();
			while (rs.next()) {
				vList.add(populate(rs));
			} 
			return vList;
		}
	}
	
	public boolean insert(Survey survey) {
		if (survey.getId() != null && !survey.getId().isEmpty()) return false;
		boolean success = true;
		String id = UUID.randomUUID().toString() + System.currentTimeMillis();
		survey.setId(id);
		survey.setActive(true);
		String sql = "insert into survey(id, name, active, activation_date, " +
					 "created_by, created_ts, modified_by, modified_ts) " +
						"values(?,?,?,?,?,?,?,?)";
		int count = getJdbcTemplate().update(sql, id, 
				survey.getName(), survey.isActive(),
				survey.getActivationDate(), survey.getCreatedBy(),
				new Timestamp(survey.getCreatedTs()), survey.getModifiedBy(), null);
		
		success = count == 1;
		if (success) survey.setId(id);
		log.info("survey insert success ? " + success + " new survey " + survey.getName());
		return success;
	}

	public boolean update(Survey survey) {
		if (survey.getId() == null || survey.getId().isEmpty()) return false;
		boolean success = true;
		String sql = "update survey set name = ?, active = ?, activation_date = ?, " +
					 "modified_by = ?, modified_ts = ? where id = ?";
		int count = getJdbcTemplate().update(sql,
				survey.getName(), survey.isActive(),
				survey.getActivationDate(), survey.getCreatedBy(),
				new Timestamp(survey.getModifiedTs()), survey.getId());
		
		success = count == 1;
		log.info("survey update success ? " + success + " update survey " + survey.getName());
		return success;
	}

	public Survey findById(String id) {
		String sql = "select * from survey where id = ?";
		Survey survey = getJdbcTemplate().query(sql,
				new Object[] { id }, new SurveyExtractor());
		return survey;
	}
	public List<Survey> findAllActive() {
		String sql = "select * from survey where active = true order by activation_date";
		List<Survey> surveyList = getJdbcTemplate().query(sql,
				new Object[] { }, new SurveyListExtractor());
		return surveyList;
	}
	
	private Survey populate(ResultSet rs) throws SQLException {
		Survey survey = new Survey();
		survey.setId(rs.getString("id"));
		survey.setName(rs.getString("name"));
		survey.setActive(rs.getBoolean("active"));
		survey.setActivationDate(new Date(rs.getDate("activation_date").getTime()));
		survey.setCreatedBy(rs.getString("created_by"));
		survey.setCreatedTs(rs.getLong("create_ts"));
		survey.setCreatedBy(rs.getString("modified_by"));
		survey.setCreatedTs(rs.getLong("modified_ts"));
		return survey;
	}

}
