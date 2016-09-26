package com.spotippos.real.dominio.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
@JsonIgnoreProperties(ignoreUnknown = true)
public class Imoveis {

	@JsonProperty
	private Integer totalProperties;
	@JsonProperty
	private List<Imovel> properties = new ArrayList<Imovel>();

	public List<Imovel> getProperties() {
		return properties;
	}

	public Imovel adicionar(Imovel imovel) {
		imovel.setId(+totalProperties);
		properties.add(imovel);
		return imovel;
	}

}
