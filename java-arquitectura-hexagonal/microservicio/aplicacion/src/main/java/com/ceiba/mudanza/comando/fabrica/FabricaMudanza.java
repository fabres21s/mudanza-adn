package com.ceiba.mudanza.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.mudanza.comando.ComandoMudanza;
import com.ceiba.mudanza.modelo.entidad.Mudanza;

@Component
public class FabricaMudanza {

	public Mudanza crear(ComandoMudanza comandoMudanza) {
		return new Mudanza(comandoMudanza.getId(), comandoMudanza.getFurgonId(), 
				comandoMudanza.getTarifaHorarioId(),
				comandoMudanza.getFecha(),
				comandoMudanza.getDireccionInicial(),
				comandoMudanza.getDireccionFinal()
				);
	}
}
