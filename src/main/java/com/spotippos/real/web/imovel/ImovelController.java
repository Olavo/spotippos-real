package com.spotippos.real.web.imovel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spotippos.real.dominio.model.Imoveis;
import com.spotippos.real.dominio.model.Imovel;

@Controller
@RequestMapping("/properties")
public class ImovelController {

	@Autowired
	private Imoveis imoveis;

	private static final String template = "Hello, %s!";

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {

		return name;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseCriaImovel criaImovel(@RequestBody(required = true) @Validated RequestCriaImovel requestCriaImovel) {

		Imovel imovel = getImovelPorResquestCriaImovel(requestCriaImovel);

		Imovel novoImovel = imoveis.adicionar(imovel);

		return new ResponseCriaImovel(novoImovel);

	}

	private Imovel getImovelPorResquestCriaImovel(RequestCriaImovel requestCriaImovel) {
		Imovel imovel = new Imovel(requestCriaImovel.getTitle(), requestCriaImovel.getPrice(), requestCriaImovel.getDescription(), requestCriaImovel.getY(),
				requestCriaImovel.getX(), requestCriaImovel.getBeds(), requestCriaImovel.getBaths(), requestCriaImovel.getSquareMeters());
		return imovel;
	}

}
