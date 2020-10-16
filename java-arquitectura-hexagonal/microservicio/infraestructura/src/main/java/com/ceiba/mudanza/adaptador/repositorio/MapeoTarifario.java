package com.ceiba.mudanza.adaptador.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.festivo.modelo.dto.DtoFestivo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

public class MapeoTarifario implements RowMapper<DtoTarifario>, MapperResult{

	@Override
	public DtoTarifario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Double tarifaBase = rs.getDouble("tarifa_base");
		Double porcentajeRecargoNocturno = rs.getDouble("porcentaje_recargo_nocturno");
		Double porcentajeRecargoDominical = rs.getDouble("porcentaje_recargo_dominical");
		Double porcentajeRecargoFestivo = rs.getDouble("porcentaje_recargo_festivo");
		Boolean recargoNocturno = rs.getBoolean("recargo_nocturno");
		Boolean esFestivo = rs.getBoolean("es_festivo");
		
		return new DtoTarifario(tarifaBase, porcentajeRecargoNocturno, porcentajeRecargoDominical, porcentajeRecargoFestivo, recargoNocturno, esFestivo);
	}

}


