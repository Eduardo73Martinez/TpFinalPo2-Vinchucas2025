package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;
import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public class FechaUltimaVotacion implements EstrategiaFecha{
	
	public LocalDate fechaDeMuestraParaEsteTipo (Muestra muestra) {
		return muestra.getFechaUltimaVotacion();
	}
	public FechaUltimaVotacion(){
		
	}
}
