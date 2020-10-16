package com.ceiba.mudanza.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Mudanza {

	private static final String SE_DEBE_SELECCIONAR_UN_FURGON = "Se debe seleccionar un furgon";
	private static final String SE_DEBE_SELECCIONAR_UNA_TARIFA_HORARIO = "Se debe seleccionar una tarifa horario";
	private static final String SE_DEBE_SELECCIONAR_UNA_FECHA = "Se debe seleccionar una fecha";
	private static final String SE_DEBE_INGRESAR_DIRECCION_INICIAL = "Se debe ingresar una direccion inicial";
	private static final String SE_DEBE_INGRESAR_DIRECCION_FINAL = "Se debe ingresar una direccion final";
	private static final String SE_DEBE_SELECCIONAR_UNA_FECHA_SUPERIOR_A_HOY = "Se debe ingresar una fecha superior a hoy";
	
	private Long id;
	private Long furgonId;
	private Long tarifaHorarioId;
	private LocalDate fecha;
	private String direccionInicial;
	private String direccionFinal;
	private Double tarifaBase;
	private Double recargoNocturno;
	private Double recargoDominical;
	private Double recargoFestivo;
	
	public Mudanza(Long id, Long furgonId, Long tarifaHorarioId, LocalDate fecha, String direccionInicial, String direccionFinal) {
		
		validarObligatorio(furgonId, SE_DEBE_SELECCIONAR_UN_FURGON);
		validarObligatorio(tarifaHorarioId, SE_DEBE_SELECCIONAR_UNA_TARIFA_HORARIO);
		validarObligatorio(fecha, SE_DEBE_SELECCIONAR_UNA_FECHA);
		validarObligatorio(direccionInicial, SE_DEBE_INGRESAR_DIRECCION_INICIAL);
		validarObligatorio(direccionFinal, SE_DEBE_INGRESAR_DIRECCION_FINAL);
		validarMenor(LocalDate.now(), fecha, SE_DEBE_SELECCIONAR_UNA_FECHA_SUPERIOR_A_HOY); 
		this.id = id;
		this.furgonId = furgonId;
		this.tarifaHorarioId = tarifaHorarioId;
		this.fecha = fecha;
		this.direccionInicial = direccionInicial;
		this.direccionFinal = direccionFinal;
	}
	
	public Double getTarifaBase() {
		return tarifaBase;
	}

	public void setTarifaBase(Double tarifaBase) {
		this.tarifaBase = tarifaBase;
	}

	public Double getRecargoNocturno() {
		return recargoNocturno;
	}

	public void setRecargoNocturno(Double recargoNocturno) {
		this.recargoNocturno = recargoNocturno;
	}

	public Double getRecargoDominical() {
		return recargoDominical;
	}

	public void setRecargoDominical(Double recargoDominical) {
		this.recargoDominical = recargoDominical;
	}

	public Double getRecargoFestivo() {
		return recargoFestivo;
	}

	public void setRecargoFestivo(Double recargoFestivo) {
		this.recargoFestivo = recargoFestivo;
	}
}
