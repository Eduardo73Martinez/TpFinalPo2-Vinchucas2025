package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public class CreadoDespuesDe extends FechaDeCreacion {
	protected boolean esMuestraValida (Muestra muestra) {
		return muestra.getFechaCreacion().isAfter(fechaIngresada);
	}
	
	public CreadoDespuesDe (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
