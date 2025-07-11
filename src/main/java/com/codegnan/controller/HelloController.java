package com.codegnan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.entity.Doctor;
import com.codegnan.service.DoctorService;

@RestController

//if we mention controller then we have to mention all other body if restcontroller no need
public class HelloController {
	
	@GetMapping("")
	public String sayHello() {
		return "Hello";
	}
	

	
}
