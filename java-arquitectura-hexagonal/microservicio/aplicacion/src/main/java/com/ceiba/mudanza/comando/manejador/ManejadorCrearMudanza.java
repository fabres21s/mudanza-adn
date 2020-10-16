package com.ceiba.mudanza.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.mudanza.comando.ComandoMudanza;
import com.ceiba.mudanza.comando.fabrica.FabricaMudanza;
import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.mudanza.servicio.ServicioCrearMudanza;

@Component
public class ManejadorCrearMudanza implements ManejadorComandoRespuesta<ComandoMudanza, ComandoRespuesta<Long>>{

	private final FabricaMudanza fabricaMudanza;
	private final ServicioCrearMudanza servicioCrearMudanza;
	
	public ManejadorCrearMudanza(FabricaMudanza fabricaMudanza, ServicioCrearMudanza servicioCrearMudanza) {
		this.fabricaMudanza = fabricaMudanza;
		this.servicioCrearMudanza = servicioCrearMudanza;
	}
	
	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoMudanza comando) {
		Mudanza mudanza = this.fabricaMudanza.crear(comando);
		return new ComandoRespuesta<>(this.servicioCrearMudanza.ejecutar(mudanza));
	}

}
