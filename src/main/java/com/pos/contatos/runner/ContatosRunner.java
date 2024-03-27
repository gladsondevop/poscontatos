package com.pos.contatos.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.pos.contatos.model.Contato;
import com.pos.contatos.service.ContatoService;

@Configuration
public class ContatosRunner implements ApplicationRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContatosRunner.class);
	
	@Autowired
	private ContatoService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		LOGGER.info("Carregando lista de contatos inicial...");
		
		Contato c1 = new Contato();
		c1.setId(service.getContatos().size()+1);
		c1.setNome("Gladson Cunha de Albuquerque");
		c1.setCelular("61982124468");
		service.getContatos().add(c1);
		
		Contato c2 = new Contato();
		c2.setId(service.getContatos().size()+1);
		c2.setNome("Fulano de Tal da Silva");
		c2.setCelular("61988997755");
		service.getContatos().add(c2);
		
		LOGGER.info("Lista de contatos carregada!");
	}

}
