package com.wasiwasi.health.dao;

import com.wasiwasi.health.model.Admin;

public interface AdminDao {
	public int count();
	public boolean insert(Admin admin);
	public boolean update(Admin admin);
	public Admin findByEmail(String email);
	public Admin findByUid(String uid);
}
