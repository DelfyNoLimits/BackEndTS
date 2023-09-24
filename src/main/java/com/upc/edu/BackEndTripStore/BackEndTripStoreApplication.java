package com.upc.edu.BackEndTripStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackEndTripStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndTripStoreApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://tripstore.netlify.app", "http://localhost:4200/").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
}
