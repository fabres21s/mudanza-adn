package com.ceiba.furgon.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.furgon.consulta.ManejadorListarFurgon;
import com.ceiba.furgon.modelo.dto.DtoFurgon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/furgones")
@Api(tags={"Controlador consulta furgones"})
public class ConsultaControladorFurgon {

	private final ManejadorListarFurgon manejadorListarFurgon;
	
	public ConsultaControladorFurgon(ManejadorListarFurgon manejadorListarFurgon) {
		this.manejadorListarFurgon = manejadorListarFurgon;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	@ApiOperation("Listar furgones")
	public List<DtoFurgon> listar() {
		return this.manejadorListarFurgon.ejecutar();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/disponibles/{tarifaHorarioId}/{fecha}", method = RequestMethod.GET)
	@ApiOperation("Listar furgones")
	public List<DtoFurgon> listarDisponibles( @PathVariable Long tarifaHorarioId, @PathVariable(value="fecha")
    	@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fecha) {
		return this.manejadorListarFurgon.consultarDisponibles(tarifaHorarioId, fecha);
	}
}
