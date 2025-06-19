package verificacion;

import web_vinchucas.Muestra;
import web_vinchucas.Usuario;
public interface Verificacion {




	
	
	public abstract boolean puedeVotar (Usuario usuario); //devuelve true si el usuario puede votar
	public abstract void verificar(Muestra muestra); //recalcula el tipo de verificacion
	public abstract String resultadoActual (Muestra muestra);
	
	
		
	

}
