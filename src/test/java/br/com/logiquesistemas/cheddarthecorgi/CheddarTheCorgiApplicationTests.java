package br.com.logiquesistemas.cheddarthecorgi;

//import java.util.Calendar;
//import java.util.Date;

import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import br.com.logiquesistemas.cheddarthecorgi.dto.UrlLongRequest;
//import br.com.logiquesistemas.cheddarthecorgi.service.UrlService;

@SpringBootTest
class CheddarTheCorgiApplicationTests {

//	private String url;
	//@Autowired
//	private UrlService urlService;
	
	
	@Test
	void contextLoads() {
		/*url = "https://httpstatusdogs.com/";
		UrlLongRequest urlLongRequest = new UrlLongRequest();
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 3);
		
		urlLongRequest.setExpiresDate(c.getTime());
		urlLongRequest.setLongUrl(url);
		
		String shortUrl = urlService.convertToShortUrl(urlLongRequest);
		String originalUrl;
		try {
			originalUrl = urlService.getOriginalUrl(shortUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		assert(originalUrl.equals(url));*/
	}

}
