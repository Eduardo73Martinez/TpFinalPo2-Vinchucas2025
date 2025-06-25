package ar.edu.unq.po2.integrador.buscador;
import java.util.List;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


abstract class Simple implements Filtro {

	public abstract List<Muestra> buscar(List<Muestra> lista);
	public Simple () {
		
	}
}
