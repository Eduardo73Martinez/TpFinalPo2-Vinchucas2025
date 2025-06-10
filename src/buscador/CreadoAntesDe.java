package buscador;

import java.time.LocalDate;
import java.util.List;

import web_vinchucas.Muestra;

public class CreadoAntesDe extends FechaDeCreacion{

	
public List<Muestra> buscar(){
		
		return web.todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaCreacion()<fechaIngresada);
	}
	
	public CreadoAntesDe (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
