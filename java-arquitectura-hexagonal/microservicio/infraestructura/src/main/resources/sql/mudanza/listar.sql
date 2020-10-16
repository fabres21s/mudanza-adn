select 
	m.id,
	cast(concat(m.fecha, ' ', h.hora_inicial) as datetime) as fecha_inicial,
	cast(concat(m.fecha, ' ', h.hora_final) as datetime) as fecha_final,
	f.placa as placa,
	m.direccion_inicial,
	m.direccion_final,
	m.tarifa_base,
	m.recargo_nocturno,
	m.recargo_dominical,
	m.recargo_festivo 
from 
	mudanza m
	inner join tarifa_horario th on (th.id = m.tarifa_horario_id)
	inner join horario h on (h.id = th.horario_id)
	inner join furgon f on (f.id = m.furgon_id);

