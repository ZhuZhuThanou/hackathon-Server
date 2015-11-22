package com.wasiwasi.health.dao;

import java.util.List;

import com.wasiwasi.health.model.Survey;

public interface SurveyDao {
	public boolean insert(Survey survey);
	public boolean update(Survey survey);
	public Survey findById(String id);
	public List<Survey> findAllActive();
}
