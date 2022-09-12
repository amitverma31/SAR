package com.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SarUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(SarUserApplication.class, args);
	}

	//create RestTemplate
	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}
}
