package com.spotippos.real;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spotippos.real.web.SpotipposConfiguration;
import com.spotippos.real.web.imovel.RequestAddProperty;
import com.spotippos.real.web.imovel.ResponseAddProperty;
import com.spotippos.real.web.imovel.ResponseGetPropertiesList;
import com.spotippos.real.web.imovel.ResponseGetProperty;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpotipposConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class PropertiesTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	private TestRestTemplate testRestTemplate = new TestRestTemplate();

	@Test
	public void shouldAddProperty() throws Exception {
		String url = "http://localhost:" + this.port + "/properties";

		RequestAddProperty request = makeResquestAddProperty();
		ResponseEntity<ResponseAddProperty> entity = this.testRestTemplate.postForEntity(url, request,
				ResponseAddProperty.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	private RequestAddProperty makeResquestAddProperty() {
		return new RequestAddProperty(222, 444, "Imóvel código 1, com 5 quartos e 4 banheiros", 1250000d,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 4, 3, 210);
	}

	@Test
	public void shouldFindAProperty() {
		String url = "http://localhost:" + this.port + "/properties/8000";
		ResponseEntity<ResponseGetProperty> entity = this.testRestTemplate.getForEntity(url, ResponseGetProperty.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
	}

	@Test
	public void shouldFindAProperties() {
		String url = "http://localhost:" + this.port + "/properties?ax=0&ay=100&by=0&bx=100";
		ResponseEntity<ResponseGetPropertiesList> entity = this.testRestTemplate.getForEntity(url, ResponseGetPropertiesList.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
	}
	
	@Test
	public void shouldNotFindAProperties() {
		String url = "http://localhost:" + this.port + "/properties?ax=0&ay=10&by=0&bx=10";
		ResponseEntity<ResponseGetPropertiesList> entity = this.testRestTemplate.getForEntity(url, ResponseGetPropertiesList.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
}
