package com.wasiwasi.health.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wasiwasi.health.dao.AdminDao;
import com.wasiwasi.health.model.Admin;

public class AdminServiceImpl implements AdminService {

	private static final Logger log = Logger.getLogger(AdminServiceImpl.class);
	
	@Autowired AdminDao adminDao;
	
	public boolean doesAdminExists() {
		return adminDao.count() > 0;
	}

	public boolean addDefaultAdmin() {
		Admin admin = new Admin();
		admin.setEmail("admin@sample.com");
		admin.setUid("admin");
		admin.setPassword("admin");
		log.info("**** Created Default User ****");
		return adminDao.insert(admin);
	}

	public boolean validate(Admin admin) {
		return false;
	}

	public boolean validate(String userName, String pwd) {
		Admin admin = adminDao.findByUid(userName);
		return admin != null && admin.getPassword().equals(pwd);
	}

	public Admin findByUser(String userId) {
		Admin user= adminDao.findByUid(userId);
		return user;
	}

}
