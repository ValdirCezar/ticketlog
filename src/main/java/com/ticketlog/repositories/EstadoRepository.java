package com.ticketlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketlog.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	Estado findByNome(String nome);
}
