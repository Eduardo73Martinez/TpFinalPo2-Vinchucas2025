package buscador;

import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.*;

public class TipoDeInsecto extends Simple {

	
	Muestra muestraDummy = mock(Muestra.class);
	IOpinable vinchuca;
	
	public List<Muestra> buscar(){
		
		return todasLasMuestras().stream()
		.filter(muestra-> muestra.resultadoActual() == vinchuca.getValor() )
		.collect (Collectors.toList());
		
		
		
	}
	
	private void setOpinable (IOpinable vinchuca) {
		this.vinchuca = vinchuca;
	}
	
	public TipoDeInsecto (Web web,IOpinable vinchuca) {
		super (web);
		setOpinable(vinchuca);
	}
	
	
}
