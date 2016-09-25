package com.spotippos.real.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotippos.real.dominio.model.Imoveis;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.spotippos.real" })
@SpringBootApplication
public class SpotipposConfiguration {

	@Value("${pasta.configuracao.json.imoveis}")
	String nomeArquivoImoveis;

	private Resource resource;

	public static void main(String[] args) {
		SpringApplication.run(SpotipposConfiguration.class, args);
	}

	@PostConstruct
	public void setUp() throws IOException {
		resource = new ClassPathResource(nomeArquivoImoveis);
	}

	@Bean(name = "imoveis")
	public Imoveis getArquivoImoveis() throws IOException {

		ObjectMapper jsonMapper = new ObjectMapper();
		File jsonFile = resource.getFile();
		return jsonMapper.readValue(jsonFile, new TypeReference<Imoveis>() {});

	}
}
