package com.pos.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.contatos.model.Contato;
import com.pos.contatos.service.ContatoService;

@Controller
@RequestMapping("contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping
	public ResponseEntity<List<Contato>> listarContatos() {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.listarContatos());
	}

}
