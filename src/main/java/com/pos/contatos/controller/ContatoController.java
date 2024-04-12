package com.pos.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		Counter counter = Counter.builder("acessos_lista_contatos").tag("listar_contatos", "listarContatos")
				.description("Quantidades de acessos feitos a lista de contatos.").register(meterRegistry);
		counter.increment();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.listarContatos());
	}
	
	@PostMapping
	public ResponseEntity<Contato> addContato(@RequestBody Contato contato) {
		Counter counter = Counter.builder("acessos_adicionar_contatos").tag("adicionar_contatos", "addContato")
				.description("Quantidades de contatos adicionados.").register(meterRegistry);
		counter.increment();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.saveContato(contato));
	}
	
	@PutMapping
	public ResponseEntity<Contato> editContato(@RequestBody Contato contato) {
		Counter counter = Counter.builder("acessos_atualizar_contatos").tag("atualizar_contatos", "editContato")
				.description("Quantidades de contatos atualizados.").register(meterRegistry);
		counter.increment();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.saveContato(contato));
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteContato(@RequestBody Contato contato) {
		Counter counter = Counter.builder("acessos_deletar_contatos").tag("deletar_contatos", "deleteContato")
				.description("Quantidades de contatos excluídos.").register(meterRegistry);
		counter.increment();
		service.deleleContato(contato);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Contato excluído com sucesso!");
	}

}
