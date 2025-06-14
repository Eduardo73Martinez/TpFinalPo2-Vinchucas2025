package verificacion;

import web_vinchucas.Muestra;
import web_vinchucas.Usuario;
public interface Verificacion {




	
	public abstract boolean esVerificada(); //devuelve true si es verificada
	public abstract boolean puedeVotar (Usuario usuario); //devuelve true si el usuario puede votar
	public abstract void verificar(Muestra muestra); //recalcula el tipo de verificacion
	public abstract boolean esVotada(); //devuelve true si ya fue votada por un experto o especialista
	public abstract String resultadoActual (Muestra muestra);
	
	
		
	

}
