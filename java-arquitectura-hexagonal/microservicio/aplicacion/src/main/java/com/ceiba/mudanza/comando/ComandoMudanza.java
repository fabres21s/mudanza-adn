package com.ceiba.mudanza.comando;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMudanza {

	private Long id;
	private Long furgonId;
	private Long tarifaHorarioId;
	private LocalDate fecha;
	private String direccionInicial;
	private String direccionFinal;
}
