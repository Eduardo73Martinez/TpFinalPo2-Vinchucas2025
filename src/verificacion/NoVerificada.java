package verificacion;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;
import web_vinchucas.Opinion;
import web_vinchucas.Usuario;
import java.util.stream.Collectors;


public abstract  class NoVerificada extends Verificacion {
	abstract boolean esVerificada();
	abstract boolean puedeVotar (Usuario usuario,Muestra muestra);
	abstract void verificar(Muestra muestra); //recalcula el tipo de verificacion
	abstract boolean esVotada();
	private List<Opinion> getOpinionesExpertos(Muestra muestra){
		//devuelve las opiniones de expertos y especialistas pero no otras
		return (
				muestra.getOpiniones().stream()
		.filter (opinion-> opinion.getNivelUsuarioQueDejoOpinion() == Nivel.EXPERTO
				||opinion.getUsuarioQueDejoOpinionEsEspecialista() == Nivel.ESPECIALISTA)
		.collect(Collectors.toList())
		);
		
		//el stream lo cambia de tipo a uno trabajable por filtro y el collectors lo 
		//devuelve a tipo list
			   

	}
	protected List<TipoOpinion> getOpinionesDeExpertos(Muestra muestra){
		return (
				getOpinionesExpertos(muestra)
				.stream()
				.map(opinion->opinion.getQueVinchucaEs())
				.collect(Collectors.toList())
				);
	}
	public TipoOpinion opinionMayoritaria(Muestra muestra) {
		//devuelve la opinion que mas se repite (solo contando las opiniones que provienen de expertos)
		//PRECONDICION:hay una opinion mayoritaria
		Map<TipoOpinion,Long> mapRepetidoMasVeces = getOpinionesDeExpertos(muestra).stream()
		.collect(Collectors.groupingBy (c->c, Collectors.counting())); //convierto en un map
		
		
		Long valorDelMayor = mapRepetidoMasVeces.entrySet().stream() //si no convierto el map en set no funciona stream
				.map(s->s.getValue()) //reemplazo todo por una lista de valores
				.max(Comparator.naturalOrder()).get();
				
		TipoOpinion keyDelMayor = null;
		Iterator<Map.Entry<TipoOpinion, Long>> iterator = mapRepetidoMasVeces.entrySet().iterator(); //el iterator todavia no tiene elemento
		Map.Entry<TipoOpinion, Long> entry = iterator.next();
		while (!(entry.getValue()).equals (valorDelMayor)) {
		    
		    
		     entry = iterator.next();
		    }
		keyDelMayor = entry.getKey(); //en caso de que el valor del inicio sea correcto se salta el while y key del mayor se
									 //establece, si no recorre el while hasta llegar al correcto
		
		
		return (keyDelMayor);
		
	}
	public NoVerificada (){
		
	}
}
