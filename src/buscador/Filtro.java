package buscador;


import java.util.List;

import web_vinchucas.Muestra;


interface Filtro {
	
	
	abstract List<Muestra> buscar(List<Muestra> lista);
	
	
}
