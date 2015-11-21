package com.wasiwasi.health.service;

import com.wasiwasi.health.model.Admin;

public interface AdminService {

	public boolean doesAdminExists();
	public boolean addDefaultAdmin();
	public boolean validate(Admin admin);
	public boolean validate(String userName, String pwd);
	public Admin findByUser(String user);
	
}
