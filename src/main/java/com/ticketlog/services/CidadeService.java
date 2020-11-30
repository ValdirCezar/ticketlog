package com.ticketlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketlog.domain.Cidade;
import com.ticketlog.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repository.save(obj);
	}

}
