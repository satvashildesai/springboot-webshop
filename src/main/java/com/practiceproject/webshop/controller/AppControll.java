package com.practiceproject.webshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControll {

//	Home page
	@GetMapping("/home")
	public String getHome() {
		return "Welcome Home";
	}
}

//  get 	-->	Retrieve resource 
//  post 	--> 	Create new resource 
//  put 	--> 	Update resource 
//  patch 	-->  	Update single part of resource 
//  delete 	--> 	Delete resource
