package ar.edu.unq.po2.integrador.buscador;
import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

class UltimaVotacionEn extends FechaUltimaVotacion {

	public boolean esMuestraValida (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue votada, si no lo es da false
		return muestra.getFechaUltimaVotacion().isEqual(fechaIngresada);
	}
	
	public UltimaVotacionEn (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
