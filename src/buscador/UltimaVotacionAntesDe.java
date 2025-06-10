package buscador;

import java.time.LocalDate;
import java.util.List;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

public class UltimaVotacionAntesDe extends FechaUltimaVotacion {
	
	
	public List<Muestra> buscar(){
		
		return web.todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaUltimaVotacion()<fechaIngresada);
	}
	
	public UltimaVotacionAntesDe (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
	
}
