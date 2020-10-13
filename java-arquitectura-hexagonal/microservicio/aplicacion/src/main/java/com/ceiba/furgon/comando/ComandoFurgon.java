package com.ceiba.furgon.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFurgon {

    private Long id;
    private String placa;
    private LocalDateTime fechaCreacion;
}
