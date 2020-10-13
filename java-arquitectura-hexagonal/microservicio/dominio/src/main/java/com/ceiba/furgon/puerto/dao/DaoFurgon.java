package com.ceiba.furgon.puerto.dao;

import java.util.List;

import com.ceiba.furgon.modelo.dto.DtoFurgon;

public interface DaoFurgon {

	  /**
     * Permite listar furgones
     * @return los furgones
     */
    List<DtoFurgon> listar();
}
