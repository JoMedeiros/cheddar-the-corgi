package br.com.logiquesistemas.cheddarthecorgi.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logiquesistemas.cheddarthecorgi.dto.UrlLongRequest;
import br.com.logiquesistemas.cheddarthecorgi.model.Url;
import br.com.logiquesistemas.cheddarthecorgi.repository.UrlRepository;

@Service
public class UrlService {

	private final UrlRepository urlRepository;
	private final BaseConversion baseConversion;
	
	public UrlService(UrlRepository urlRepository, 
			BaseConversion baseConversion) {
		this.urlRepository = urlRepository;
		this.baseConversion = baseConversion;
	}
	
	@Transactional
	public String convertToShortUrl(UrlLongRequest urlLongRequest) {
		Url url = new Url();
		url.setLongUrl(urlLongRequest.getLongUrl());
		url.setCreatedDate(new Date());
		url.setExpiresDate(urlLongRequest.getExpiresDate());
		Url shortUrl = urlRepository.save(url);
		
		return baseConversion.encode(shortUrl.getId());
	}
	
	public String getOriginalUrl(String shortUrl) throws Exception {
		long id = baseConversion.decode(shortUrl);
		Url longUrl = urlRepository.findById(id)
				.orElseThrow(() -> new Exception("Url não encontrada"));
		
		if (longUrl.getExpiresDate() != null && 
				longUrl.getExpiresDate().before(new Date())) {
			urlRepository.delete(longUrl);
			throw new Exception("Link expirou");
		}
		
		return longUrl.getLongUrl();
	}
	
}
