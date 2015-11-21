package com.wasiwasi.health.dao;

import com.wasiwasi.health.model.HealthCareProvider;

public interface HealthCareProviderDao {
	
	public HealthCareProvider findById(String id);
	public HealthCareProvider findByEmail(String email);
	public boolean insert(HealthCareProvider provider);
	public boolean update(HealthCareProvider provider);
}
