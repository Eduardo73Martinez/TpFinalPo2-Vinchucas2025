package buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

public class CreadoEn extends FechaDeCreacion {
	public List<Muestra> buscar(){
		
		return todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaCreacion().isEqual(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public CreadoEn (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
