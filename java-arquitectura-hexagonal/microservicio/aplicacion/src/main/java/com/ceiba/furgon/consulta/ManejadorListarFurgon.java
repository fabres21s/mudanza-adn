package com.ceiba.furgon.consulta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.furgon.modelo.dto.DtoFurgon;
import com.ceiba.furgon.puerto.dao.DaoFurgon;

@Component
public class ManejadorListarFurgon {

	private final DaoFurgon daoFurgon;
	
	public ManejadorListarFurgon(DaoFurgon daoFurgon) {
		this.daoFurgon = daoFurgon;
	}
	
	public List<DtoFurgon> ejecutar() {
		return this.daoFurgon.listar();
	}

	public List<DtoFurgon> consultarDisponibles(Long tarifaHorarioId, LocalDate fecha) {
		return this.daoFurgon.consultarDisponibles(tarifaHorarioId, fecha);
	}
}
