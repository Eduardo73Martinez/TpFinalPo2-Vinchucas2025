package verificacion;

import web_vinchucas.IOpinable;
import web_vinchucas.Muestra;
import web_vinchucas.Usuario;

public class Verificada implements Verificacion{
	
	IOpinable tipo;
	public boolean esVerificada() {
		return true;
	}
	public boolean puedeVotar (Usuario usuario) {
		return false;
	}
	public boolean esVotada () { 
		return true;
	}
	public void verificar(Muestra muestra) {
		//si ya esta verificada es definitivo y no recalcula
	}
	
	public String resultadoActual (Muestra muestra) {
		return tipo.getValor();
		
	}
	
	private void setTipoVincucha (IOpinable tipo) {
		this.tipo = tipo;
	}
	public Verificada (IOpinable tipo) {
		
		setTipoVincucha (tipo);
	}
}
