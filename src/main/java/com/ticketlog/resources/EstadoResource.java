package com.ticketlog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketlog.domain.Estado;
import com.ticketlog.dtos.EstadoDTO;
import com.ticketlog.services.EstadoService;

@RestController
@RequestMapping("/api/estado")
@CrossOrigin("*")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<EstadoDTO> list = service.findAllFromDTO();
		return ResponseEntity.ok().body(list);
	}

}
