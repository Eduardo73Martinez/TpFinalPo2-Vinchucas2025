package buscador;
import java.util.*;
import web_vinchucas.*;



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
