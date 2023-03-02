package com.PrimerTrabajo.Cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteRest {
	
	private RestTemplate restTemplate;

	public ClienteRest() {
		this.restTemplate = new RestTemplate();
	}

	public String get(String url) {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}
}