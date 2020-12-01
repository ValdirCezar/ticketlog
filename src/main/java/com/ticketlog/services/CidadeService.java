package com.ticketlog.services;

import java.util.List;

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
	
	public List<Cidade> findAllByEstado(Integer id) {
		List<Cidade> list = repository.findAllByEstado(id);
		return list;
	}


}
