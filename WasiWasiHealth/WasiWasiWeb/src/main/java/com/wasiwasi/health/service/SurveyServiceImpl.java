package com.wasiwasi.health.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wasiwasi.health.dao.SurveyDao;
import com.wasiwasi.health.model.Survey;

public class SurveyServiceImpl implements SurveyService {

	@Autowired SurveyDao surveyDao;
	
	public boolean saveSurvey(Survey survey) {
		if (survey.getId() != null && !survey.getId().isEmpty()) {
			return surveyDao.update(survey);
		} else {
			survey.setId(null);
			return surveyDao.insert(survey);
		}
	}

}
