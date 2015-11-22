package com.wasiwasi.health.dao;

import java.util.List;

import com.wasiwasi.health.model.Sms;


public interface SmsDao {

	public Sms findById(String id);
	public boolean insert(Sms sms);
	public boolean update(Sms sms);
	public List<Sms> findOutstanding();
	
}
