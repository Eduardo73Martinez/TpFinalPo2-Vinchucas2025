package ar.edu.unq.po2.integrador.buscador;


import ar.edu.unq.po2.integrador.verificacion.Verificacion;
import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


abstract class PorVerificacion extends Simple {
	
	abstract boolean esMuestraValida (Muestra muestra);
	protected Verificacion verificacion (Muestra muestra) {
		return muestra.getVerificacion();
	}
	public PorVerificacion () {
		
	}
}
