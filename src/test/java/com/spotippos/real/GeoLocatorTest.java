package com.spotippos.real;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spotippos.real.dominio.model.Boundary;
import com.spotippos.real.dominio.model.Point;
import com.spotippos.real.dominio.service.GeoLocator;
import com.spotippos.real.web.SpotipposConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpotipposConfiguration.class)
public class GeoLocatorTest {

	@Autowired
	private GeoLocator geoLocator;

	@Test
	public void doesBelongInBoundary() {

		Point upperLeft = new Point(10, 50);
		Point bottomRight = new Point(50, 10);
		Point location = new Point(30, 40);

		Boundary boundary = new Boundary(upperLeft, bottomRight);
		Boolean doesBelong = geoLocator.belongsToBoundare(boundary, location);
		then(doesBelong).isEqualTo(true);
	}

	@Test
	public void doesNotBelongInBoundary() {

		Point upperLeft = new Point(10, 50);
		Point bottomRight = new Point(50, 10);
		Point location = new Point(30, 51);

		Boundary boundary = new Boundary(upperLeft, bottomRight);
		Boolean doesBelong = geoLocator.belongsToBoundare(boundary, location);
		then(doesBelong).isEqualTo(false);
	}

}