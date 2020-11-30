package com.ticketlog.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketlog.domain.Estado;
import com.ticketlog.repositories.EstadoRepository;

@Service
public class DBService {

	@Autowired
	private EstadoRepository estadoRepository;

	public void instantiateTestDatabase() throws ParseException {
		Estado estado1 = new Estado(null, "Rio Grande do Sul");
		Estado estado2 = new Estado(null, "Santa Catarina");
		Estado estado3 = new Estado(null, "Panará");

		estadoRepository.saveAll(Arrays.asList(estado1, estado2, estado3));
	}

}
