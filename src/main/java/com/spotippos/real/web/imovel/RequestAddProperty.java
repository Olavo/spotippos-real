package com.spotippos.real.web.imovel;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestAddProperty {
	public RequestAddProperty() {
	}
	public RequestAddProperty(int x, int y, String title, Double price, String description, int beds, int baths, int squareMeters) {
		this.x = x;
		this.y=y;
		this.title=title;
		this.price=price;
		this.description=description;
		this.beds=beds;
		this.baths=baths;
		this.squareMeters=squareMeters;
				
	}
	@JsonProperty
	private String title;
	@JsonProperty
	private Double price;
	@JsonProperty
	private String description;
	@JsonProperty
	@Range(max=1400, min=0, message= "you don\'t belong to spotippos.")
	private int x;
	@JsonProperty
	@Range(max=1000, min=0, message= "you don\'t belong to spotippos.")
	private int y;
	@JsonProperty
	@Range(max=5, min=1)
	private int beds;
	@JsonProperty
	@Range(max=4, min=1)
	private int baths;
	@JsonProperty
	@Range(max=240, min=20)
	private int squareMeters;
	public String getTitle() {
		return title;
	}
	public Double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getBeds() {
		return beds;
	}
	public int getBaths() {
		return baths;
	}
	public int getSquareMeters() {
		return squareMeters;
	}
	
	

}
