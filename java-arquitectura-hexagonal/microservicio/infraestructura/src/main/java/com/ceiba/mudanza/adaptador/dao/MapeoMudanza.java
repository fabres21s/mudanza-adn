package com.ceiba.mudanza.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.mudanza.modelo.dto.DtoMudanza;

public class MapeoMudanza implements RowMapper<DtoMudanza>, MapperResult {

	@Override
	public DtoMudanza mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		LocalDateTime fechaInicial = extraerLocalDateTime(rs, "fecha_inicial");
		LocalDateTime fechaFinal = extraerLocalDateTime(rs, "fecha_final");
		String placa = rs.getString("placa");
		String direccionInicial = rs.getString("direccion_inicial");
		String direccionFinal = rs.getString("direccion_final");
		Double tarifaBase = rs.getDouble("tarifa_base");
		Double recargoNocturno = rs.getDouble("recargo_nocturno");
		Double recargoDominical = rs.getDouble("recargo_dominical");
		Double recargoFestivo = rs.getDouble("recargo_festivo");
		return new DtoMudanza(id, fechaInicial, fechaFinal, placa, direccionInicial, direccionFinal,
				tarifaBase, recargoNocturno, recargoDominical, recargoFestivo);
	}

}

