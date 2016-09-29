package com.spotippos.real.web.imovel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotippos.real.dominio.model.Property;

public class ResponseGetPropertiesList {

	public ResponseGetPropertiesList() {
	}

	public ResponseGetPropertiesList(List<Property> properties) {
		super();
		this.properties = properties;
	}

	@JsonProperty
	private List<Property> properties;

	@JsonProperty(value = "foundProperties")
	public Integer getFoundProperties() {
		return properties.size();
	}
}
