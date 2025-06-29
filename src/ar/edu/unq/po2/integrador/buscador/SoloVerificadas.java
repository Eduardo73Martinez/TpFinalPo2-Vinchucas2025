package ar.edu.unq.po2.integrador.buscador;


import ar.edu.unq.po2.integrador.verificacion.Verificada;
import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class SoloVerificadas extends PorVerificacion {

	public  boolean esMuestraValida (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue verificada, si no lo es da false
		return verificacion (muestra) instanceof Verificada;
	}
	public SoloVerificadas (){
		
	}
}
