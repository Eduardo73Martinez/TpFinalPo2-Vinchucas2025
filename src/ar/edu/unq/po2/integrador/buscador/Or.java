package ar.edu.unq.po2.integrador.buscador;

import java.util.*;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;



public class Or extends Compuesto {
	public List<Muestra> buscar(List<Muestra> lista) {
		//PROPOSITO:devuelve las muestras que al menos uno de los filtros devuelve
		Set<Muestra> setConFiltros= new HashSet<>(primerFiltro.buscar(lista));
		//el set es para evitar repetidos
		setConFiltros.addAll (segundoFiltro.buscar(lista)); //uno lo que esta en una u otra lista
		List<Muestra> listaConFiltros = new ArrayList<>(setConFiltros);
		return  listaConFiltros;
	}
	public Or (Filtro filt1, Filtro filt2) {
		super (filt1,filt2);
	}
}
