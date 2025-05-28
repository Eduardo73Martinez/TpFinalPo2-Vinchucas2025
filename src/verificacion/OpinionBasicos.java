package verificacion;

import java.util.List;

import web_vinchucas.Muestra;
import web_vinchucas.Opinion;
import web_vinchucas.Usuario;

public class OpinionBasicos extends NoVerificada {
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
		//hago que pase a ser OpinionExpertos al haber al menos una opinon de experto o especialista
		return getOpiniones().anyMatch(elemento->elemento.getUsuarioQueDejoOpinionEsExperto() || getUsuarioQueDejoOpinonEsEspecialista());
		//esto devuelve true si algun elemento de la lista de opiniones de muestra fue dejado por 
		//alguien que es experto o especialista
		
	}
	private List<Opinion> getOpiniones(){
		return muestra.getOpiniones();
	}
	
	public OpinionBasicos (Muestra muestra) {
		super (muestra);
	}
}
