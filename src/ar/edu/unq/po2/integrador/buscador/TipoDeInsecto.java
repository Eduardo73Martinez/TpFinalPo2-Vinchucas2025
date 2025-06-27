package ar.edu.unq.po2.integrador.buscador;



import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public class TipoDeInsecto extends Simple {

	
	IOpinable vinchuca;
	
	
	public boolean esMuestraValida (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue votada, si no lo es da false
		return muestra.resultadoActual() == vinchuca.getValor();
	}
	
	private void setOpinable (IOpinable vinchuca) {
		//PROPOSITO:setea el insecto
		this.vinchuca = vinchuca;
	}
	
	public TipoDeInsecto (IOpinable vinchuca) {
		
		setOpinable(vinchuca);
	}
	
	
}
