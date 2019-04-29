package com.credifamilia.start;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = { "com.credifamilia.controller" })
@ComponentScan(basePackages = { "com.credifamilia.dao" })
public class CdtExportApplication {

	public static Logger logger = Logger.getLogger(CdtExportApplication.class.getName());
	
	public static void main(String[] args) {
		try {
			SpringApplication.run(CdtExportApplication.class, args);

		} catch (Exception e) {
			
		}
	}

	@Bean
	public FilterRegistrationBean<CORSFilter> corsFilterRegistration() {
		try {
			FilterRegistrationBean<CORSFilter> registrationBean = new FilterRegistrationBean<CORSFilter>(new CORSFilter());
			registrationBean.setName("CORS Filter");
			registrationBean.addUrlPatterns("/*");
			registrationBean.setOrder(1);
			return registrationBean;

		} catch (Exception e) {
			
		}
		return null;
	}

}
