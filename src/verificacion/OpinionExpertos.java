package verificacion;
import web_vinchucas.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OpinionExpertos extends NoVerificada{
	public boolean esVerificada() {
		return false;
	}
	public boolean puedeVotar (Usuario usuario) {
		return  (!(usuario.getNivel() == Nivel.BASICO )) ;
	}
	public void verificar(Muestra muestra) {
		//debo agregar algo que compruebe si dos expertos opinan igual,en caso de que sea asi
		//se comprueba el que tenga mas experto que opinen igual, si hay empate no se cambia la clase asi
		//verifica de nuevo al agregarse una opinion
	
		if (hayOpinionMayoritariaDeDosOMasExpertos (muestra)) {
				
				IOpinable opinionMayoritariaExpertos = opinionMayoritaria (getIOpinableDeExpertos (muestra));
				Verificada verif = new Verificada (opinionMayoritariaExpertos);
				muestra.setVerificacion(verif);
				muestra.actualizarVinchuca (opinionMayoritariaExpertos);
		} 
	}
	public String resultadoActual (Muestra muestra) {
		//en opiniones expertos ya no se toma en cuenta opiniones de usuarios basicos,
		//asi que esto devuelve la opinion compartida por mas expertos
		
		if (hayAlMenosDosOpinionesDiferentes (getIOpinableDeExpertos(muestra)) &&
				! (hayOpinionMayoritaria(getIOpinableDeExpertos(muestra)))){
			return "No definido";
		} else { //en este caso no hay al menos 2 opiniones distintas o las hay y hay mayoria
			return opinionMayoritaria(getIOpinableDeExpertos(muestra)).getValor();
		}
			
			
	}
	private boolean hayOpinionMayoritariaDeDosOMasExpertos (Muestra muestra) {
		//PROPOSITO:devuelve true hay una opinion compartida por al menos 2 personas y
		//fue dejada por expertos (eran expertos cuando la dejaron)
	return hayOpinionCompartidaPorDosOMasExpertosOEspecialistas(muestra) && 
		   hayOpinionMayoritaria(getIOpinableDeExpertos(muestra));
	}
	
	private boolean hayOpinionCompartidaPorDosOMasExpertosOEspecialistas(Muestra muestra) {
		
		Map<IOpinable,Long> mapRepetidoMasVeces =  mapOpinionesYSuCantidad(getIOpinableDeExpertos(muestra));
		
		Long valorDelMayor = valorDelMayor (mapRepetidoMasVeces);
				
		return (valorDelMayor >=2);
		
	}

	
	protected List<Opinion> getOpinionesExpertos(Muestra muestra){
		//devuelve las opiniones de expertos y especialistas pero no otras
		List<Opinion> lista= (
				muestra.getOpiniones().stream()
		.filter (opinion-> opinion.getNivelOpinion() == Nivel.EXPERTO
				||opinion.getNivelOpinion() == Nivel.ESPECIALISTA)
		.collect(Collectors.toList())
		);
		
		//el stream lo cambia de tipo a uno trabajable por filtro y el collectors lo 
		//devuelve a tipo list
		return lista;
			   

	}
	protected List<IOpinable> getIOpinableDeExpertos(Muestra muestra){
		//devuelve los enums de las opiniones de los expertos y especialistas
		return 
				getOpinionesExpertos(muestra).stream()
				.map(opinion->opinion.getValorOpinion())
				.collect(Collectors.toList());
	}
	
	
	
	public boolean esVotada() {
		return true;
	}
	
	
	public OpinionExpertos () {
		}
}
