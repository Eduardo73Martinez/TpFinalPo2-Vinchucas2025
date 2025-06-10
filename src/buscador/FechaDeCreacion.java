package buscador;

import java.time.LocalDate;
import java.util.List;

import web_vinchucas.Muestra;

public abstract class FechaDeCreacion {
	LocalDate fechaIngresada;
	
	abstract List<Muestra> buscar();
	
	private void setFechaIngresada (LocalDate fechaIngresada) {
		this.fechaIngresada = fechaIngresada;
	}
	
	public FechaDeCreacion (Web web,LocalDate fechaIngresada){
		super (web);
		setFechaIngresada (fechaIngresada);
	}
}
