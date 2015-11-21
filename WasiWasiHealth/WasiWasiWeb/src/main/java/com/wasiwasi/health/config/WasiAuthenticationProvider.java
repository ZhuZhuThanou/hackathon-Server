package com.wasiwasi.health.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.wasiwasi.health.dao.HealthCareProviderDao;
import com.wasiwasi.health.model.HealthCareProvider;

public class WasiAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private HealthCareProviderDao careProviderDao;
	
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String userName = auth.getName();
		String pwd = auth.getCredentials().toString();
		HealthCareProvider provider = careProviderDao.findByEmail(userName);
		//if (provider != null && provider.getPwd().equals(pwd)) {
			List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
			GrantedAuthority ga = new SimpleGrantedAuthority("ROLE_PROVIDER");
			gaList.add(ga);
			return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), null, gaList);					
//		} else {
//			throw new BadCredentialsException("Invalid User Id or Password");
//		}
	}

	public boolean supports(Class<?> arg) {
		return UsernamePasswordAuthenticationToken.class.equals(arg);
	}

	public void setVendorDao(HealthCareProviderDao vendorDao) {
		this.careProviderDao = vendorDao;
	}
}
