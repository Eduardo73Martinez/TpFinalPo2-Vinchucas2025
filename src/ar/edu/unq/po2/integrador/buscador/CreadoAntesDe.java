package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class CreadoAntesDe extends FechaDeCreacion{

	
	protected boolean esMuestraValida (Muestra muestra) {
		return fechaAntesDe (muestra);
	}
	
	public CreadoAntesDe (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
