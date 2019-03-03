package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.User;
import com.utilities.Constants;
import com.utilities.IsValidUser;
import com.utilities.OutputStatus;

@RestController
public class AuthenticationController {

	@Autowired
	private WebClient.Builder client ;

	private static Map<String, Object> inMemCache = new HashMap<String, Object>();

	@PostMapping("/authenticate")
	public OutputStatus authenticate(@RequestBody User user) {
		OutputStatus outputStatus = new OutputStatus();

		String key = checkUserExist(user);
		if (key != null) {
			System.out.println("logged in");
			outputStatus.setOutputCode(Constants.OUTPUT_CODE_SUCCESS);
			outputStatus.setOutputStatus(Constants.SUCCESS);
			outputStatus.setData(key);

			System.out.println("inMemCache --- " + inMemCache);
		}
		return outputStatus;
	}

	@PostMapping("/logout")
	public OutputStatus logout(@RequestBody IsValidUser isValidUser) {
		OutputStatus outputStatus = new OutputStatus();

		if (inMemCache.containsKey(isValidUser.getKey())) {
			inMemCache.remove(isValidUser.getKey());
			System.out.println("inMemCache --- " + inMemCache);
			outputStatus.setData(true);
			outputStatus.setOutputCode(Constants.OUTPUT_CODE_SUCCESS);
			outputStatus.setOutputStatus(Constants.SUCCESS);
		}
		return outputStatus;
	}

	@PostMapping("/isValidUser")
	public OutputStatus isValidUser(@RequestBody IsValidUser isValidUser) {
		OutputStatus outputStatus = new OutputStatus();
		String key = isValidUser.getKey();
		if (inMemCache.containsKey(key)) {
			outputStatus.setData(true);
			outputStatus.setOutputCode(Constants.OUTPUT_CODE_SUCCESS);
			outputStatus.setOutputStatus(Constants.SUCCESS);
		}
		return outputStatus;
	}

	private String checkUserExist(User user) {
		
		OutputStatus output = client
				.baseUrl("http://userservice/login")
				.build()
				.post()
				.body(BodyInserters.fromObject(user))
				.retrieve().bodyToMono(OutputStatus.class).block();
				
		System.out.println("--------" + output.toString());
		String key = null;
		if (output != null) {
			System.out.println("user not null");
			key = UUID.randomUUID().toString();
			inMemCache.put(key, output.getData());
		}
		return key;
	}

}
