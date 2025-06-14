package verificacion;


import java.util.Comparator;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import web_vinchucas.IOpinable;
import web_vinchucas.Muestra;
import web_vinchucas.Usuario;



public abstract  class NoVerificada implements Verificacion {
	public abstract boolean esVerificada();
	public abstract boolean puedeVotar (Usuario usuario);
	public abstract void verificar(Muestra muestra); //recalcula el tipo de verificacion
	public abstract boolean esVotada();
	public abstract String resultadoActual (Muestra muestra);
	
	
	protected Map<IOpinable,Long> mapOpinionesYSuCantidad (List<IOpinable> opinables){
		//devuelve el iOpinable con su cantidad agrupados en maps
		return opinables.stream()
		.collect(Collectors.groupingBy (c->c, Collectors.counting()));
	}
	protected Long valorDelMayor (Map<IOpinable,Long> map) {
		//devuelve el long de mayor valor
		return map.entrySet().stream() //si no convierto el map en set no funciona stream
				.map(s->s.getValue()) //reemplazo todo por una lista de valores
				.max(Comparator.naturalOrder()).get();
	}
	protected IOpinable keyDelValorIngresado (Map<IOpinable,Long> map,Long valor) {
		/*PROPOSITO:devuelve una key que coincide con el valor ingresado
		  PRECONDICION:debe existir una key que coincida con el valor ingresado
		 */
		return 
		map.entrySet().stream()
		.filter(i->i.getValue()==valor)
		.findFirst()
		.get()
		.getKey();
		
	}
	
	protected IOpinable opinionMayoritaria(List<IOpinable> listaDeOpinables) {
		//devuelve la opinion que mas se repite (solo contando las opiniones que provienen de expertos o especialistas)
		//PRECONDICION:hay una opinion mayoritaria
		Map<IOpinable,Long> mapRepetidoMasVeces =  mapOpinionesYSuCantidad(listaDeOpinables);
		
		Long valorDelMayor = valorDelMayor (mapRepetidoMasVeces);
		
		IOpinable keyDelMayor = keyDelValorIngresado (mapRepetidoMasVeces,valorDelMayor);
		
		return keyDelMayor;
	}
	protected boolean hayAlMenosDosOpinionesDiferentes(List<IOpinable> listaOpinables) {
		Set<IOpinable> set = new HashSet<IOpinable>();
		set.addAll(listaOpinables);
		return (set.size()>1);
	}
	protected boolean hayOpinionMayoritaria (List<IOpinable> opinables) {
		//PROPOSITO:devuelve true si hay una opinion que supera a todas las demas sin empate y fue dejada por expertos o especialistas
		
		Map<IOpinable,Long> mapRepetidoMasVeces =  mapOpinionesYSuCantidad(opinables);
		
		Long valorDelMayor = valorDelMayor (mapRepetidoMasVeces);
				
		IOpinable keyDelMayor = keyDelValorIngresado (mapRepetidoMasVeces,valorDelMayor);
				
		Map<IOpinable,Long> mapSinMayor = mapRepetidoMasVeces;
		mapSinMayor.remove(keyDelMayor);
		Long valorDelSegundoMayor = valorDelMayor (mapSinMayor);
				
		return ( valorDelMayor > valorDelSegundoMayor);
				
	}
	
	
	public NoVerificada (){
		
	}
}
