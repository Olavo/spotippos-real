package com.spotippos.real.web.imovel;

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

import com.spotippos.real.dominio.model.Imoveis;
import com.spotippos.real.dominio.model.Imovel;


@Controller
@RequestMapping("/properties")
public class ImovelController {

	@Autowired
	private Imoveis imoveis;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseGetImovel> getImovel(@PathVariable @NotNull Integer id) {
		
		Imovel imovelRecuperado = imoveis.getImovel(id);
		if (imovelRecuperado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		}
		return new ResponseEntity<ResponseGetImovel>(new ResponseGetImovel(imovelRecuperado),HttpStatus.FOUND);
	}

	private Imovel getImovelPorResquestCriaImovel(RequestCriaImovel requestCriaImovel) {
		Imovel imovel = new Imovel(requestCriaImovel.getTitle(), requestCriaImovel.getPrice(), requestCriaImovel.getDescription(), requestCriaImovel.getY(),
				requestCriaImovel.getX(), requestCriaImovel.getBeds(), requestCriaImovel.getBaths(), requestCriaImovel.getSquareMeters());
		return imovel;
	}

}
