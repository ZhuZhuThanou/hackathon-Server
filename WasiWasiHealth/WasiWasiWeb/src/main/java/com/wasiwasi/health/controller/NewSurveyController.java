package com.wasiwasi.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wasiwasi.health.dto.RestDTO;
import com.wasiwasi.health.model.Admin;
import com.wasiwasi.health.model.Survey;
import com.wasiwasi.health.service.AdminService;
import com.wasiwasi.health.service.SurveyService;

@Controller
public class NewSurveyController extends AbstractWasiController {

	@Autowired AdminService adminService;
	@Autowired SurveyService surveyService;
	
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
}
