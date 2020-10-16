select t.valor as tarifa_base,
t.porcentaje_recargo_nocturno,
t.porcentaje_recargo_dominical,
porcentaje_recargo_festivo,
th.recargo_nocturno,
f.id is not null as es_festivo
 from tarifa t 
inner join tarifa_horario th on (t.id = th.tarifa_id)
left join festivo f on (f.fecha = :fecha)
where :fecha between t.fecha_inicial and t.fecha_final and th.id = :tarifaHorarioId;