package com.hellospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hellospring")
@EntityScan("com.hellospring")
public class HellospringApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HellospringApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx) {
		return args -> {
			System.out.println("All beans :");
			String[] beanNames = ctx.getBeanDefinitionNames();
			for(String bean : beanNames) {
				System.out.println(bean);
			}
		};
	}
	
	
}
