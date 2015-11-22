package com.wasiwasi.health.model;

import java.util.Date;

public class Survey {
	private String id;
	private String name;
	private boolean isActive;
	private Date activationDate;
	private String createdBy;
	private long createdTs;
	private String modifiedBy;
	private long modifiedTs;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public long getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(long createdTs) {
		this.createdTs = createdTs;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public long getModifiedTs() {
		return modifiedTs;
	}
	public void setModifiedTs(long modifiedTs) {
		this.modifiedTs = modifiedTs;
	}
	
	public void setModifier(String user) {
		if (createdBy == null || createdBy.isEmpty()) {
			createdBy = user;
			createdTs = System.currentTimeMillis();
		} else {
			modifiedBy = user;
			modifiedTs = System.currentTimeMillis();
		}
	}
	
}
