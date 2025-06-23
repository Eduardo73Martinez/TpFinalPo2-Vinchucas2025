package buscador;
import java.util.List;
import web_vinchucas.*;


abstract class Simple implements Filtro {

	public abstract List<Muestra> buscar(List<Muestra> lista);
	public Simple () {
		
	}
}
