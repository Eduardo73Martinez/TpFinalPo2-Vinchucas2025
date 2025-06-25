package ar.edu.unq.po2.integrador.buscador;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class UltimaVotacionAntesDe extends FechaUltimaVotacion {
	
	
	public List<Muestra> buscar(List<Muestra> lista){
		//PROPOSITO:devuelve las muestras que fueron votadas antes de la fecha ingresada
		return lista.stream()
		.filter (muestra->muestra.getFechaUltimaVotacion().isBefore(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public UltimaVotacionAntesDe (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
	
}
