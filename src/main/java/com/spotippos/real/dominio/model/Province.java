package com.spotippos.real.dominio.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Province {

	private String provinceNome;

	@JsonProperty
	private Boundary boundaries;

	public Province() {

	}

	public Boundary getboundaries() {
		return boundaries;
	}

	public void setProvinceNome(String provinceNome) {
		this.provinceNome = provinceNome;
	}

}
