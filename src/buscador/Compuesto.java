package buscador;

import java.util.List;
import web_vinchucas.*;

public abstract class Compuesto extends Filtro{
	Filtro primerFiltro;
	Filtro segundoFiltro;
	
	public void setPrimerFiltro (Filtro filt) {
		this.primerFiltro = filt;
	}
	public void setSegundoFiltro (Filtro filt) {
		this.segundoFiltro = filt;
	}
	abstract List<Muestra> buscar();
	public Compuesto (Filtro filt1, Filtro filt2,Web web) {
		super (web);
		setPrimerFiltro (filt1);
		setSegundoFiltro (filt2);
		
	}

}
