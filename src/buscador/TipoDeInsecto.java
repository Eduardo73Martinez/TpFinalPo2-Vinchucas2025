package buscador;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.*;

public class TipoDeInsecto extends Simple {

	
	Muestra muestraDummy = mock(Muestra.class);
	IOpinable vinchuca;
	
	public List<Muestra> buscar(){
		//PROPOSITO:devuelve las muestras que son del tipo de insecto ingresado
		
		return todasLasMuestras().stream()
		.filter(muestra-> muestra.resultadoActual() == vinchuca.getValor() )
		.collect (Collectors.toList());
		
		
		
	}
	
	private void setOpinable (IOpinable vinchuca) {
		//PROPOSITO:setea el insecto
		this.vinchuca = vinchuca;
	}
	
	public TipoDeInsecto (Web web,IOpinable vinchuca) {
		super (web);
		setOpinable(vinchuca);
	}
	
	
}
