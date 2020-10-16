package com.ceiba.dominio.excepcion;

public class ExcepcionTarifarioNoConfigurado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionTarifarioNoConfigurado(String mensaje) {
        super(mensaje);
    }
}
