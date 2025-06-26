package verificacion;

import web_vinchucas.IOpinable;
import web_vinchucas.Muestra;
import web_vinchucas.Usuario;

public class Verificada implements Verificacion{
	
	IOpinable tipo;
	
	
	public boolean puedeVotar (Usuario usuario) {
		//PROPOSITO:devuelve true si el usuario tiene permiso de votar, de no ser asi devuelve false (en este caso es siempre false)
		return false;
	}

	public void verificar(Muestra muestra) {
		//PROPOSITO:al ya estar verificada en este caso no hace nada
	}
	
	public String resultadoActual (Muestra muestra) {
		//PROPOSITO:develve la vinchuca que fue mas votada
		return muestra.getVinchuca().getValor();
		
	}
	
	private void setTipoVinchuca (IOpinable tipo) {
		//PROPOSITO:setea el tipo de vinchuca
		this.tipo = tipo;
	}
	public Verificada (IOpinable tipo) {
		
		setTipoVinchuca (tipo);
	}
}
