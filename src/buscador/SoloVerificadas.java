package buscador;


import web_vinchucas.*;

public class SoloVerificadas extends PorVerificacion {

	public  boolean esDelTipoEsperado (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue verificada, si no lo es da false
		return muestra.getVerificacion().esVerificada();
	}
	public SoloVerificadas (Web web){
		super (web);
	}
}
