package com.wasiwasi.health.test;

import org.junit.Assert;
import org.junit.Test;

import com.wasiwasi.health.model.Survey;

public class SurveyTest {

	@Test
	public void setModifier_CreatedSet() {
		Survey survey = new Survey();
		survey.setModifier("User");
		Assert.assertEquals("User", survey.getCreatedBy());
		Assert.assertTrue(survey.getCreatedTs() > 0);
		Assert.assertNull(survey.getModifiedBy());
		Assert.assertTrue(survey.getModifiedTs() == 0);
	}
	@Test
	public void setModifier_CreatedSet_Empty_String() {
		Survey survey = new Survey();
		survey.setCreatedBy("");
		survey.setModifier("User");
		Assert.assertEquals("User", survey.getCreatedBy());
		Assert.assertTrue(survey.getCreatedTs() > 0);
		Assert.assertNull(survey.getModifiedBy());
		Assert.assertTrue(survey.getModifiedTs() == 0);
	}
	
	@Test
	public void setModifier_ModifiedSet() {
		Survey survey = new Survey();
		survey.setModifier("User");
		survey.setModifier("AnotherUser");
		Assert.assertEquals("User", survey.getCreatedBy());
		Assert.assertEquals("AnotherUser", survey.getModifiedBy());
	}

}
