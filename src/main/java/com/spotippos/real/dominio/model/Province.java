package com.spotippos.real.dominio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Province {
	@JsonProperty
	private Boundary boundaries;

	public Province() {

	}

	public Boundary getboundaries() {
		return boundaries;
	}

}
