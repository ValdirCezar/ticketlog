package com.ticketlog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketlog.domain.Estado;
import com.ticketlog.dtos.EstadoDTO;
import com.ticketlog.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	public List<EstadoDTO> findAllFromDTO() {
		List<Estado> list = repository.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Estado findById(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
