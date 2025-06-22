package buscador;
import java.util.List;
import web_vinchucas.*;


interface Filtro {
	
	
	abstract List<Muestra> buscar(List<Muestra> lista);
	
	
}
