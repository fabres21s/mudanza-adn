select count(0) from furgon f 
inner join mudanza m on (f.id = m.furgon_id)
inner join tarifa_horario th on (th.id = m.tarifa_horario_id)
where m.fecha = :fecha and th.id = :tarifaHorarioId and f.id = :furgonId