package com.wasiwasi.health.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.Gson;
import com.wasiwasi.health.dao.AdminDao;
import com.wasiwasi.health.dao.AdminDaoImpl;
import com.wasiwasi.health.dao.HealthCareProviderDao;
import com.wasiwasi.health.dao.HealthCareProviderDaoImpl;
import com.wasiwasi.health.dao.SmsDao;
import com.wasiwasi.health.dao.SmsDaoImpl;
import com.wasiwasi.health.dao.SurveyDao;
import com.wasiwasi.health.dao.SurveyDaoImpl;
import com.wasiwasi.health.dao.SurveyQuestionDao;
import com.wasiwasi.health.dao.SurveyQuestionDaoImpl;
import com.wasiwasi.health.service.AdminService;
import com.wasiwasi.health.service.AdminServiceImpl;
import com.wasiwasi.health.service.SurveyQuestionService;
import com.wasiwasi.health.service.SurveyQuestionServiceImpl;
import com.wasiwasi.health.service.SurveyService;
import com.wasiwasi.health.service.SurveyServiceImpl;

@Configuration
public class BeanConfig {
	@Autowired MvcConfiguration config;
	
	@Bean
    public View jsonTemplate() {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }
     
    @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
    	return new WasiAuthenticationProvider();
    }
	
    @Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/wasiwasidb");
		ds.setUsername("wasiwasi");
		ds.setPassword("qweasdzxc123");
		ds.setRemoveAbandoned(true);
		ds.setInitialSize(10);
		ds.setMaxActive(30);
		return ds;
	}
    
    
    @Bean
    public AdminDao adminDao() {
    	AdminDaoImpl dao = new AdminDaoImpl();
    	dao.setDataSource(dataSource());
    	dao.setGson(gson());
    	return dao;
    }
    
    @Bean
    public HealthCareProviderDao careProviderDao() {
    	HealthCareProviderDaoImpl dao = new HealthCareProviderDaoImpl();
    	dao.setDataSource(dataSource());
    	dao.setGson(gson());
    	return dao;
    }
    
    @Bean
    public SurveyDao surveyDao() {
    	SurveyDaoImpl dao = new SurveyDaoImpl();
    	dao.setDataSource(dataSource());
    	dao.setGson(gson());
    	return dao;
    }
    
    @Bean
    public SurveyQuestionDao surveyQuestionDao() {
    	SurveyQuestionDaoImpl dao = new SurveyQuestionDaoImpl();
    	dao.setDataSource(dataSource());
    	dao.setGson(gson());
    	return dao;
    }
    @Bean
    public SmsDao smsDao() {
    	SmsDaoImpl dao = new SmsDaoImpl();
    	dao.setDataSource(dataSource());
    	dao.setGson(gson());
    	return dao;
    }
    @Bean 
    public Gson gson() {
    	return new Gson();
    }
    
    /** 
     * Services
     */
    @Bean
    public AdminService adminService() {
    	return new AdminServiceImpl();
    }
    
    @Bean
    public SurveyService surveyService() {
    	return new SurveyServiceImpl();
    }
    
    @Bean
    public SurveyQuestionService surveyQuestionService() {
    	return new SurveyQuestionServiceImpl();
    }
}
