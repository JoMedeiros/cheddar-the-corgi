package br.com.logiquesistemas.cheddarthecorgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value="/home")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/teste")
	public String teste() {
		return "Teste";
	}
}