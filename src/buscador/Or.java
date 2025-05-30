package buscador;

public class Or extends Compuesto {
	public List<Muestra> buscar() {
		Set<Muestra> setConFiltros= new HashSet<>(filt1.buscar());
		//el set es para evitar repetidos
		setConFiltros.addAll (filt2); //uno lo que esta en una u otra lista
		List<Muestra> listaConFiltros = new ArrayList<>(setConFiltros);
		return  listaConFiltros;
	}
	public void And (Filtro filt1, Filtro filt2,Web web) {
		super (filt1,filt2,web);
	
}
