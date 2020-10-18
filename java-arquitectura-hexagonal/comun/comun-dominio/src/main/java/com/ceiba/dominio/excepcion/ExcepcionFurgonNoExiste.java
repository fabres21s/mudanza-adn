package com.ceiba.dominio.excepcion;

public class ExcepcionFurgonNoExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionFurgonNoExiste(String mensaje) {
        super(mensaje);
    }
}
