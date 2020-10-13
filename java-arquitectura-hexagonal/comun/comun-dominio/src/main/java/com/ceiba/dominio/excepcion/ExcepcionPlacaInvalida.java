package com.ceiba.dominio.excepcion;

public class ExcepcionPlacaInvalida extends RuntimeException {

	private static final long serialVersionUID = 1988211541264518548L;
	
	public ExcepcionPlacaInvalida(String message) {
		super(message);
	}

}
