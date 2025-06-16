package buscador;

import java.util.*;
import web_vinchucas.*;



public class Or extends Compuesto {
	public List<Muestra> buscar() {
		//PROPOSITO:devuelve las muestras que al menos uno de los filtros devuelve
		Set<Muestra> setConFiltros= new HashSet<>(primerFiltro.buscar());
		//el set es para evitar repetidos
		setConFiltros.addAll (segundoFiltro.buscar()); //uno lo que esta en una u otra lista
		List<Muestra> listaConFiltros = new ArrayList<>(setConFiltros);
		return  listaConFiltros;
	}
	public Or (Filtro filt1, Filtro filt2,Web web) {
		super (filt1,filt2,web);
	}
}
