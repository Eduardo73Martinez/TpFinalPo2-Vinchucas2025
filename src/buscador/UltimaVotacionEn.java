package buscador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import web_vinchucas.Muestra;

class UltimaVotacionEn extends FechaUltimaVotacion {

public List<Muestra> buscar(){
		
		return web.todasLasMuestras().stream()
		.filter (muestra->muestra.getFechaUltimaVotacion()==fechaIngresada);
	}
	
	public UltimaVotacionEn (Web web,LocalDate fechaIngresada){
		super (web,fechaIngresada);
		
	}
}
