package com.wasiwasi.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wasiwasi.health.dto.RestDTO;
import com.wasiwasi.health.model.Admin;
import com.wasiwasi.health.model.Survey;
import com.wasiwasi.health.model.SurveyQuestion;
import com.wasiwasi.health.service.AdminService;
import com.wasiwasi.health.service.SurveyQuestionService;
import com.wasiwasi.health.service.SurveyService;

@Controller
public class NewSurveyController extends AbstractWasiController {

	@Autowired AdminService adminService;
	@Autowired SurveyService surveyService;
	@Autowired SurveyQuestionService surveyQuestionService;
	
	@RequestMapping(value ="/newsurvey", method = RequestMethod.GET)
    public String initNewSurvey(ModelMap model) {
		String user = getPrincipal();
		Admin admin = adminService.findByUser(user);
		if (admin != null) {
			model.addAttribute("userId", admin.getId());
			return "newsurvey";
		} else {
			return exitSession();
		}
    }	
	
	@RequestMapping(value ="/survey/questions/{surveyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<SurveyQuestion> getSurveyQuestionsBySurveyId(@PathVariable String surveyId) {
		return surveyQuestionService.findAllBy(surveyId);
	}	
	
	
	@RequestMapping(value = "/newsurvey", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RestDTO updateNewSurvey(@RequestBody Survey survey) {
		RestDTO dto = RestDTO.createSuccess();
		String user = getPrincipal();
		survey.setModifier(user);
		boolean success = surveyService.saveSurvey(survey);
		if (success) {
			dto.setMessage("Survey saved");
			dto.setData(survey);
		} else {
			dto.setMessage("Survey failed to save");
		}
		return dto;
	}
	
	@RequestMapping(value = "/newsurvey/question", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RestDTO updateSurveyQuestion(@RequestBody SurveyQuestion surveyQuestion) {
		RestDTO dto = RestDTO.createSuccess();		
		boolean success = surveyQuestionService.save(surveyQuestion);
		List<SurveyQuestion> surveyQuestionList = surveyQuestionService.findAllBy(surveyQuestion.getSurveyId());
		if (success) {
			dto.setMessage("Survey question saved");
			dto.setData(surveyQuestionList);
		} else {
			dto.setMessage("Survey question failed to save");
		}
		return dto;
	}	
}
