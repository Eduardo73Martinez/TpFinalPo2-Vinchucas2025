package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class CreadoAntesDe extends FechaDeCreacion{

	
public List<Muestra> buscar(List<Muestra> lista){
	//PROPOSITO:devuelve las muestras que fueron creadas antes de la fecha ingresada
		
		return lista.stream()
		.filter (muestra->muestra.getFechaCreacion().isBefore(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public CreadoAntesDe (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
