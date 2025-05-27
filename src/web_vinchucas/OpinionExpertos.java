package web_vinchucas;

public class OpinionExpertos extends NoVerificada {
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
	private boolean hayUnExpertoOEspecialistaQueOpino () {
		return not muestra.stream().anyMatch(elemento->elemento.getUsuarioQueDejoOpinionEsExperto() || getUsuarioQueDejoOpinonEsEspecialista());
		//esto devuelve true si algun elemento de la lista de opiniones de muestra fue dejado por 
		//alguien que es experto o especialista
	}
	
	public OpinionExpertos (Muestra muestra) {
		super (muestra);
	}
}
