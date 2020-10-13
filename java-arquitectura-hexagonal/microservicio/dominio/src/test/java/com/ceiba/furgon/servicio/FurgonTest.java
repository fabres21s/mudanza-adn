package com.ceiba.furgon.servicio;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionPlacaInvalida;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.furgon.modelo.entidad.Furgon;

public class FurgonTest {

	@Test
	public void validarConstructorFurgon() {

		BasePrueba.assertThrows(() -> new Furgon(1l, "ABC-1234", LocalDateTime.now()), ExcepcionPlacaInvalida.class,
				"La placa no tiene un formato valido");

	}

	@Test
	public void validarConstructorFurgon2() {

		BasePrueba.assertThrows(() -> new Furgon(1l, null, LocalDateTime.now()), ExcepcionValorObligatorio.class,
				"Se debe ingresar la placa del furgon");

	}
}
