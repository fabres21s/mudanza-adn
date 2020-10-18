package com.ceiba.mudanza.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.ceiba.mudanza.modelo.entidad.Mudanza;

public class MudanzaTestDataBuilder {

	private Long id;
	private Long furgonId;
	private Long tarifaHorarioId;
	private LocalDate fecha;
	private String direccionInicial;
	private String direccionFinal;
	
	public MudanzaTestDataBuilder() {
		this.furgonId = 1l;
		this.tarifaHorarioId = 1l;
		this.fecha = LocalDate.now().plus(1, ChronoUnit.DAYS);
		this.direccionInicial = "CALLE FALSA";
		this.direccionFinal = "CALLE REAL";
	}
	
	public Mudanza build() {
		return new Mudanza(id, furgonId, tarifaHorarioId, fecha, direccionInicial, direccionFinal);
	}
}
