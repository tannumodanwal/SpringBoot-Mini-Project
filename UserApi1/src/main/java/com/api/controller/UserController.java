package com.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.User;

@RestController
public class UserController {
	
	
	@GetMapping
	public String sayHello() {
		return "Hello";
	}

	
	List<User> users = new ArrayList<>();
	
	
	@PostMapping("/user")
	public String  addUser(@RequestBody User user) {
		users.add(user);
		return "insert user";
	}
	
	@GetMapping("/users")
	public List getUsers() {
		return users;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		for(User u:users) {
			if(u.getId()==id) {
				return ResponseEntity.ok(u);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		for(User u:users) {
			if(u.getId()==id) {
				users.remove(u);
				return ResponseEntity.ok("Delete SuccessFully");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found");
	}
	
}
