package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/")
	String testController() {
		System.out.println("Hello World");
		
		return "Hello World";
	}
}
