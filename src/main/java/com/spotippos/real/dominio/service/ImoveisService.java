package com.spotippos.real.dominio.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spotippos.real.dominio.model.Imoveis;
import com.spotippos.real.dominio.model.Imovel;

public class ImoveisService {

	@Autowired
	private Imoveis imoveis;

	public Imovel adicionarImovel(Imovel imovel) {
		
		definirDistito(imovel);
		
		return imoveis.adicionar(imovel);
	}

	private void definirDistito(Imovel imovel) {

		
		
		
	}

}
