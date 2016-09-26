package com.spotippos.real.web.imovel;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotippos.real.dominio.model.Imovel;
import com.spotippos.real.dominio.model.Province;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCriaImovel{

	public ResponseCriaImovel() {
		// TODO Auto-generated constructor stub
	}
	public ResponseCriaImovel(Imovel imovel) {
//		this.id = imovel.getId();
//		this.provinces = imovel.getProvinces();
	}

	@JsonProperty
	private long id;
	@JsonProperty()
	private Collection<Province> provinces = new ArrayList<Province>();
}
