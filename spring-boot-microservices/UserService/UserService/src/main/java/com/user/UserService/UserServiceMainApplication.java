package com.user.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages="com.controller")
@EnableEurekaClient
public class UserServiceMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceMainApplication.class, args);
	}

	
}
