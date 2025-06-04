package buscador;

import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.Muestra;

abstract class PorVerificacion extends Simple {
	
	public List<Muestra> buscar(){
		return (
				web.todasLasMuestras().stream()
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
