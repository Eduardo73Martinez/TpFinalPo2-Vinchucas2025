package ar.edu.unq.po2.integrador.buscador;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


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
