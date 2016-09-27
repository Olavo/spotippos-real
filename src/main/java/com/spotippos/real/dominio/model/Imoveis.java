package com.spotippos.real.dominio.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotippos.real.dominio.service.GeoLocalizador;

@Repository
@JsonIgnoreProperties(ignoreUnknown = true)
public class Imoveis {

	@Autowired
	public HashMap<String, Province> provinces;
	@JsonProperty
	private Integer totalProperties;
	@JsonProperty
	private static List<Imovel> properties = new ArrayList<Imovel>();

	private static HashMap<Integer, Imovel> imoveisBusca = new HashMap<Integer, Imovel>();

	public List<Imovel> getProperties() {
		return properties;
	}

	public Imovel adicionar(Imovel imovel) {
		imovel.setId(++totalProperties);
		defineProvinces(imovel);
		properties.add(imovel);
		imoveisBusca.put(imovel.getId(), imovel);
		return imovel;
	}

	private void defineProvinces(Imovel imovel) {
		provinces.forEach((String, Province) -> {
			Boolean pertence = GeoLocalizador.pertenceAoBoundare(Province.getboundaries(), new Ponto(imovel.getLongi(), imovel.getLat()));
			if (pertence) {
				imovel.getProvinces().add(String);
			}
		});

	}

	public Imovel getImovel(Integer id) {

		if (imoveisBusca.size() == 0) {
			for (Imovel imovel : properties) {
				imoveisBusca.put(imovel.getId(), imovel);
			}
		}
		return imoveisBusca.get(id);
	}
}
