package buscador;

import java.time.LocalDate;
import java.util.List;

import web_vinchucas.Muestra;

public abstract class FechaUltimaVotacion extends Simple{
	LocalDate fechaIngresada;
	
	abstract List<Muestra> buscar();
	private setFechaIngresada (LocalDate fechaIngresada) {
		this.fechaIngresada = fechaIngresada;
	}
	
	public SoloVerificadas (Web web,LocalDate fechaIngresada){
		super (web);
		setFechaIngresada (fechaIngresada);
	}
}
