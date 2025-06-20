package buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.*;

public class CreadoAntesDe extends FechaDeCreacion{

	
public List<Muestra> buscar(){
	//PROPOSITO:devuelve las muestras que fueron creadas antes de la fecha ingresada
		
		return todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaCreacion().isBefore(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public CreadoAntesDe (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
