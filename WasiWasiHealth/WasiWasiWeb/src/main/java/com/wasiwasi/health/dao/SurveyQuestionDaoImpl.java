package com.wasiwasi.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.wasiwasi.health.model.SurveyQuestion;

public class SurveyQuestionDaoImpl extends AbstractDao implements SurveyQuestionDao {

	private static final Logger log = Logger.getLogger(SurveyDaoImpl.class);
	
	class SurveyExtractor implements ResultSetExtractor<SurveyQuestion>{

		public SurveyQuestion extractData(ResultSet rs) throws SQLException, DataAccessException {
			if (rs.next()) {
				return populate(rs);
			} else {
				return null;
			}
		}
	}
	
	class SurveyListExtractor implements ResultSetExtractor<List<SurveyQuestion>>{
		
		public List<SurveyQuestion> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<SurveyQuestion> vList = new ArrayList<SurveyQuestion>();
			while (rs.next()) {
				vList.add(populate(rs));
			} 
			return vList;
		}
	}
	
	public boolean insert(SurveyQuestion question) {
		if (question.getId() != null && !question.getId().isEmpty()) return false;
		boolean success = true;
		String id = UUID.randomUUID().toString() + System.currentTimeMillis();
		question.setId(id);
		String json = getGson().toJson(question);
		String sql = "insert into survey_question(id, survey_id, json_data " +
					 ") values(?,?,?)";
		int count = getJdbcTemplate().update(sql, id, 
				question.getSurveyId(), json);
		
		success = count == 1;
		if (success) question.setId(id);
		log.info("SurveyQuestion insert success ? " + success + " new SurveyQuestion ");
		return success;
	}

	public boolean update(SurveyQuestion question) {
		if (question.getId() != null && !question.getId().isEmpty()) return false;
		boolean success = true;
		String json = getGson().toJson(question);
		String sql = "update survey_question set json_data = ?  where id = ?";
		int count = getJdbcTemplate().update(sql, json, question.getId());
		
		success = count == 1;
		log.info("SurveyQuestion update success ? " + success);
		return success;
	}

	public SurveyQuestion findById(String id) {
		return null;
	}

	public List<SurveyQuestion> findAll(String surveyId) {
		String sql = "select * from survey_question where survey_id = ?";
		List<SurveyQuestion> surveyList = getJdbcTemplate().query(sql,
				new Object[] { surveyId }, new SurveyListExtractor());
		return surveyList;
	}
	
	private SurveyQuestion populate(ResultSet rs) throws SQLException {
		String json = rs.getString("json_data");
		SurveyQuestion question = getGson().fromJson(json, SurveyQuestion.class);
		return question;
	}
}
