package com.pos.contatos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pos.contatos.model.Contato;

@Service
@Scope
public class ContatoService {
	
	private List<Contato> contatos = new ArrayList<>();
	
	public List<Contato> getContatos() {
		return contatos;
	}

	public List<Contato> listarContatos(){
		return contatos;
	}

}
