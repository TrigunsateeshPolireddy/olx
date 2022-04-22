package com.zensar.olxlogin.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxlogin.entity.RegisterUser;

@RestController
public class MyController {

	static List<RegisterUser> registeruser = new ArrayList<RegisterUser>();
	@PostMapping("/user")
	public ResponseEntity<RegisterUser> registeruser(@RequestBody RegisterUser registeruser) {
		return new ResponseEntity<RegisterUser>(registeruser, HttpStatus.CREATED);
		
	}
	@GetMapping("/user/{id}")
	public RegisterUser getRegisterUser(@PathVariable int id,@RequestHeader("anand") String token) {
		if(token.equals("anand123")) {
			Optional<RegisterUser> user = registeruser.stream().filter(RegisterUser->RegisterUser.getId()==id).findAny();
			if(user.isPresent()) {
				return user.get();
			}else {
				return user.orElseGet(()->{return new RegisterUser();});
			}
		}
		return null;
}
}
