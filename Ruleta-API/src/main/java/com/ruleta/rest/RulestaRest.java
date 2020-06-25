package com.ruleta.rest;

import javax.xml.ws.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruleta.entity.User;

@RestController
@RequestMapping("user")
public class RulestaRest {

	
	
	@GetMapping
	public ResponseEntity<User> getUser(){
		User user=new User();
		user.setId("1");
		user.setName("Karl");
		user.setLastName("Smith");
		user.setPassword("karl050");
		user.setEmail("karl_S@gmail.com");
		user.setCoins(5000);
		
		return ResponseEntity.ok(user);
	}
	
	//@GetMapping
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		return "This is a test!";
	}

}
