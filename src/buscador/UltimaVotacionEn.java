package buscador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

class UltimaVotacionEn extends FechaUltimaVotacion {

public List<Muestra> buscar(){
		
		return todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaUltimaVotacion().isEqual(fechaIngresada))
		.collect(Collectors.toList());
	}
	
	public UltimaVotacionEn (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
