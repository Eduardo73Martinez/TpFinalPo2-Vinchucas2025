package ar.edu.unq.po2.integrador.buscador;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


abstract class Simple implements Filtro {
	
	abstract boolean esMuestraValida (Muestra muestra);
	
	public List<Muestra> buscar(List<Muestra> lista){
		//PROPOSITO:devuelve las muestras que fueron creadas antes de la fecha ingresada		
			return lista.stream()
			.filter(muestra->esMuestraValida(muestra))
			.collect(Collectors.toList());
		}
	
	public Simple () {
		
	}
}
