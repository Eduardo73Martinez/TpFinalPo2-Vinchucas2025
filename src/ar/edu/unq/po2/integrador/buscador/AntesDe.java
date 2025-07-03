package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class AntesDe extends PorFecha{

	protected boolean esMuestraValida (Muestra muestra) {
		return tipoFecha.fechaDeMuestraParaEsteTipo(muestra).isBefore(fechaIngresada);
	}
	
	public AntesDe (LocalDate fechaIngresada, EstrategiaFecha tipoFecha){
		super(fechaIngresada,tipoFecha);
	}
}
