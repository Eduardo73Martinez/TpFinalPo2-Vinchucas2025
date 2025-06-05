package buscador;

import java.util.List;

import web_vinchucas.Muestra;

public class SoloVerificadas extends PorVerificacion {

	public List<Muestra> esDelTipoEsperado (Muestra muestra){
		return muestra.getVerificacion().esVerificada();
	}
	public SoloVerificadas (Web web){
		super (web);
	}
}
