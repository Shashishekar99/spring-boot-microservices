package com.authentication.AuthenticationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan(basePackages = { "com.controller"} )
@EnableEurekaClient
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
		
	}
	
	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
	
	
	
}
