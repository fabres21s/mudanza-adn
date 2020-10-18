package com.ceiba.furgon.servicio.testdatabuilder;

import com.ceiba.furgon.comando.ComandoFurgon;

public class ComandoFurgonTestDataBuilder {

	 	private Long id;
	    private String placa;

	    public ComandoFurgonTestDataBuilder() {
	        placa = "XYZ-123";
	    }

	    public ComandoFurgonTestDataBuilder conPlaca(String placa) {
	        this.placa = placa;
	        return this;
	    }

	    public ComandoFurgon build() {
	        return new ComandoFurgon(id,placa);
	    }
}
