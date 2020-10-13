package com.ceiba.furgon.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.furgon.modelo.dto.DtoFurgon;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoFurgon implements RowMapper<DtoFurgon>, MapperResult{

	@Override
	public DtoFurgon mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		 Long id = resultSet.getLong("id");
	     String placa = resultSet.getString("placa");
	     LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
	     return new DtoFurgon(id, placa, fecha);
	}

}
