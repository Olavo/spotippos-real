package com.spotippos.real.web.imovel;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spotippos.real.dominio.model.Boundary;
import com.spotippos.real.dominio.model.Property;
import com.spotippos.real.dominio.model.Point;
import com.spotippos.real.dominio.service.PropertiesService;

@Controller
@RequestMapping("/properties")
public class PropertyController {

	@Autowired
	private PropertiesService propertiesService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseAddProperty addProperty(
			@RequestBody(required = true) @Validated RequestAddProperty requestAddProperty) {

		Property property = makePropertyByResquestAddProperty(requestAddProperty);

		Property newProperty = propertiesService.addProperty(property);

		return new ResponseAddProperty(newProperty);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseGetProperty> getProperty(@PathVariable @NotNull Integer id) {

		Property retrievedProperty = propertiesService.getProperty(id);
		if (retrievedProperty == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return new ResponseEntity<ResponseGetProperty>(new ResponseGetProperty(retrievedProperty), HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseGetPropertiesList> getPropertiesInBoundary(
			@NotNull @RequestParam(value = "ax") Integer ax, @NotNull @RequestParam(value = "ay") Integer ay,
			@NotNull @RequestParam(value = "bx") Integer bx, @NotNull @RequestParam(value = "by") Integer by) {

		List<Property> foundProperties = propertiesService
				.getPropertiesInBoundary(new Boundary(new Point(ax, ay), new Point(bx, by)));
		if (foundProperties.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return new ResponseEntity<ResponseGetPropertiesList>(new ResponseGetPropertiesList(foundProperties),
				HttpStatus.FOUND);
	}

	private Property makePropertyByResquestAddProperty(RequestAddProperty requestAddProperty) {
		Property imovel = new Property(requestAddProperty.getTitle(), requestAddProperty.getPrice(),
				requestAddProperty.getDescription(), requestAddProperty.getY(), requestAddProperty.getX(),
				requestAddProperty.getBeds(), requestAddProperty.getBaths(), requestAddProperty.getSquareMeters());
		return imovel;
	}

}
