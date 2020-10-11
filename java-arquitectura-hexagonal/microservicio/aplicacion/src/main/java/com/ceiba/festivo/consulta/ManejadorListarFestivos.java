package com.ceiba.festivo.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.festivo.modelo.dto.DtoFestivo;
import com.ceiba.festivo.puerto.dao.DaoFestivo;

@Component
public class ManejadorListarFestivos {
	
	public final DaoFestivo daoFestivo;
	
	public ManejadorListarFestivos(DaoFestivo daoFestivo) {
		this.daoFestivo = daoFestivo;
	}
	
	public List<DtoFestivo> ejecutar() {
		return this.daoFestivo.listar();
	}

}
