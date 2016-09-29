package com.spotippos.real.dominio.service;

import org.springframework.stereotype.Service;

import com.spotippos.real.dominio.model.Boundary;
import com.spotippos.real.dominio.model.Point;

@Service
public class GeoLocator {

	public Boolean belongsToBoundare(Boundary boundary, Point point) {

		boolean doesBelongTo;
		if ((boundary.getUpperLeft().getX() <= point.getX()) && (boundary.getBottomRight().getX() >= point.getX())
				&& (boundary.getUpperLeft().getY() >= point.getY()) && (boundary.getBottomRight().getY() <= point.getY())) {
			doesBelongTo = true;
		} else {
			doesBelongTo = false;
		}
		return doesBelongTo;

	}

}
