package br.com.logiquesistemas.cheddarthecorgi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logiquesistemas.cheddarthecorgi.dto.UrlLongRequest;
import br.com.logiquesistemas.cheddarthecorgi.model.Url;
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
	
	@GetMapping(value="/urls")
	public List<Url> getUrls() {
		return urlService.getUrls();
	}

	@GetMapping(value="/link/{shortUrl}")
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
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarUrl(@PathVariable Long id) {
		try {
			urlService.deletarUrl(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Url deletada com sucesso.");
		}
		catch (IllegalArgumentException iae) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Url não encontrada");
		}
	}
}
