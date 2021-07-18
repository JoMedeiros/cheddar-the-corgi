package br.com.logiquesistemas.cheddarthecorgi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UrlLongRequest {

	private String longUrl;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date expiresDate;

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public Date getExpiresDate() {
		return expiresDate;
	}

	public void setExpiresDate(Date expiresDate) {
		this.expiresDate = expiresDate;
	}
	
}
