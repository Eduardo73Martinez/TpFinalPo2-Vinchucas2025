package buscador;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;



import web_vinchucas.Muestra;


class UltimaVotacionEn extends FechaUltimaVotacion {

public List<Muestra> buscar(List<Muestra> lista){
	//PROPOSITO:devuelve las muestras que fueron votadas el dia de la fecha ingresada
		return lista.stream()
		.filter (muestra->muestra.getFechaUltimaVotacion().isEqual(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public UltimaVotacionEn (LocalDate fechaIngresada){
		super (fechaIngresada);
		
	}
}
