package buscador;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Collectors;

import web_vinchucas.*;

public class TipoDeInsecto extends Simple {

	
	Muestra muestraDummy = mock(Muestra.class);
	IOpinable vinchuca;
	
	public List<Muestra> buscar(List<Muestra> lista){
		//PROPOSITO:devuelve las muestras que son del tipo de insecto ingresado
		
		return lista.stream()
		.filter(muestra-> muestra.resultadoActual() == vinchuca.getValor() )
		.collect (Collectors.toList());
		
		
		
	}
	
	private void setOpinable (IOpinable vinchuca) {
		//PROPOSITO:setea el insecto
		this.vinchuca = vinchuca;
	}
	
	public TipoDeInsecto (IOpinable vinchuca) {
		
		setOpinable(vinchuca);
	}
	
	
}
