package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.UserModel;
import com.utilities.Constants;
import com.utilities.OutputStatus;


@RestController
public class UserController {
	
	public static List<UserModel> users= Arrays.asList(
			new UserModel("user1","user1","1","user1@gmail.com"),
			new UserModel("user2","user2","2","user2@gmail.com"),
			new UserModel("user2","user2","3","user3@gmail.com")
			);
	
	@RequestMapping(value= "/login",method= RequestMethod.POST)
	public OutputStatus isValidUser(@RequestBody UserModel userModel)  {
		OutputStatus outputStatus = new OutputStatus();
		Optional<UserModel> findAny = users.stream().filter(
				checkUser(userModel.getUsername(), userModel.getPassword())
				).findAny();
		System.out.println("User Id---"+findAny.get().getUserid());
		if(findAny.isPresent()) {
			outputStatus.setData(findAny);
			outputStatus.setOutputCode(Constants.OUTPUT_CODE_SUCCESS);
			outputStatus.setOutputStatus(Constants.SUCCESS);
		}
		return outputStatus;
		
	}
	
	@RequestMapping(value= "/listOfUsers",method=RequestMethod.GET)
	public OutputStatus listOfUsers() {
		OutputStatus outputStatus = new OutputStatus();
		outputStatus.setOutputCode(Constants.OUTPUT_CODE_SUCCESS);
		outputStatus.setOutputStatus(Constants.SUCCESS);
		outputStatus.setData(users);
		return outputStatus;
		
	}
	
	@RequestMapping(value= "/hello")
	public String isValidUser() {
		
		return "hello working";
	}
	
	public static Predicate<UserModel> checkUser(String username, String password){
		
		return p-> p.getUsername().equals(username) && p.getPassword().equals(password);
		
	}
	

}
					