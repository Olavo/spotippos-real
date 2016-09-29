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
import com.spotippos.real.dominio.model.Properties;
import com.spotippos.real.dominio.model.Province;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.spotippos.real.*" })
@SpringBootApplication
public class SpotipposConfiguration {

	@Value("${pasta.configuracao.json.imoveis}")
	private String propertiesFileName;

	@Value("${pasta.configuracao.json.provinces}")
	private String provincesFileName;

	private Resource resource;

	public static void main(String[] args) {
		SpringApplication.run(SpotipposConfiguration.class, args);
	}

	@Bean(name = "properties")
	public Properties getPropertiesFile() throws IOException {
		resource = new ClassPathResource(propertiesFileName);
		File jsonFile = resource.getFile();
		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.readValue(jsonFile, new TypeReference<Properties>() {
		});

	}
	
	@Bean(name = "provinces")
	public HashMap<String, Province> getProvincesFile() throws IOException {
		resource = new ClassPathResource(provincesFileName);
		File jsonFile = resource.getFile();
		ObjectMapper jsonMapper = new ObjectMapper();
		HashMap<String, Province> provinces =jsonMapper.readValue(jsonFile,new TypeReference<HashMap<String, Province>>() {
		});
		
		provinces.forEach((String, Province) -> {
			
			Province.setProvinceNome(String);
			
		});
		
		return provinces;

	}

}
