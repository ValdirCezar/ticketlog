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
		Estado estado3 = new Estado(null, "Panará");
		
		Cidade c1 = new Cidade(null, "Curitiba");
		Cidade c2 = new Cidade(null, "Londrina");
		Cidade c3 = new Cidade(null, "Maringá");
		Cidade c4 = new Cidade(null, "Assaí");
		
		estado3.getCidades().addAll(Arrays.asList(c1, c2, c3, c4));
		
		c1.setEstado(estado3);
		c2.setEstado(estado3);
		c3.setEstado(estado3);
		c4.setEstado(estado3);

		estadoRepository.saveAll(Arrays.asList(estado1, estado2, estado3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}

}
