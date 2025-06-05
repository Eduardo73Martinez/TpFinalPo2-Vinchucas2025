package buscador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import web_vinchucas.Muestra;



public class Or extends Compuesto {
	public List<Muestra> buscar() {
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
