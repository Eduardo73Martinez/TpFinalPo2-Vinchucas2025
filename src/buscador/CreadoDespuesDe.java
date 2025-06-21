package buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;


public class CreadoDespuesDe extends FechaDeCreacion {
	public List<Muestra> buscar(List<Muestra> lista){
		//PROPOSITO:devuelve las muestras que fueron creadas despues de la fecha ingresada
		return lista.stream()
		.filter (muestra->muestra.getFechaCreacion().isAfter(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public CreadoDespuesDe (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
