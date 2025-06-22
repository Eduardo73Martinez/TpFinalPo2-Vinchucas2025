package buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import web_vinchucas.*;

public class UltimaVotacionDespuesDe extends FechaUltimaVotacion {
	
	
	public List<Muestra> buscar(List<Muestra> lista){
		//PROPOSITO:devuelve las muestras que fueron votadas despues de la fecha ingresada
		return lista.stream()
		.filter (muestra->muestra.getFechaUltimaVotacion().isAfter(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public UltimaVotacionDespuesDe (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
