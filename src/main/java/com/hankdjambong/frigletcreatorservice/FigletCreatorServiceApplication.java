package com.hankdjambong.frigletcreatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FigletCreatorServiceApplication {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FigletCreatorServiceApplication.class);
        app.addListeners(new ApplicationPidFileWriter("fcs-shutdown.pid"));
        app.run(args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST")
						.allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}
}
