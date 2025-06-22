package buscador;

import java.time.LocalDate;
import java.util.List;
import web_vinchucas.*;


public abstract class FechaUltimaVotacion extends Simple{
	LocalDate fechaIngresada;
	
	public abstract List<Muestra> buscar(List<Muestra> lista);
	private void setFechaIngresada (LocalDate fechaIngresada) {
		//PROPOSITO:setea la fecha
		this.fechaIngresada = fechaIngresada;
	}
	
	public FechaUltimaVotacion (LocalDate fechaIngresada){
		
		setFechaIngresada (fechaIngresada);
	}
}
