package com.ceiba.mudanza.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.mudanza.comando.ComandoMudanza;
import com.ceiba.mudanza.comando.manejador.ManejadorCrearMudanza;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mudanzas")
@Api(tags= {"Controlador comando mudanza"})
public class ComandoControladorMudanza {
	
	private final ManejadorCrearMudanza manejadorCrearMudanza;
	
	@Autowired
	public ComandoControladorMudanza(ManejadorCrearMudanza manejadorCrearMudanza) {
		this.manejadorCrearMudanza = manejadorCrearMudanza;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	@ApiOperation("Programar mudanza")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoMudanza comandoMudanza) {
		return manejadorCrearMudanza.ejecutar(comandoMudanza);
	}

}
