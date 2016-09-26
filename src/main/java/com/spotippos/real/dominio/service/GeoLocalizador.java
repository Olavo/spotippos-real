package com.spotippos.real.dominio.service;

import org.springframework.stereotype.Service;

import com.spotippos.real.dominio.model.Boundary;
import com.spotippos.real.dominio.model.Ponto;

@Service
public class GeoLocalizador {

	public static Boolean pertenceAoBoundare(Boundary boundary, Ponto ponto) {

		boolean r;
		if ((boundary.getUpperLeft().getX() <= ponto.getX()) && (boundary.getBottomRight().getX() >= ponto.getX())
				&& (boundary.getUpperLeft().getY() >= ponto.getY()) && (boundary.getBottomRight().getY() <= ponto.getY())) {
			r = true;
		} else {
			r = false;
		}
		return r;

	}

}
