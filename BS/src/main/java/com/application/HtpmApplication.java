package com.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("com.*.mapper")
@ComponentScan({"com"})
@EnableScheduling
@EnableCaching
public class HtpmApplication extends SpringBootServletInitializer {

	//tomcat 访问入口
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		// TODO Auto-generated method stub
		return application.sources(HtpmApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HtpmApplication.class, args);
	}
}
