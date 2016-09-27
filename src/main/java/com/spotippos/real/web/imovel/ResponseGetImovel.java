package com.spotippos.real.web.imovel;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotippos.real.dominio.model.Imovel;

public class ResponseGetImovel {

	@JsonProperty
	private Integer id;
	@JsonProperty
	private String title;
	@JsonProperty
	private Double price;
	@JsonProperty
	private String description;
	@JsonProperty
	private int y;
	@JsonProperty("long")
	private int x;
	@JsonProperty
	private int beds;
	@JsonProperty
	private int baths;
	@JsonProperty
	private Collection<String> provinces = new ArrayList<String>();
	@JsonProperty
	private int squareMeters;

	public ResponseGetImovel(Imovel imovel) {

		this.id = imovel.getId();
		this.title = imovel.getTitle();
		this.price = imovel.getPrice();
		this.description = imovel.getDescription();
		this.y = imovel.getLat();
		this.x = imovel.getLongi();
		this.beds = imovel.getBeds();
		this.baths = imovel.getBaths();
		this.provinces = imovel.getProvinces();
		this.squareMeters = imovel.getSquareMeters();

	}

}
