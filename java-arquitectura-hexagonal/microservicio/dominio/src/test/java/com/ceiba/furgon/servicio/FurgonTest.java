package com.ceiba.furgon.servicio;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionPlacaInvalida;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.furgon.modelo.entidad.Furgon;

public class FurgonTest {

	@Test
	public void validarConstructorFurgon() {

		BasePrueba.assertThrows(() -> new Furgon(1l, "ABC-1234"), ExcepcionPlacaInvalida.class,
				"La placa no tiene un formato valido");

	}

	@Test
	public void validarConstructorFurgonNull() {

		BasePrueba.assertThrows(() -> new Furgon(1l, null), ExcepcionValorObligatorio.class,
				"Se debe ingresar la placa del furgon");

	}
}
