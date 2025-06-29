package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public abstract class FechaUltimaVotacion extends Simple{
	LocalDate fechaIngresada;
	
	abstract boolean esMuestraValida (Muestra muestra);
	private void setFechaIngresada (LocalDate fechaIngresada) {
		//PROPOSITO:setea la fecha
		this.fechaIngresada = fechaIngresada;
	}
	
	
	protected LocalDate fechaUltimaVotacion (Muestra muestra) {
		return muestra.getFechaUltimaVotacion();
	}
	public FechaUltimaVotacion (LocalDate fechaIngresada){
		
		setFechaIngresada (fechaIngresada);
	}
}
