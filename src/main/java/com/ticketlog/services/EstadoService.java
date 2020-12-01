package com.ticketlog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketlog.domain.Cidade;
import com.ticketlog.domain.Estado;
import com.ticketlog.dtos.EstadoDTO;
import com.ticketlog.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	@Autowired
	private CidadeService cidadeService;
	
	public List<EstadoDTO> findAllFromDTO(Double usd) {
		List<Estado> list = repository.findAll();
		
		for (Estado estado : list) {
			estado.setCidades(listarCidades(estado.getId(), usd));
		}
		
		for (Estado estado : list) {
			estado.setCustoEstadoUS(obterValorGastoPeloEstado(estado.getCidades()));
			estado.setPopulacao(obterPopulacaoDoEstado(estado.getCidades()));
		}
		
		repository.saveAll(list);
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Estado findById(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	
	// Métodos abaixo são para calcular os gastos totais de um estado
	private List<Cidade> listarCidades(Integer idEstado, Double usd) {
		List<Cidade> cidades = cidadeService.findAllByEstado(idEstado, usd);
		Double valorTotal = 0.0;
		for (Cidade cidade : cidades) {
			valorTotal += cidade.getCustoCidadeUS();
		}
		return cidades;
	}
	
	public Double obterValorGastoPeloEstado(List<Cidade> cidades) {
		Double valorTotal = 0.0;
		Integer populacaoTotal = 0;
		for (Cidade cidade : cidades) {
			valorTotal += cidade.getCustoCidadeUS();
			populacaoTotal += cidade.getPopulacao();
		}
		return valorTotal;
	}
	
	public Integer obterPopulacaoDoEstado(List<Cidade> cidades) {
		Integer populacaoTotal = 0;
		for (Cidade cidade : cidades) {
			populacaoTotal += cidade.getPopulacao();
		}
		return populacaoTotal;
	}

}
