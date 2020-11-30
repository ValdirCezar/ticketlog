package com.ticketlog.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ticketlog.domain.Cidade;
import com.ticketlog.services.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;
	
	@PostMapping
	public ResponseEntity<Cidade> insert(@RequestBody Cidade obj) {
		Cidade newObj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}

}
