package com.wasiwasi.health.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wasiwasi.health.dao.SmsDao;
import com.wasiwasi.health.dto.QuestionDTO;
import com.wasiwasi.health.model.Sms;


@RestController
public class SMSController {
	
	private @Autowired SmsDao smsDao;
	
	public static List<Sms> outbox = new ArrayList<Sms>();
	public static List<Sms> inbox = new ArrayList<Sms>();

	
	@RequestMapping(value = "/sms/inbox", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String saveSms(@RequestBody Sms sms) {
		inbox.add(sms);
		return "OK";
	}
	
	@RequestMapping(value = "/smsquestion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String smsQuestion(@RequestBody QuestionDTO qDto) {
		Sms sms = new Sms();
		sms.setMessage(qDto.getQuestion());
		sms.setPhoneNumber("+16138786512");
		sms.setQuestionId(UUID.randomUUID().toString());
		smsDao.insert(sms);
		return "OK";
	}
	
	@RequestMapping(value ="/smsstatus", method = RequestMethod.GET)
	@ResponseBody
	public List<Sms> outstandingSms() {
		return smsDao.findOutstanding();
	}	
	
	@RequestMapping(value ="/smsoutbox", method = RequestMethod.GET)
	@ResponseBody
	public Sms getSmsOutbox() {
		if (outbox.isEmpty()) {
			return new Sms();
		} else {
			Sms sms = outbox.remove(0);
			return sms;
		}
	}	
	
	
}
