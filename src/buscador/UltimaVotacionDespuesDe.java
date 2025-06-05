package buscador;

import java.time.LocalDate;
import java.util.List;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

public class UltimaVotacionDespuesDe extends FechaUltimaVotacion {
	LocalDate fechaIngresada;
	
	public List<Muestra> buscar(){
		
		return web.todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaUltimaVotacion()<fechaIngresada);
	}
	
	public UltimaVotacionDespuesDe (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
