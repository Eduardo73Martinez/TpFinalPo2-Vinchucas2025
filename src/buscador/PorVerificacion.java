package buscador;

import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;


abstract class PorVerificacion extends Simple {
	
	public List<Muestra> buscar(List<Muestra> lista){
		//PROPOSITO:devuelve los filtros que son del tipo de verificacion de la clase
		return (
				lista.stream()
		.filter (muestra->this.esDelTipoEsperado(muestra)
				)
		.collect(Collectors.toList())
		);
		
	}
	
	abstract boolean esDelTipoEsperado(Muestra muestra);
	public PorVerificacion () {
		
	}
}
