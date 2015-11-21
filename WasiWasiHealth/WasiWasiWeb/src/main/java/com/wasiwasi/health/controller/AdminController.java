package com.wasiwasi.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wasiwasi.health.service.AdminService;

@Controller
public class AdminController extends AbstractWasiController {

	@Autowired AdminService adminService;
	
	@RequestMapping(value ="/admin", method = RequestMethod.GET)
    public String initProvider(ModelMap model) {
//		String user = getPrincipal();
//		Admin admin = adminService.findByUser(user);
//		model.addAttribute("userId", admin.getId());
		return "admin";
    }	
}
