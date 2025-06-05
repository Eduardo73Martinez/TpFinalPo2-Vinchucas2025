package buscador;

import java.util.List;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

abstract class Simple extends Filtro {

	abstract List<Muestra> buscar();
	public Simple (Web web) {
		super (web);
	}
}
