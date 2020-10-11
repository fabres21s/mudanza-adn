package com.ceiba.festivo.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.festivo.modelo.dto.DtoFestivo;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoFestivo implements RowMapper<DtoFestivo>, MapperResult{

	@Override
	public DtoFestivo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		LocalDate fecha = extraerLocalDate(rs, "fecha");
		LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "fecha_creacion");
		
		return new DtoFestivo(id, nombre, fecha, fechaCreacion);
	}

}
