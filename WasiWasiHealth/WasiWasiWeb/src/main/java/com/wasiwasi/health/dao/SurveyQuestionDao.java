package com.wasiwasi.health.dao;

import java.util.List;

import com.wasiwasi.health.model.SurveyQuestion;

public interface SurveyQuestionDao {

	public boolean insert(SurveyQuestion question);
	public boolean update(SurveyQuestion question);
	public SurveyQuestion findById(String id);
	public List<SurveyQuestion> findAll(String surveyId);
	
}
