package com.ticketlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketlog.domain.Cidade;
import com.ticketlog.domain.Estado;
import com.ticketlog.repositories.CidadeRepository;
import com.ticketlog.repositories.EstadoRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade findById(Integer id) {
		Optional<Cidade> cidade = repository.findById(id);
		return cidade.orElse(null);
	}

	public Cidade insert(Cidade obj, Integer idEstado) {
		List<Cidade> cidades = repository.findAllByEstado(idEstado);
		for (Cidade cidade : cidades) {
			if(cidade.getNome().equals(obj.getNome())) {
				return null;
			}
		}
		
		Estado estado = estadoService.findById(idEstado);
		obj.setId(null);
		obj.setEstado(estado);
		obj = repository.save(obj);
		estado.getCidades().add(obj);
		estadoRepository.save(estado);
		return obj;
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
