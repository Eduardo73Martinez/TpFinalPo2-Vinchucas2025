package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;

public abstract class PorFecha extends Simple {

	LocalDate fechaIngresada;
	EstrategiaFecha tipoFecha;
	
	abstract boolean esMuestraValida (Muestra muestra);
	
	private void setFechaIngresada (LocalDate fechaIngresada) {
		//PROPOSITO:setea la fecha
		this.fechaIngresada = fechaIngresada;
	}
	
	private void setTipoFecha (EstrategiaFecha tipoFecha) {
		//PROPOSITO: setea la Estrategia
		this.tipoFecha = tipoFecha;
	}
	public PorFecha (LocalDate fechaIngresada, EstrategiaFecha tipoFecha) {
		setFechaIngresada(fechaIngresada);
		setTipoFecha(tipoFecha);
	}
}
