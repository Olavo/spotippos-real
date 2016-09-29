package com.spotippos.real.dominio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotippos.real.dominio.model.Boundary;
import com.spotippos.real.dominio.model.Properties;
import com.spotippos.real.dominio.model.Property;
import com.spotippos.real.dominio.model.Province;

@Service
public class PropertiesService {

	@Autowired
	private Properties properties;

	@Autowired
	public HashMap<String, Province> provinces;

	@Autowired
	GeoLocator geoLocator;

	public Property addProperty(Property property) {

		defineProvinces(property);

		return properties.add(property);
	}

	private void defineProvinces(Property property) {
		provinces.forEach((String, Province) -> {
			Boolean doesBelongTo = geoLocator.belongsToBoundare(Province.getboundaries(), property.getPoint());
			if (doesBelongTo) {
				property.getProvinces().add(String);
			}
		});
	}

	public Property getProperty(Integer id) {
		return properties.getProperty(id);
	}

	public List<Property> getPropertiesInBoundary(Boundary boundary) {
		List<Property> propertiesInBoundary = new ArrayList<>();

		for (Property property : properties.getProperties()) {
			if (geoLocator.belongsToBoundare(boundary, property.getPoint())) {
				propertiesInBoundary.add(property);
			}
		}

		return propertiesInBoundary;
	}
}
