package com.ticketlog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ticketlog.domain.Cidade;
import com.ticketlog.services.CidadeService;

@RestController
@RequestMapping("/api/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;
	
	@PostMapping()
	public ResponseEntity<Cidade> insert(@RequestBody Cidade obj) {
		Cidade newObj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	@GetMapping("/estado={id}")
	public ResponseEntity<List<Cidade>> findAllByEstado(@PathVariable Integer id) {
		List<Cidade> list = service.findAllByEstado(id);
		return ResponseEntity.ok().body(list);
	}

}
