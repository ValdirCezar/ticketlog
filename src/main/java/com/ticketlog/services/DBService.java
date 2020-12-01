package com.ticketlog.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketlog.domain.Cidade;
import com.ticketlog.domain.Estado;
import com.ticketlog.repositories.CidadeRepository;
import com.ticketlog.repositories.EstadoRepository;

@Service
public class DBService {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public void instantiateTestDatabase() throws ParseException {

		Estado estado1 = new Estado(null, "Rio Grande do Sul");
		Estado estado2 = new Estado(null, "Santa Catarina");
		Estado estado3 = new Estado(null, "Paraná");

		Cidade c1 = new Cidade(null, "Curitiba", 1000);
		Cidade c2 = new Cidade(null, "Londrina", 1500);
		Cidade c3 = new Cidade(null, "Maringá", 500);
		Cidade c4 = new Cidade(null, "Assaí", 50001);
		Cidade c5 = new Cidade(null, "Itapoá", 1000);

		estado3.getCidades().addAll(Arrays.asList(c1, c2, c3, c4));

		c1.setEstado(estado3);
		c2.setEstado(estado3);
		c3.setEstado(estado3);
		c4.setEstado(estado3);
		c5.setEstado(estado2);

		estadoRepository.saveAll(Arrays.asList(estado1, estado2, estado3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

	}

}
