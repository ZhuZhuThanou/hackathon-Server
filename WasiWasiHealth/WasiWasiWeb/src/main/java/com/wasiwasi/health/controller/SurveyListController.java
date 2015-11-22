package com.wasiwasi.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wasiwasi.health.model.Admin;
import com.wasiwasi.health.service.AdminService;

@Controller
public class SurveyListController extends AbstractWasiController {

	@Autowired AdminService adminService;
	
	@RequestMapping(value ="/survey", method = RequestMethod.GET)
    public String initSurveyList(ModelMap model) {
		String user = getPrincipal();
		Admin admin = adminService.findByUser(user);
		if (admin != null) {
			model.addAttribute("userId", admin.getId());
			return "survey";
		} else {
			return exitSession();
		}
    }	
}
