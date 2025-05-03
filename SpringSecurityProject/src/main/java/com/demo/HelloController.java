package com.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class HelloController {

	@GetMapping("/hello")
	public String great(HttpServletRequest request) {
		
		return "Hello"+ request.getSession().getId();
		
	}
	
	
	
}
