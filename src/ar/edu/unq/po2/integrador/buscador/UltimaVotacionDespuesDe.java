package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class UltimaVotacionDespuesDe extends FechaUltimaVotacion {
	
	
	public boolean esMuestraValida (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue votada, si no lo es da false
		return muestra.getFechaUltimaVotacion().isAfter(fechaIngresada);
	}
	
	public UltimaVotacionDespuesDe (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
