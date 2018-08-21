package com.matt.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.matt"})
//@EnableJpaRepositories({"com.matt"})
//@EntityScan({"com.matt"})
public class SpringBootApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApplication.class);
	}
	
	public static void main(String [] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

}
