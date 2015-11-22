package com.wasiwasi.health.model;


public class SurveyQuestion {
	private String id;
	private String surveyId;
	private int order;
	private String question;
	
	private String response1;
	private String response1Key;
	private String response2;
	private String response2Key;
	private String response3;
	private String response3Key;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getResponse1() {
		return response1;
	}
	public void setResponse1(String response1) {
		this.response1 = response1;
	}
	public String getResponse1Key() {
		return response1Key;
	}
	public void setResponse1Key(String response1Key) {
		this.response1Key = response1Key;
	}
	public String getResponse2() {
		return response2;
	}
	public void setResponse2(String response2) {
		this.response2 = response2;
	}
	public String getResponse2Key() {
		return response2Key;
	}
	public void setResponse2Key(String response2Key) {
		this.response2Key = response2Key;
	}
	public String getResponse3() {
		return response3;
	}
	public void setResponse3(String response3) {
		this.response3 = response3;
	}
	public String getResponse3Key() {
		return response3Key;
	}
	public void setResponse3Key(String response3Key) {
		this.response3Key = response3Key;
	}
}
