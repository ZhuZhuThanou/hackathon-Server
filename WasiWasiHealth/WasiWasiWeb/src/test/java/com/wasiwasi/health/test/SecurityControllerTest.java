package com.wasiwasi.health.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.wasiwasi.health.controller.SecurityController;

public class SecurityControllerTest {

	@Test
	public void testAccessDenied() {
		SecurityController controller = new SecurityController() {
			@Override
			protected String getPrincipal() {
				return "dummyUser";
			}
		};
		ModelMap modelMap = new ModelMap();
		String view = controller.accessDeniedPage(modelMap);
		Assert.assertEquals("accessDenied", view);
		Assert.assertEquals("dummyUser", modelMap.get("user"));
	}
	
	
}
