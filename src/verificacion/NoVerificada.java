package verificacion;

import web_vinchucas.Muestra;
import web_vinchucas.Usuario;

public abstract  class NoVerificada extends Verificacion {
	abstract boolean esVerificada();
	abstract boolean puedeVotar (Usuario usuario);
	abstract void verificar(); //recalcula el tipo de verificacion
	abstract boolean esVotada();
	public TipoOpinion opinionMayoritaria() {
		
	}
	public NoVerificada (Muestra muestra){
		super (muestra);
	}
}
