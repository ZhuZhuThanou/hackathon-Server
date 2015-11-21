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
import com.wasiwasi.health.dao.HealthCareProviderDao;
import com.wasiwasi.health.dao.HealthCareProviderDaoImpl;

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
		ds.setUrl("jdbc:postgresql://localhost:5432/hipposdb");
		ds.setUsername("hiplp");
		ds.setPassword("qweasdzxc");
		ds.setRemoveAbandoned(true);
		ds.setInitialSize(10);
		ds.setMaxActive(30);
		return ds;
	}
    
    
    @Bean
    public HealthCareProviderDao careProviderDao() {
    	HealthCareProviderDaoImpl dao = new HealthCareProviderDaoImpl();
    	dao.setDataSource(dataSource());
    	dao.setGson(gson());
    	return dao;
    }
    
    
    @Bean 
    public Gson gson() {
    	return new Gson();
    }
}
