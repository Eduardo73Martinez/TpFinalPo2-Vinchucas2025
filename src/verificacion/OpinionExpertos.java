package verificacion;
import web_vinchucas.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OpinionExpertos extends NoVerificada{
	
	
	public boolean puedeVotar (Usuario usuario) {
		//PROPOSITO:devuelve true si el usuario tiene permiso de votar, de no ser asi devuelve false
		return  (!(usuario.getNivel() == Nivel.BASICO )) ;
	}
	public void verificar(Muestra muestra) {
		//PROPOSITO:convierte el estado en verificada si hay al menos 2 que expertos/especialistas opinan igual sin empate
	
		if (hayOpinionMayoritariaDeDosOMasExpertos (muestra)) {
				
				IOpinable opinionMayoritariaExpertos = opinionMayoritaria (getIOpinableDeExpertos (muestra));
				Verificada verif = new Verificada (opinionMayoritariaExpertos);
				muestra.setVerificacion(verif);
				muestra.actualizarVinchuca (opinionMayoritariaExpertos);
		} 
	}
	public String resultadoActual (Muestra muestra) {
		
		//PROPOSITO:devuelve la opinion compartida por mas expertos/especialistas
		
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
		//PROPOSITO:devuelve true si al menos 2 expertos/especialistas opinan igual, falso en caso contrario
		Map<IOpinable,Long> mapRepetidoMasVeces =  mapOpinionesYSuCantidad(getIOpinableDeExpertos(muestra));
		
		Long valorDelMayor = valorDelMayor (mapRepetidoMasVeces);
				
		return (valorDelMayor >=2);
		
	}

	
	protected List<Opinion> getOpinionesExpertos(Muestra muestra){
		//PROPOSITO:devuelve las opiniones de expertos y especialistas pero no otras
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
		//PROPOSITO:devuelve los enums de las opiniones de los expertos y especialistas
		return 
				getOpinionesExpertos(muestra).stream()
				.map(opinion->opinion.getValorOpinion())
				.collect(Collectors.toList());
	}
	
	
	
	
	
	public OpinionExpertos () {
		}
}
