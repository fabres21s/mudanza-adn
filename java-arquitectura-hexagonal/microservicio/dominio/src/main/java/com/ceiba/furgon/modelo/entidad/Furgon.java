package com.ceiba.furgon.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPlaca;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Furgon {

	private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa del furgon";
	private static final String LA_PLACA_NO_TIENE_UN_FORMATO_VALIDO = "La placa no tiene un formato valido";
	
    private Long id;
    private String placa;
    private LocalDateTime fecha;
    
    public Furgon(Long id, String placa, LocalDateTime fecha) {
    	validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
    	validarPlaca(placa, LA_PLACA_NO_TIENE_UN_FORMATO_VALIDO);
    	this.id = id;
    	this.placa = placa;
    	this.fecha = fecha;
    }
}
