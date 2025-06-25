package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public abstract class FechaDeCreacion extends Simple {
	LocalDate fechaIngresada;
	
	public abstract List<Muestra> buscar(List<Muestra> lista); 
	
	private void setFechaIngresada (LocalDate fechaIngresada) {
		//PROPOSITO:setea la fecha
		this.fechaIngresada = fechaIngresada;
	}
	
	public FechaDeCreacion (LocalDate fechaIngresada){
		
		setFechaIngresada (fechaIngresada);
	}
}
