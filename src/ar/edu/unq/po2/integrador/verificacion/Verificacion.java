package ar.edu.unq.po2.integrador.verificacion;

import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;
import ar.edu.unq.po2.integrador.webMuestraUsuario.Usuario;
public interface Verificacion {




	
	
	public abstract boolean puedeVotar (Usuario usuario); //devuelve true si el usuario puede votar
	public abstract void verificar(Muestra muestra); //recalcula el tipo de verificacion
	public abstract String resultadoActual (Muestra muestra);
	
	
		
	

}
