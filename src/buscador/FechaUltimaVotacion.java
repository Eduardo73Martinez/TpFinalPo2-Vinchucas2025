package buscador;

import java.time.LocalDate;
import java.util.List;

import web_vinchucas.*;

public abstract class FechaUltimaVotacion extends Simple{
	LocalDate fechaIngresada;
	
	abstract List<Muestra> buscar();
	private void setFechaIngresada (LocalDate fechaIngresada) {
		//PROPOSITO:setea la fecha
		this.fechaIngresada = fechaIngresada;
	}
	
	public FechaUltimaVotacion (Web web,LocalDate fechaIngresada){
		super (web);
		setFechaIngresada (fechaIngresada);
	}
}
