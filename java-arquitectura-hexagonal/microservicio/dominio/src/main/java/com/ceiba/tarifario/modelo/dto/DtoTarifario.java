package com.ceiba.tarifario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTarifario {

	private Double tarifaBase;
	private Double porcentajeRecargoNocturno;
	private Double porcentajeRecargoDominical;
	private Double porcentajeRecargoFestivo;
	private Boolean recargoNocturno;
	private Boolean esFestivo;
	
}
