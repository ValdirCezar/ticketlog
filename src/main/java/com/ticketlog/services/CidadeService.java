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
	
	public List<Cidade> findAllByEstado(Integer id, Double ValorDoDolar) {
		Double valorDoDolar = ValorDoDolar;
		Double custoPorCidadao = 123.45 * valorDoDolar;
		
		List<Cidade> list = repository.findAllByEstado(id);
		
		for (Cidade cidade : list) {
			if(cidade.getPopulacao() < 50001) {
				cidade.setCustoCidadeUS(custoPorCidadao * cidade.getPopulacao());
			} else {
				double aux = ((cidade.getPopulacao() - 50000) * (custoPorCidadao - custoPorCidadao * 0.123)) + (50000 * custoPorCidadao);
				cidade.setCustoCidadeUS(aux);
			}
		}
		return list;
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}


}
