package verificacion;

import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;
import web_vinchucas.Opinion;
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
	public void verificar() {
		//debo agregar algo que compruebe si dos expertos opinan igual,en caso de que sea asi
		//se comprueba el que tenga mas experto que opinen igual, si hay empate no se cambia la clase asi
		//verifica de nuevo al agregarse una opinion
	
		if (hayMayoriaDeUnaOpinion()) {
			Verificada verif = new Verificada (muestra,opinionMayoritaria());
		} 
	}
	private List<Opinion> getOpinionesExpertos(){
		//devuelve las opiniones de expertos y especialistas pero no otras
		return (
				muestra.getOpiniones().stream()
		.filter (opinion->opinion.getUsuarioQueDejoOpinionEsExperto()
				||opinion.getUsuarioQueDejoOpinionEsEspecialista())
		.collect(Collectors.toList())
		);
		
		//el stream lo cambia de tipo a uno trabajable por filtro y el collectors lo 
		//devuelve a tipo list
			   

	}
	
	
	public OpinionExpertos (Muestra muestra) {
		super (muestra);
	}
}
