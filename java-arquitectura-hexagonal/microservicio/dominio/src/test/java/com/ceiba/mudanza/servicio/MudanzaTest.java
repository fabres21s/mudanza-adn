package com.ceiba.mudanza.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.mudanza.modelo.entidad.Mudanza;

public class MudanzaTest {

	@Test
	public void validarConstructor() {

		LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
		assertDoesNotThrow(() -> new Mudanza(1L, 1L, 1L, tomorrow, "CALLE FALSA", "CALLE REAL"));

	}

	@Test
	public void validarConstructorFechaInvalida() {

		LocalDate yesterday = LocalDate.now().plus(-1, ChronoUnit.DAYS);
		BasePrueba.assertThrows(() -> new Mudanza(1L, 1L, 1L, yesterday, "CALLE FALSA", "CALLE REAL"),
				ExcepcionValorInvalido.class, "Se debe ingresar una fecha superior a hoy");

	}
	
	@Test
	public void validarConstructorDireccionFinal() {

		LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
		BasePrueba.assertThrows(() -> new Mudanza(1L, 1L, 1L, tomorrow, "CALLE FALSA", null),
				ExcepcionValorObligatorio.class, "Se debe ingresar una direccion final");

	}
	
	@Test
	public void validarConstructorDireccionInicial() {

		LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
		BasePrueba.assertThrows(() -> new Mudanza(1L, 1L, 1L, tomorrow, null, "CALLE REAL"),
				ExcepcionValorObligatorio.class, "Se debe ingresar una direccion inicial");

	}
	
	@Test
	public void validarConstructorFecha() {

		BasePrueba.assertThrows(() -> new Mudanza(1L, 1L, 1L, null, "CALLE FALSA", "CALLE REAL"),
				ExcepcionValorObligatorio.class, "Se debe seleccionar una fecha");

	}
	
	@Test
	public void validarConstructorTarifa() {

		LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
		BasePrueba.assertThrows(() -> new Mudanza(1L, 1L, null, tomorrow, "CALLE FALSA", "CALLE REAL"),
				ExcepcionValorObligatorio.class, "Se debe seleccionar una tarifa horario");

	}
	
	@Test
	public void validarConstructorFurgon() {

		LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
		BasePrueba.assertThrows(() -> new Mudanza(1L, null, 1l, tomorrow, "CALLE FALSA", "CALLE REAL"),
				ExcepcionValorObligatorio.class, "Se debe seleccionar un furgon");

	}
}
