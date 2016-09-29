package com.spotippos.real.dominio.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {
	

	@JsonProperty
	private Integer totalProperties;
	@JsonProperty
	private static List<Property> properties = new ArrayList<Property>();

	private static HashMap<Integer, Property> searchedProperties = new HashMap<Integer, Property>();

	public List<Property> getProperties() {
		return properties;
	}

	public Properties() {
	}
	public Property add(Property property) {
		fulfillSearchedProperties();
		property.setId(++totalProperties);
		properties.add(property);
		searchedProperties.put(property.getId(), property);
		return property;
	}

	public Property getProperty(Integer id) {

		fulfillSearchedProperties();
		return searchedProperties.get(id);
	}

	private void fulfillSearchedProperties() {
		if (searchedProperties.size() == 0) {
			for (Property property : properties) {
				searchedProperties.put(property.getId(), property);
			}
		}
	}
}
