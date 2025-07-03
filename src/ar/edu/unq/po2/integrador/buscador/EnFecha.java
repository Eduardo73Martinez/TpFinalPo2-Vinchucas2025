package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class EnFecha extends PorFecha {
	
	protected boolean esMuestraValida (Muestra muestra) {
		return tipoFecha.fechaDeMuestraParaEsteTipo(muestra).isEqual(fechaIngresada);
	}
	
	public EnFecha (LocalDate fechaIngresada, EstrategiaFecha tipoFecha){
		super (fechaIngresada,tipoFecha);
		
	}
}
