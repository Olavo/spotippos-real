package com.spotippos.real;

import static org.assertj.core.api.BDDAssertions.then;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.spotippos.real.dominio.model.Boundary;
import com.spotippos.real.dominio.model.Ponto;
import com.spotippos.real.dominio.service.GeoLocalizador;

@RunWith(SpringRunner.class)
public class GeoLocalizadorTest {

	@Test
	public void testPertenceAoBoundare() {

		Ponto upperLeft = new Ponto(10,50);
		Ponto bottomRight = new Ponto(50,10);
		Ponto localizacao = new Ponto(30,40);
		
		Boundary boundary = new Boundary(upperLeft,bottomRight);
		Boolean pertence = GeoLocalizador.pertenceAoBoundare(boundary, localizacao);
		then(pertence).isEqualTo(true);
	}
	
	@Test
	public void testNaoPertenceAoBoundare() {

		Ponto upperLeft = new Ponto(10,50);
		Ponto bottomRight = new Ponto(50,10);
		Ponto localizacao = new Ponto(30,51);
		
		Boundary boundary = new Boundary(upperLeft,bottomRight);
		Boolean pertence = GeoLocalizador.pertenceAoBoundare(boundary, localizacao);
		then(pertence).isEqualTo(false);
	}

}
