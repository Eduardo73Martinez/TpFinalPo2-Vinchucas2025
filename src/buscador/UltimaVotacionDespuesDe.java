package buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

public class UltimaVotacionDespuesDe extends FechaUltimaVotacion {
	
	
	public List<Muestra> buscar(){
		
		return todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaUltimaVotacion().isAfter(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public UltimaVotacionDespuesDe (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
