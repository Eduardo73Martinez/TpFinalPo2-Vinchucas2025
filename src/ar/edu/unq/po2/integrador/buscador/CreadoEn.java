package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public class CreadoEn extends FechaDeCreacion {
	protected boolean esMuestraValida (Muestra muestra) {
		return fechaCreacion(muestra).isEqual(fechaIngresada);
	}
	public CreadoEn (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
