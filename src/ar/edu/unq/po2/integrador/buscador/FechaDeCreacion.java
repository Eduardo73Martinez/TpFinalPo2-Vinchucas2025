package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class FechaDeCreacion implements EstrategiaFecha {
	
	public LocalDate fechaDeMuestraParaEsteTipo (Muestra muestra) {
		return muestra.getFechaCreacion();
	}
	
	public FechaDeCreacion (){
	}
}
