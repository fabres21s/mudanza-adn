package com.ceiba.furgon.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.furgon.modelo.dto.DtoFurgon;
import com.ceiba.furgon.puerto.dao.DaoFurgon;

@Component
public class ManejadorListarFurgon {

	private final DaoFurgon daoFurgon;
	
	private ManejadorListarFurgon(DaoFurgon daoFurgon) {
		this.daoFurgon = daoFurgon;
	}
	
	public List<DtoFurgon> ejecutar() {
		return this.daoFurgon.listar();
	}
}
