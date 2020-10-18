package com.ceiba.mudanza.utils;

import java.time.DayOfWeek;

import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

public class Utils {

	public void asignarTarifas(Mudanza mudanza, DtoTarifario tarifario) {
		asignarTarifaBase(mudanza, tarifario);
		asignarRecargoNocturno(mudanza, tarifario);
		asignarRecargoDominical(mudanza, tarifario);
		asignarRecargoFestivo(mudanza, tarifario);
	}

	public void asignarRecargoFestivo(Mudanza mudanza, DtoTarifario tarifario) {
		if (tarifario.getEsFestivo()) {
			mudanza.setRecargoFestivo(tarifario.getTarifaBase() * tarifario.getPorcentajeRecargoFestivo() / 100);
		} else {
			mudanza.setRecargoFestivo(0.0);
		}

	}

	public void asignarRecargoDominical(Mudanza mudanza, DtoTarifario tarifario) {
		if (mudanza.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY) {
			mudanza.setRecargoDominical(tarifario.getTarifaBase() * tarifario.getPorcentajeRecargoDominical() / 100);
		} else {
			mudanza.setRecargoDominical(0.0);
		}

	}

	private void asignarRecargoNocturno(Mudanza mudanza, DtoTarifario tarifario) {
		if (tarifario.getRecargoNocturno()) {
			mudanza.setRecargoNocturno(tarifario.getTarifaBase() * tarifario.getPorcentajeRecargoNocturno() / 100);
		} else {
			mudanza.setRecargoNocturno(0.0);
		}

	}

	public void asignarTarifaBase(Mudanza mudanza, DtoTarifario tarifario) {
		mudanza.setTarifaBase(tarifario.getTarifaBase());
	}
}
