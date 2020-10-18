package com.ceiba.furgon.servicio.testdatabuilder;

import com.ceiba.furgon.modelo.entidad.Furgon;

public class FurgonTestDataBuilder {
	
	private Long id;
	private String placa;
	
	public FurgonTestDataBuilder() {
		placa = "ABC-123";
	}
	
    public FurgonTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
	
	public Furgon build() {
		return new Furgon(id, placa);
	}
}
