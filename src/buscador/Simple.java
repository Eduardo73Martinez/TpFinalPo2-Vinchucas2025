package buscador;

import java.util.List;

import web_vinchucas.Muestra;


abstract class Simple implements Filtro {

	public abstract List<Muestra> buscar(List<Muestra> lista);
	public Simple () {
		
	}
}
