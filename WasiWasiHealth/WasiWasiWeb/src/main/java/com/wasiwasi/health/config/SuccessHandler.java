package com.wasiwasi.health.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication autho) throws IOException, ServletException {
		resp.sendRedirect(req.getContextPath() + "/provider");
	}
}
