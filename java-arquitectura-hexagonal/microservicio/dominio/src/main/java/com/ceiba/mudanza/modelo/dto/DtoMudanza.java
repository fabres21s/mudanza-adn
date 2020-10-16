package com.ceiba.mudanza.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMudanza {

	private Long id;
	private LocalDateTime fecha_inicial;
	private LocalDateTime fecha_final;
	private String placa;
	private String direccionInicial;
	private String direccionFinal;
	private Double tarifaBase;
	private Double recargoNocturno;
	private Double recargoDominical;
	private Double recargoFestivo;
	
}
