package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;


import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;

public abstract class Fechas extends Simple {

	LocalDate fechaIngresada;
	abstract boolean esMuestraValida (Muestra muestra);
	abstract LocalDate fechaDeMuestraParaEsteTipo(Muestra muestra);
	
	public boolean fechaEn (Muestra muestra){
		return fechaDeMuestraParaEsteTipo(muestra).isEqual(fechaIngresada);
		
	}
	public boolean fechaDespuesDe (Muestra muestra){
		return fechaDeMuestraParaEsteTipo(muestra).isAfter(fechaIngresada);
		
	}
	public boolean fechaAntesDe (Muestra muestra){
		return fechaDeMuestraParaEsteTipo(muestra).isBefore(fechaIngresada);
		
	}
	private void setFechaIngresada (LocalDate fechaIngresada) {
		//PROPOSITO:setea la fecha
		this.fechaIngresada = fechaIngresada;
	}
	public Fechas (LocalDate fechaIngresada) {
		setFechaIngresada (fechaIngresada);
	}
}
