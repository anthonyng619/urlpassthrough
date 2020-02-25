package com.antheminc.ep;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class OcpController {
	@PostMapping("/send")
	public ResponseEntity send(@RequestBody(required = false) String body, 
		    HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");

	    HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
	    RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.exchange(request.getHeader("UrlPassthrough"), HttpMethod.POST, httpEntity, String.class);
	}
	
}
