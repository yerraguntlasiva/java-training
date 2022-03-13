package com.mvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ConfigMvc {
	
	public ConfigMvc() {
		System.out.println("ConfigMvc initlize");
	}
	//@Bean
	public ViewResolver internalResourceViewResolver() {
	    System.out.println("internalResourceViewResolver");
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(ConfigMvc.class);
	    bean.setPrefix("/WEB-INF/");
	    bean.setSuffix(".html");
	    return bean;
	}
}
