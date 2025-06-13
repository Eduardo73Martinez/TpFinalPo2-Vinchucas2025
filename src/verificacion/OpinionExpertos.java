package verificacion;
import web_vinchucas.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	
		if (hayOpinionCompartidaPorDosOMasExpertosOEspecialistas(muestra)) {
			
			
			if ( hayOpinionMayoritariaDeexpertosOEspecialistas(muestra)) {
				
				Verificada verif = new Verificada (opinionMayoritariaDeExpertosOEspecialistas(muestra));
				muestra.setVerificacion(verif);
				muestra.actualizarVinchuca (opinionMayoritariaDeExpertosOEspecialistas(muestra));
			}
		} 
	}
	public String resultadoActual (Muestra muestra) {
		//en opiniones expertos ya no se toma en cuenta opiniones de usuarios basicos,
		//asi que esto devuelve la opinion compartida por mas expertos
		if (hayOpinionMayoritariaDeexpertosOEspecialistas (muestra)) {
			
			return opinionMayoritariaDeExpertosOEspecialistas(muestra).getValor();
		} else {
			return "No definido";
		}
	}
	private boolean hayOpinionMayoritariaDeDosOMasExpertos (Muestra muestra) {
		//PROPOSITO:devuelve true hay una opinion compartida por al menos 2 personas y
		//fue dejada por expertos (eran expertos cuando la dejaron)
	return hayOpinionCompartidaPorDosOMasExpertosOEspecialistas(muestra) && 
		   hayOpinionMayoritariaDeexpertosOEspecialistas(muestra);
	}
	
	private boolean hayOpinionCompartidaPorDosOMasExpertosOEspecialistas(Muestra muestra) {
		
		Map<IOpinable,Long> mapRepetidoMasVeces = getOpinionesExpertos(muestra).stream()
				.collect(Collectors.groupingBy (c->c.getValorOpinion(), Collectors.counting())); //convierto en un map
				
		
			if (mapRepetidoMasVeces.isEmpty() ) {
				return false; //al no haber opiniones es false
			} else {
				Long valorDelMayor = mapRepetidoMasVeces.entrySet().stream() //si no convierto el map en set no funciona stream
						.map(s->s.getValue()) //reemplazo todo por una lista de valores
						.max(Comparator.naturalOrder()).get();
				
				
				return (valorDelMayor >=2);
			}
	}
	private boolean hayOpinionMayoritariaDeexpertosOEspecialistas (Muestra muestra) {
		//PROPOSITO:devuelve true si hay una opinion que supera a todas las demas sin empate y fue dejada por expertos o especialistas
		
		Map<IOpinable,Long> mapRepetidoMasVeces = getOpinionesDeExpertos(muestra).stream()
				.collect(Collectors.groupingBy (c->c, Collectors.counting())); //convierto en un map
				
				
				Long valorDelMayor = mapRepetidoMasVeces.entrySet().stream() //si no convierto el map en set no funciona stream
						.map(s->s.getValue()) //reemplazo todo por una lista de valores
						.max(Comparator.naturalOrder()).get();
						
				
				Iterator<Entry<IOpinable, Long>> iterator = mapRepetidoMasVeces.entrySet().iterator(); //el iterator todavia no tiene elemento
				Map.Entry<IOpinable, Long> entry = iterator.next();
				while (!(entry.getValue()).equals (valorDelMayor)) {
				    
				    
				     entry = iterator.next();
				    }
				
				
				Map<IOpinable,Long> mapSinMayor = mapRepetidoMasVeces;
				mapSinMayor.remove(entry.getKey());
				Long valorDelSegundoMayor = mapSinMayor.entrySet().stream() //si no convierto el map en set no funciona stream
						.map(s->s.getValue()) //reemplazo todo por una lista de valores
						.max(Comparator.naturalOrder()).get();
						
				
				Iterator<Map.Entry<IOpinable, Long>> iterator2 = mapSinMayor.entrySet().iterator(); //repito lo anterior con el map sin el mayor asi tengo el segundo mayor
				Map.Entry<IOpinable, Long> entry2 = iterator2.next();
				
				while (!(entry2.getValue()).equals (valorDelSegundoMayor)) {				    
				     entry2 = iterator2.next();
				    }
				return (entry.getValue()>entry2.getValue());
				
	}
	
	public boolean esVotada() {
		return true;
	}
	
	
	public OpinionExpertos () {
		}
}
