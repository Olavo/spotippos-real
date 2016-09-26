package com.spotippos.real;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spotippos.real.web.SpotipposConfiguration;
import com.spotippos.real.web.imovel.RequestCriaImovel;
import com.spotippos.real.web.imovel.ResponseCriaImovel;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpotipposConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class ImovelTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	private TestRestTemplate testRestTemplate = new TestRestTemplate(null, null, null);

	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/properties", String.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/info", Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void deveCriarUmImovel() throws Exception {
		String url = "http://localhost:" + this.port + "/properties";

		RequestCriaImovel request = getResquestCriaImovel();
		ResponseEntity<ResponseCriaImovel> entity = this.testRestTemplate.postForEntity(url, request, ResponseCriaImovel.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	private RequestCriaImovel getResquestCriaImovel() {
		return new RequestCriaImovel(222, 444, "Imóvel código 1, com 5 quartos e 4 banheiros", 1250000d,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 4, 3, 210);
	}
	
}
