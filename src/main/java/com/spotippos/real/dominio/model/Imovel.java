package com.spotippos.real.dominio.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Imovel {
	
	@JsonProperty
	private Integer id;
	@JsonProperty
	private String title;
	@JsonProperty
	private Double price;
	@JsonProperty
	private String description;
	@JsonProperty
	private int lat;
	@JsonProperty("long")
	private int longi;
	@JsonProperty
	private int beds;
	@JsonProperty
	private int baths;
	@JsonProperty
	private int squareMeters;
	
	public Imovel() {
	}
	
	public Imovel(String title, Double price, String description, int lat, int longi, int beds, int baths, int squareMeters) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.lat = lat;
		this.longi = longi;
		this.beds = beds;
		this.baths = baths;
		this.squareMeters = squareMeters;
	}

	@JsonEnumDefaultValue
	private Collection<Province> provinces = new ArrayList<Province>();

	public Integer getId() {
		return this.id;
	}

	public Collection<Province> getProvinces() {
		return provinces;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
}
