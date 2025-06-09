package buscador;
import java.util.*;
import web_vinchucas.*;



public class And extends Compuesto {
	
	
	public List<Muestra> buscar() {

		List<Muestra> lista1 = primerFiltro.buscar();
		List<Muestra> lista2 = segundoFiltro.buscar();
		lista1.retainAll(lista2); //hace una interseccion
		return lista1;
	}
	public And (Filtro filt1, Filtro filt2,Web web) {
		super (filt1,filt2,web);
	}
}
