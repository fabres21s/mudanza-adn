select f.id,f.placa,f.fecha_creacion
from furgon f 
left join mudanza m on (f.id = m.furgon_id and m.fecha = :fecha)
left join tarifa_horario th on (th.id = m.tarifa_horario_id and th.id = :tarifaHorarioId)
where th.id is null;