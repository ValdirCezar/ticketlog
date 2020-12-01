package com.ticketlog.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ticketlog.domain.USD;

@Service
public class USDService {

	// Método para buscar o valor do dolar atualizado
	public String getValorDoDolar() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<USD> dolar = restTemplate.getForEntity("https://economia.awesomeapi.com.br/json/all/USD-BRL", USD.class);

		return dolar.toString();
	}
}
