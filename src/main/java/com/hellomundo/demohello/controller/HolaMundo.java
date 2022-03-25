package com.hellomundo.demohello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
	@GetMapping("hello")
	public String hello() {
		return "Es hora de seguir practicando otra cosa y otros tipos de implementaciones";
	}
}
