package ar.edu.unq.po2.integrador.buscador;
import java.util.List;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public abstract class Compuesto implements Filtro{
	Filtro primerFiltro;
	Filtro segundoFiltro;
	
	public void setPrimerFiltro (Filtro filt) {
		//PROPOSITO:setea el primer filtro
		this.primerFiltro = filt;
	}
	public void setSegundoFiltro (Filtro filt) {
		//PROPOSITO:setea el segundo filtro
		this.segundoFiltro = filt;
	}
	public abstract List<Muestra> buscar(List<Muestra> lista);
	public Compuesto (Filtro filt1, Filtro filt2) {
	
		setPrimerFiltro (filt1);
		setSegundoFiltro (filt2);
		
	}

}
