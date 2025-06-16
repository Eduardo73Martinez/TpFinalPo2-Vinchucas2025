package buscador;

import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

abstract class PorVerificacion extends Simple {
	
	public List<Muestra> buscar(){
		//PROPOSITO:devuelve los filtros que son del tipo de verificacion de la clase
		return (
				todasLasMuestras().stream()
		.filter (muestra->this.esDelTipoEsperado(muestra)
				)
		.collect(Collectors.toList())
		);
		
	}
	
	abstract boolean esDelTipoEsperado(Muestra muestra);
	public PorVerificacion (Web web) {
		super (web);
	}
}
