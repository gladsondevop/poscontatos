package com.pos.contatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.contatos.model.Contato;
import com.pos.contatos.repository.ContatoRepository;

@Service
//@Scope
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;

	public List<Contato> listarContatos(){
		return repository.findAll();
	}
	
	public void addContato(Contato contato) {
		repository.save(contato);
	}

}
