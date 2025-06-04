package verificacion;

import java.util.List;

import web_vinchucas.Muestra;
import web_vinchucas.Opinion;
import web_vinchucas.Usuario;

public class OpinionBasicos extends NoVerificada {
	public boolean esVerificada() {
		return false;
	}
	public boolean puedeVotar (Usuario usuario,Muestra muestra) {
		if (usuario.esBasico()) {
			return false;
		} else {
			return true;
		}
		verificar(muestra);
	}
	public void verificar(Muestra muestra) {
		//hago que pase a ser OpinionExpertos al haber al menos una opinon de experto o especialista
		if (algunExpertoOEspecialistaOpino (muestra)) {
		OpinionExpertos opinionExperto = new OpinionExpertos (muestra);
		muestra.setVerificacion (opinionExperto);
		}
	}
	private boolean algunExpertoOEspecialistaOpino(Muestra muestra) {
		return getOpiniones(muestra).anyMatch(elemento->elemento.getUsuarioQueDejoOpinionEsExperto() || getUsuarioQueDejoOpinonEsEspecialista());
		//esto devuelve true si algun elemento de la lista de opiniones de muestra fue dejado por 
		//alguien que es experto o especialista
	}
	private List<Opinion> getOpiniones(Muestra muestra){
		return muestra.getOpiniones();
	}
	public boolean esVotada() {
		return false;
	}
	
	public OpinionBasicos () {
	
	}
}
