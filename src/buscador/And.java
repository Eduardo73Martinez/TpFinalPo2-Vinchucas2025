package buscador;

public class And extends Compuesto {
	
	
	public void buscar() {
		Set<Muestra> setConFiltros= new HashSet<>(filt1.buscar());
		//el set es para evitar repetidos
		setConFiltros.addAll (filt2); //uno lo que esta en una u otra lista
		List<Muestra> listaConFiltros = new ArrayList<>(setConFiltros);
		return  listaConFiltros;
		List<Muestra> lista1 = filt1.buscar();
		List<Muestra> lista2 = filt2.buscar();
		lista1.retainAll(lista2); //hace una interseccion
		return lista1;
	}
	public And (Filtro filt1, Filtro filt2,Web web) {
		super (filt1,filt2,web);
	}
}
