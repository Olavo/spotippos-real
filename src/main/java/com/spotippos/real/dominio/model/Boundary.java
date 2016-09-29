package com.spotippos.real.dominio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Boundary {
	@JsonProperty
	private Point upperLeft;
	@JsonProperty
	private Point bottomRight;
	
	public Boundary() {
	}

	public Boundary(Point upperLeft, Point bottomRight) {
		this.upperLeft = upperLeft;
		this.bottomRight = bottomRight;

	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

}
