package buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.*;

public class CreadoDespuesDe extends FechaDeCreacion {
	public List<Muestra> buscar(){
		//PROPOSITO:devuelve las muestras que fueron creadas despues de la fecha ingresada
		return todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaCreacion().isAfter(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public CreadoDespuesDe (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
