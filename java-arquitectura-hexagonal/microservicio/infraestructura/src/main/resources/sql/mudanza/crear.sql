insert into mudanza (fecha, tarifa_horario_id, furgon_id, tarifa_base, recargo_nocturno, recargo_dominical, recargo_festivo, direccion_inicial, direccion_final)
values (:fecha, 
	:tarifaHorarioId,	
	:furgonId,
	:tarifaBase,
	:recargoNocturno,
	:recargoDominical,
	:recargoFestivo,
	:direccionInicial, :direccionFinal);