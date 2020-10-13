package com.ceiba.furgon.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.furgon.comando.ComandoFurgon;
import com.ceiba.furgon.modelo.entidad.Furgon;

@Component
public class FabricaFurgon {

	public Furgon crear (ComandoFurgon comandoFurgon) {
		return new Furgon(comandoFurgon.getId(), comandoFurgon.getPlaca(), comandoFurgon.getFechaCreacion());
	}
}
