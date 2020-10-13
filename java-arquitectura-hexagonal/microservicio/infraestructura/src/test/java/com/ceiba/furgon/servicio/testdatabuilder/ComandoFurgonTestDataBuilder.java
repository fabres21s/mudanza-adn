package com.ceiba.furgon.servicio.testdatabuilder;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ceiba.furgon.comando.ComandoFurgon;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;

public class ComandoFurgonTestDataBuilder {

	 	private Long id;
	    private String placa;
	    private LocalDateTime fecha;

	    public ComandoFurgonTestDataBuilder() {
	        placa = "XYZ-123";
	        fecha = LocalDateTime.now();
	    }

	    public ComandoFurgonTestDataBuilder conPlaca(String placa) {
	        this.placa = placa;
	        return this;
	    }

	    public ComandoFurgon build() {
	        return new ComandoFurgon(id,placa,fecha);
	    }
}
