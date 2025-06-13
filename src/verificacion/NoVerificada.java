package verificacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import web_vinchucas.IOpinable;
import web_vinchucas.Muestra;
import web_vinchucas.Nivel;
import web_vinchucas.Opinion;
import web_vinchucas.Usuario;
import java.util.stream.Collectors;


public abstract  class NoVerificada extends Verificacion {
	public abstract boolean esVerificada();
	public abstract boolean puedeVotar (Usuario usuario);
	public abstract void verificar(Muestra muestra); //recalcula el tipo de verificacion
	public abstract boolean esVotada();
	public abstract String resultadoActual (Muestra muestra);
	
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
	protected List<IOpinable> getOpinionesDeExpertos(Muestra muestra){
		//devuelve los enums de las opiniones de los expertos
		return 
				getOpinionesExpertos(muestra).stream()
				.map(opinion->opinion.getValorOpinion())
				.collect(Collectors.toList());
	}
	
	protected IOpinable opinionMayoritariaDeExpertosOEspecialistas(Muestra muestra) {
		//devuelve la opinion que mas se repite (solo contando las opiniones que provienen de expertos o especialistas)
		//PRECONDICION:hay una opinion mayoritaria
		Map<IOpinable,Long> mapRepetidoMasVeces = getOpinionesDeExpertos(muestra).stream()
		.collect(Collectors.groupingBy (c->c, Collectors.counting())); //convierto en un map
		
		
		Long valorDelMayor = mapRepetidoMasVeces.entrySet().stream() //si no convierto el map en set no funciona stream
				.map(s->s.getValue()) //reemplazo todo por una lista de valores
				.max(Comparator.naturalOrder()).get();
				
		IOpinable keyDelMayor = null;
		Iterator<Map.Entry<IOpinable, Long>> iterator = mapRepetidoMasVeces.entrySet().iterator(); //el iterator todavia no tiene elemento
		Map.Entry<IOpinable, Long> entry = iterator.next();
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
