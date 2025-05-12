package com.sg.ai.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sg.ai.user.User;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@GetMapping("/jblog")
	public User httpGet() {
		User finduser = User.builder().id(1).username("ai").password("222").email("s@s.com").build();
		return finduser;
	}
	
	@PostMapping("/jblog")
	public String httpPost(@RequestBody User user) {
		return "Post request processed" + user.toString();
	}
	
	@PutMapping("/jblog")
	public String httpPut() {
		return "PUT request processed";
	}
	
	@DeleteMapping("/jblog")
	public String httpDelete(@RequestParam int id) {
		return "Delete request processed"+ id;
	}
	
}
