package com.spotippos.real.dominio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ponto {
	@JsonProperty
	private int x;
	@JsonProperty
	private int y;

	public Ponto() {
		// TODO Auto-generated constructor stub
	}

	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
