package buscador;

import java.util.List;
import web_vinchucas.*;

abstract class Simple extends Filtro {

	abstract List<Muestra> buscar();
	public Simple (Web web) {
		super (web);
	}
}
