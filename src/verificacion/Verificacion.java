package verificacion;
import web_vinchucas.IOpinable;
import web_vinchucas.Muestra;
import web_vinchucas.Usuario;
public abstract class Verificacion {




	
	abstract boolean esVerificada(); //devuelve true si es verificada
	abstract boolean puedeVotar (Usuario usuario); //devuelve true si el usuario puede votar
	abstract void verificar(Muestra muestra); //recalcula el tipo de verificacion
	abstract boolean esVotada(); //devuelve true si ya fue votada por un experto o especialista
	abstract String resultadoActual (Muestra muestra);
	
	
	public Verificacion () {
		
	}
		
	

}
