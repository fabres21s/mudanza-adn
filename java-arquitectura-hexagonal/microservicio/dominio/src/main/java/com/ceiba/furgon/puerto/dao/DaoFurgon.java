package com.ceiba.furgon.puerto.dao;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.furgon.modelo.dto.DtoFurgon;

public interface DaoFurgon {

	  /**
     * Permite listar furgones
     * @return los furgones
     */
    List<DtoFurgon> listar();

	List<DtoFurgon> consultarDisponibles(Long tarifaHorarioId, LocalDate fecha);
}
