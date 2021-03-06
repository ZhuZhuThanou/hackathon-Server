package com.wasiwasi.health.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired MvcConfiguration config;
	@Autowired BeanConfig beanConfig;
	
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(beanConfig.authenticationProvider());
    }
	
	protected void configure(HttpSecurity http) throws Exception {
	       
	      http.authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers("/smsstatus").permitAll()	        
	        .antMatchers("/sms/**").access("hasRole('ADMIN')")
	        .antMatchers("/survey/**").access("hasRole('ADMIN')")
	        .antMatchers("/admin/**").access("hasRole('ADMIN')")
	        .antMatchers("/newsurvey/**").access("hasRole('ADMIN')")
	        .and().formLogin().loginPage("/login")
	        .successHandler(config.loginSuccessHandler())
	        .usernameParameter("ssoId").passwordParameter("password")
	        .and().csrf()
	        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
	    }
}
