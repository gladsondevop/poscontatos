package com.pos.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.contatos.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
