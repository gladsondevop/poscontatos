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
	
	public Contato saveContato(Contato contato) {
		return repository.save(contato);
	}
	
	public void deleleContato(Contato contato) {
		repository.delete(contato);
	}

}
