package com.ceiba.mudanza.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.mudanza.modelo.dto.DtoMudanza;
import com.ceiba.mudanza.puerto.dao.DaoMudanza;

@Component
public class ManejadorListarMudanza {

	private final DaoMudanza daoMudanza;
	
	public ManejadorListarMudanza(DaoMudanza daoMudanza) {
		this.daoMudanza = daoMudanza;
	}
	
	public List<DtoMudanza> ejecutar() {
		return this.daoMudanza.listar();
	}
}
