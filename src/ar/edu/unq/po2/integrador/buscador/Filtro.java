package ar.edu.unq.po2.integrador.buscador;
import java.util.List;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


interface Filtro {
	
	
	abstract List<Muestra> buscar(List<Muestra> lista);
	
	
}
