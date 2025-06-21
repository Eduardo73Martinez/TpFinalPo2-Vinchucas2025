package buscador;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import web_vinchucas.*;

class UltimaVotacionEn extends FechaUltimaVotacion {

public List<Muestra> buscar(){
	//PROPOSITO:devuelve las muestras que fueron votadas el dia de la fecha ingresada
		return todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaUltimaVotacion().isEqual(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public UltimaVotacionEn (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
