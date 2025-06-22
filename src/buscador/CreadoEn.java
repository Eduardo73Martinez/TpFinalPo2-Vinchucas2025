package buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import web_vinchucas.*;


public class CreadoEn extends FechaDeCreacion {
	public List<Muestra> buscar(List<Muestra> lista){
		//PROPOSITO:devuelve las muestras que fueron creadas el dia de la fecha ingresada
		return lista.stream()
		.filter (muestra->muestra.getFechaCreacion().isEqual(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public CreadoEn (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
