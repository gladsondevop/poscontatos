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
		
		if(service.listarContatos().isEmpty()) {
			Contato c1 = new Contato();
			c1.setNome("Gladson Cunha de Albuquerque");
			c1.setCelular("61982124468");
			service.addContato(c1);
			
			Contato c2 = new Contato();
			c2.setNome("Fulano de Tal da Silva");
			c2.setCelular("61988997755");
			service.addContato(c2);
			
			Contato c3 = new Contato();
			c3.setNome("Tiago de Tal da Silva");
			c3.setCelular("61900000000");
			service.addContato(c3);
			
			LOGGER.info("Lista de contatos carregada!");
		} else {
			LOGGER.info("O banco já recebeu a carga inicial!");
		}
		
		
	}

}
