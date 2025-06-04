package verificacion;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	public void verificar(Muestra muestra) {
		//debo agregar algo que compruebe si dos expertos opinan igual,en caso de que sea asi
		//se comprueba el que tenga mas experto que opinen igual, si hay empate no se cambia la clase asi
		//verifica de nuevo al agregarse una opinion
	
		if (hayMayoriaDeUnaOpinion(muestra)) {
			Verificada verif = new Verificada (opinionMayoritaria(muestra));
		} 
	}
	private boolean hayMayoriaDeUnaOpinion (Muestra muestra) {
		//PROPOSITO:devuelve true hay una opinion compartida por al menos 2 personas y
		//fue dejada por expertos (eran expertos cuando la dejaron)
	return hayOpinionCompartidaPorDosOMasPersonas(muestra) && hayOpinionMayoritaria(muestra);
	}
	private boolean hayOpinionCompartidaPorDosOMasPersonas(Muestra muestra) {
		Map<TipoOpinion,Long> mapRepetidoMasVeces = getOpinionesDeExpertos(muestra).stream()
				.collect(Collectors.groupingBy (c->c, Collectors.counting())); //convierto en un map
				
				
				Long valorDelMayor = mapRepetidoMasVeces.entrySet().stream() //si no convierto el map en set no funciona stream
						.map(s->s.getValue()) //reemplazo todo por una lista de valores
						.max(Comparator.naturalOrder()).get();
						
				
				
				return (valorDelMayor >2);
	}
	private boolean hayOpinionMayoritaria (Muestra muestra) {
		//PROPOSITO:devuelve true si hay una opinion que supera a todas las demas sin empate
		
		Map<TipoOpinion,Long> mapRepetidoMasVeces = getOpinionesDeExpertos(muestra).stream()
				.collect(Collectors.groupingBy (c->c, Collectors.counting())); //convierto en un map
				
				
				Long valorDelMayor = mapRepetidoMasVeces.entrySet().stream() //si no convierto el map en set no funciona stream
						.map(s->s.getValue()) //reemplazo todo por una lista de valores
						.max(Comparator.naturalOrder()).get();
						
				
				Iterator<Map.Entry<TipoOpinion, Long>> iterator = mapRepetidoMasVeces.entrySet().iterator(); //el iterator todavia no tiene elemento
				Map.Entry<TipoOpinion, Long> entry = iterator.next();
				while (!(entry.getValue()).equals (valorDelMayor)) {
				    
				    
				     entry = iterator.next();
				    }
				
				
				Map<TipoOpinion,Long> mapSinMayor = mapRepetidoMasVeces;
				mapSinMayor.remove(entry.getKey());
				Long valorDelSegundoMayor = mapSinMayor.entrySet().stream() //si no convierto el map en set no funciona stream
						.map(s->s.getValue()) //reemplazo todo por una lista de valores
						.max(Comparator.naturalOrder()).get();
						
				
				Iterator<Map.Entry<TipoOpinion, Long>> iterator2 = mapSinMayor.entrySet().iterator(); //repito lo anterior con el map sin el mayor asi tengo el segundo mayor
				Map.Entry<TipoOpinion, Long> entry2 = iterator2.next();
				
				while (!(entry2.getValue()).equals (valorDelSegundoMayor)) {				    
				     entry2 = iterator2.next();
				    }
				return (entry.getValue()>entry2.getValue());
				
	}
	
	public boolean esVotada() {
		return true;
	}
	
	
	public OpinionExpertos (Muestra muestra) {
		super (muestra);
	}
}
