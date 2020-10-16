package com.ceiba.dominio.excepcion;

public class ExcepcionFurgonNoDisponible extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionFurgonNoDisponible(String mensaje) {
        super(mensaje);
    }
}
