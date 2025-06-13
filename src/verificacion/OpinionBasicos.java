package verificacion;

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

public class OpinionBasicos extends NoVerificada {
	public boolean esVerificada() {
		return false;
	}
	public boolean puedeVotar (Usuario usuario) {
		return true;
	}
	public String resultadoActual (Muestra muestra) {
		
		if (hayOpinionMayoritaria(muestra)) {
			return opinionMayoritaria(muestra).getValor();
		} else {
			return "No definido";
		}
	}
	
	public void verificar(Muestra muestra) {
		//hago que pase a ser OpinionExpertos al haber al menos una opinon de experto o especialista
		if (algunExpertoOEspecialistaOpino (muestra)) {
		OpinionExpertos opinionExperto = new OpinionExpertos ();
		muestra.setVerificacion (opinionExperto);
		}
	}
	private boolean algunExpertoOEspecialistaOpino(Muestra muestra) {
		return getOpiniones(muestra).stream().anyMatch(
				elemento->elemento.getNivelOpinion() == Nivel.EXPERTO ||
				elemento.getNivelOpinion() == Nivel.ESPECIALISTA);
		//esto devuelve true si algun elemento de la lista de opiniones de muestra fue dejado por 
		//alguien que es experto o especialista
	}
	private List<Opinion> getOpiniones(Muestra muestra){
		return muestra.getOpiniones();
	}
	public boolean esVotada() {
		return false;
	}
	protected boolean hayOpinionMayoritaria (Muestra muestra) {
		//PROPOSITO:devuelve true si hay una opinion que supera a todas las demas sin empate y fue dejada por expertos o especialistas
		
		Map<IOpinable,Long> mapRepetidoMasVeces = (Map<IOpinable, Long>) muestra.getOpiniones().stream()
				.collect(Collectors.groupingBy (c-> c.getValorOpinion(), Collectors.counting())); //convierto en un map
				
				
				Long valorDelMayor = mapRepetidoMasVeces.entrySet().stream() //si no convierto el map en set no funciona stream
						.map(s->s.getValue()) //reemplazo todo por una lista de valores
						.max(Comparator.naturalOrder()).get();
						
				
				Iterator<Map.Entry<IOpinable, Long>> iterator = mapRepetidoMasVeces.entrySet().iterator(); //el iterator todavia no tiene elemento
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
	
	protected IOpinable opinionMayoritaria(Muestra muestra) {
		//devuelve la opinion que mas se repite (solo contando las opiniones que provienen de expertos o especialistas)
		//PRECONDICION:hay una opinion mayoritaria
		Map<IOpinable, Long> mapRepetidoMasVeces = (Map<IOpinable, Long>) muestra.getOpiniones().stream()
		.collect(Collectors.groupingBy (c->c.getValorOpinion(), Collectors.counting())); //convierto en un map
		
		
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
	
	public OpinionBasicos () {
	
	}
}
