package com.ceiba.festivo.modelo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoFestivo {

	private Long id;
	private String nombre;
	private LocalDate fecha;
	private LocalDateTime fechaCreacion;
}
