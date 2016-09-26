package com.spotippos.real.dominio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Boundary {
	@JsonProperty
	private Ponto upperLeft;
	@JsonProperty
	private Ponto bottomRight;
	
	public Boundary() {
		// TODO Auto-generated constructor stub
	}

	public Boundary(Ponto upperLeft, Ponto bottomRight) {
		this.upperLeft = upperLeft;
		this.bottomRight = bottomRight;

	}

	public Ponto getUpperLeft() {
		return upperLeft;
	}

	public Ponto getBottomRight() {
		return bottomRight;
	}

}
