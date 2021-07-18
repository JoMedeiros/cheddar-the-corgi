package br.com.logiquesistemas.cheddarthecorgi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logiquesistemas.cheddarthecorgi.dto.UrlLongRequest;
import br.com.logiquesistemas.cheddarthecorgi.service.UrlService;

//import br.com.logiquesistemas.cheddarthecorgi.dto.UrlLongRequest;
//import br.com.logiquesistemas.cheddarthecorgi.service.UrlService;

@RestController
@RequestMapping("/api")
public class UrlController {
	
	@Autowired
	private UrlService urlService;
	
	@PostMapping(value="/gerarUrl")
	public String gerarUrlCurta(@RequestBody UrlLongRequest request) {
		return urlService.convertToShortUrl(request);
	}

	@GetMapping(value="/{shortUrl}")
	public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
		String url;
		try {
			url = urlService.getOriginalUrl(shortUrl);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND)
				.location(URI.create(url))
				.build();
	}
	/*
	@Autowired
	private UrlService urlService;

	@PostMapping("/gerarUrl")
	public String gerarUrlCurta(@RequestBody UrlLongRequest request) {
		return urlService.convertToShortUrl(request);
	}
	
	@GetMapping(value="/{shortUrl}")
	public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
		String url;
		try {
			url = urlService.getOriginalUrl(shortUrl);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND)
				.location(URI.create(url))
				.build();
	}
	
	@GetMapping(value="/teste")
	public String teste() {
		return "Teste";
	}*/
}
