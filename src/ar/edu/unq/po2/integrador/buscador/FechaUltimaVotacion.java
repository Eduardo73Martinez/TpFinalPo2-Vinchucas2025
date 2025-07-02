package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public abstract class FechaUltimaVotacion extends Fechas{
	
	
	abstract boolean esMuestraValida (Muestra muestra);
	
	
	
	protected LocalDate fechaDeMuestraParaEsteTipo (Muestra muestra) {
		return muestra.getFechaUltimaVotacion();
	}
	public FechaUltimaVotacion (LocalDate fechaIngresada){
		
		super (fechaIngresada);
	}
}
