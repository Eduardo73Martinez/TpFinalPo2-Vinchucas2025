package ar.edu.unq.po2.integrador.buscador;


import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


abstract class PorVerificacion extends Simple {
	
	abstract boolean esMuestraValida (Muestra muestra);
	public PorVerificacion () {
		
	}
}
