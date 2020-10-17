package com.ceiba.furgon.servicio.testdatabuilder;

import com.ceiba.furgon.modelo.entidad.Furgon;

public class FurgonTestDataBuilder {
	
	private Long id;
	private String placa;
	
	public FurgonTestDataBuilder() {
		placa = "ABC-123";
	}
	
	public Furgon build() {
		return new Furgon(id, placa);
	}
}
