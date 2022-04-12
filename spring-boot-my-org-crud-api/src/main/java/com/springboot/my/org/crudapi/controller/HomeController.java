package com.springboot.my.org.crudapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.util.DateTimeUtilities;

@RestController
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "Hello visitor!\nVisiting time: "+DateTimeUtilities.getTimeStamp();
	}
}