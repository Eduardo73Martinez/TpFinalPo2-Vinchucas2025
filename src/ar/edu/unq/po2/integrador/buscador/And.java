package ar.edu.unq.po2.integrador.buscador;
import java.util.*;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;



public class And extends Compuesto {
	
	
	public List<Muestra> buscar(List<Muestra> lista) {
		//PROPOSITO:devuelve las muestras que ambos filtros devuelven
		List<Muestra> lista1 = primerFiltro.buscar(lista);
		List<Muestra> lista2 = segundoFiltro.buscar(lista);
		lista1.retainAll(lista2); //hace una interseccion
		return lista1;
	}
	public And (Filtro filt1, Filtro filt2) {
		super (filt1,filt2);
	}
}
