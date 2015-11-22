package com.wasiwasi.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wasiwasi.health.dao.SurveyQuestionDao;
import com.wasiwasi.health.model.SurveyQuestion;

public class SurveyQuestionServiceImpl implements SurveyQuestionService {

	@Autowired SurveyQuestionDao surveyQuestionDao;
	
	public boolean save(SurveyQuestion surveyQuestion) {
		if (surveyQuestion.getId() == null || surveyQuestion.getId().isEmpty()) {
			return surveyQuestionDao.insert(surveyQuestion);
		} else {
			return surveyQuestionDao.update(surveyQuestion);
		}
	}

	public List<SurveyQuestion> findAllBy(String surveyId) {
		return surveyQuestionDao.findAll(surveyId);
	}

}
