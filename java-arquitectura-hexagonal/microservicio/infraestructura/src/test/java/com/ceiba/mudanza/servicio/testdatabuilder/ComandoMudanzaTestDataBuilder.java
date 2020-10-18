package com.ceiba.mudanza.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.ceiba.mudanza.comando.ComandoMudanza;

public class ComandoMudanzaTestDataBuilder {

	
	private Long id;
	private Long furgonId;
	private Long tarifaHorarioId;
	private LocalDate fecha;
	private String direccionInicial;
	private String direccionFinal;
	
	public ComandoMudanzaTestDataBuilder() {
		this.furgonId = 1l;
		this.tarifaHorarioId = 1l;
		this.fecha = LocalDate.now().plus(1, ChronoUnit.DAYS);
		this.direccionInicial = "CALLE FALSA 123";
		this.direccionFinal = "AVENIDA SIEMPRE VIVA";
	}
	
	public ComandoMudanza build() {
		return new ComandoMudanza(id, furgonId, tarifaHorarioId, fecha, direccionInicial, direccionFinal);
	}
}
