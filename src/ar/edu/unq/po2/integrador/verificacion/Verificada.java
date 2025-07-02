package ar.edu.unq.po2.integrador.verificacion;

import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;
import ar.edu.unq.po2.integrador.webMuestraUsuario.Usuario;

public class Verificada implements Verificacion{
		
	public boolean puedeVotar (Usuario usuario) {
		//PROPOSITO:devuelve true si el usuario tiene permiso de votar, de no ser asi devuelve false (en este caso es siempre false)
		return false;
	}

	public void verificar(Muestra muestra) {
		//PROPOSITO:al ya estar verificada en este caso no hace nada
	}
	
	public String resultadoActual (Muestra muestra) {
		//PROPOSITO:develve la vinchuca que fue mas votada
		return muestra.getVinchuca().getValor();
		
	}
	
	
	public Verificada () {
		
	}
}
