package ar.edu.unq.po2.integrador.buscador;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class TipoDeInsecto extends Simple {

	
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
