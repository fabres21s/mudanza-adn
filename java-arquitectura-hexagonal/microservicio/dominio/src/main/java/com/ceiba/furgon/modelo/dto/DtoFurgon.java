package com.ceiba.furgon.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoFurgon {
	
    private Long id;
    private String placa;
    private LocalDateTime fechaCreacion;

}
