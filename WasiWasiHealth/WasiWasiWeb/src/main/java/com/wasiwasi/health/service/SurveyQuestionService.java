package com.wasiwasi.health.service;

import java.util.List;

import com.wasiwasi.health.model.SurveyQuestion;

public interface SurveyQuestionService {
	public boolean save(SurveyQuestion surveyQuestion);
	public List<SurveyQuestion> findAllBy(String surveyId);
}
