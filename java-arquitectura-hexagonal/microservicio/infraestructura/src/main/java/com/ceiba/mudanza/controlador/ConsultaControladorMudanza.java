package com.ceiba.mudanza.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.mudanza.consulta.ManejadorListarMudanza;
import com.ceiba.mudanza.modelo.dto.DtoMudanza;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mudanzas")
@Api(tags = {"Controlador consulta mudanzas"})
public class ConsultaControladorMudanza {

	private final ManejadorListarMudanza manejadorListarMudanza;
	
	public ConsultaControladorMudanza(ManejadorListarMudanza manejadorListarMudanza) {
		this.manejadorListarMudanza = manejadorListarMudanza;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	@ApiOperation("Listar mudanzas")
	public List<DtoMudanza> listar() {
		return this.manejadorListarMudanza.ejecutar();
	}
}
