package verificacion;

import web_vinchucas.Muestra;
import web_vinchucas.Usuario;

public class OpinionExpertos extends NoVerificada{
	public boolean esVerificada() {
		return false;
	}
	public boolean puedeVotar (Usuario usuario) {
		if (usuario.esBasico()) {
			return false;
		} else {
			return true;
		}
	}
	public boolean verificar() {
		//debo agregar algo que compruebe si dos expertos opinan igual,en caso de que sea asi
		//se comprueba el que tenga mas experto que opinen igual, si hay empate no se cambia la clase asi
		//verifica de nuevo al agregarse una opinion
		
	}
	
	
	public OpinionExpertos (Muestra muestra) {
		super (muestra);
	}
}
