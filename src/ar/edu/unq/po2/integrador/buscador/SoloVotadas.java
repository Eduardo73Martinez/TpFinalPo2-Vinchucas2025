package ar.edu.unq.po2.integrador.buscador;
import ar.edu.unq.po2.integrador.verificacion.*;
import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class SoloVotadas extends PorVerificacion{

	public boolean esMuestraValida (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue votada, si no lo es da false
		return muestra.getVerificacion() instanceof NoVerificada;
	}
	public SoloVotadas (){
		
	}
}
