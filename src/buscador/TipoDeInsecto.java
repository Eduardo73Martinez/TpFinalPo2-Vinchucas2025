package buscador;

import java.util.List;

import web_vinchucas.Muestra;

public class TipoDeInsecto extends Simple {

	public List<Muestra> buscar(IOpinable vinchuca){
		//solo devuelve verificadas del tipo de insecto asumido
		
		SoloVerificadas verificadas = new SoloVerificadas (web);
		List<Muestra> listVerificadas = verificadas.buscar();
		
		return
		listVerificadas.stream
		filter (muestra-> getVerificacion().getVinchuca() == vinchuca)
		.collect (collectors.toList());

	}
	public TipoDeInsecto (Web web) {
		super (web);
	}
}
