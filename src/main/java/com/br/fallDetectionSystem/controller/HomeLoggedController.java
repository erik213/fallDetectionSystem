package com.br.fallDetectionSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeLoggedController {

	@RequestMapping("/home-logged")
	public String homeLogged(Model model) {
		return "home-logged";
	}
}
