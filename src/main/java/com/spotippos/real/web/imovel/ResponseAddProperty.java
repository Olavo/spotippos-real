package com.spotippos.real.web.imovel;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotippos.real.dominio.model.Property;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAddProperty{

	public ResponseAddProperty() {
	}
	public ResponseAddProperty(Property imovel) {
		this.id = imovel.getId();
		this.provinces = imovel.getProvinces();
	}

	@JsonProperty
	private long id;
	@JsonProperty()
	private Collection<String> provinces = new ArrayList<String>();
}
