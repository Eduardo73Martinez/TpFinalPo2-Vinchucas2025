package buscador;

import java.util.List;

import web_vinchucas.Muestra;

abstract class Simple extends Filtro {

	abstract List<Muestra> buscar();
	public Simple (Web web) {
		super (web);
	}
}
