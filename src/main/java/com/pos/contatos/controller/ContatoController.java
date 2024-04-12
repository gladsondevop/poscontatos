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

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Controller
@RequestMapping("contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	private final MeterRegistry meterRegistry;
	
	public ContatoController(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	@GetMapping
	public ResponseEntity<List<Contato>> listarContatos() {
		Counter counter = Counter.builder("quantidade_acessos").tag("acessos_contatos", "getAll")
				.description("Quantidades de acessos para consultar todos os contatos").register(meterRegistry);
		counter.increment();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.listarContatos());
	}

}
