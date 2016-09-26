package com.spotippos.real.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

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
import com.spotippos.real.dominio.model.Boundary;
import com.spotippos.real.dominio.model.Imoveis;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.spotippos.real.*" })
@SpringBootApplication
public class SpotipposConfiguration {

	@Value("${pasta.configuracao.json.imoveis}")
	private String nomeArquivoImoveis;

	@Value("${pasta.configuracao.json.provinces}")
	private String nomeArquivoProvinces;

	private Resource resource;

	public static void main(String[] args) {
		SpringApplication.run(SpotipposConfiguration.class, args);
	}

	@Bean(name = "imoveis")
	public Imoveis getArquivoImoveis() throws IOException {
		resource = new ClassPathResource(nomeArquivoImoveis);
		File jsonFile = resource.getFile();
		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.readValue(jsonFile, new TypeReference<Imoveis>() {
		});

	}

	@Bean(name = "provinces")
	public HashMap<String, Boundary> getArquivoProvinces() throws IOException {
		resource = new ClassPathResource(nomeArquivoProvinces);
		File jsonFile = resource.getFile();
		ObjectMapper jsonMapper = new ObjectMapper();

		HashMap<String, Boundary> provinces =jsonMapper.readValue(jsonFile, HashMap.class);
		
		return provinces;

	}

}
