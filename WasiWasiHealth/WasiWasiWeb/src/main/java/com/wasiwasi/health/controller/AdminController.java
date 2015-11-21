package com.wasiwasi.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController extends AbstractWasiController {

	
	
	@RequestMapping(value ="/admin/providers", method = RequestMethod.GET)
    public String initProvider(ModelMap model) {
//		String user = getPrincipal();
//		HealthCareProvider provider = vendorDao.findByEmail(user);
//		model.addAttribute("vendorId", vendor.getId());
//		model.addAttribute("vendorName", vendor.getName());
//		model.addAttribute("vendorCountry", vendor.getCountry());
//		model.addAttribute("vendorCountryCode", vendor.getCountryCode());
		return "providers";
    }	
}
