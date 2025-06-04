package verificacion;

import web_vinchucas.Muestra;
import web_vinchucas.Usuario;

public class Verificada extends Verificacion{
	
	TipoOpinion tipo;
	public boolean esVerificada() {
		return true;
	}
	public boolean puedeVotar (Usuario usuario,Muestra muestra) {
		return false;
	}
	public boolean esVotada () {
		return true;
	}
	public void verificar(Muestra muestra) {
		//si ya esta verificada es definitivo y no recalcula
	}
	public TipoOpinion getVincucha () {
		return tipo;
	}
	private void setTipoVincucha (TipoOpinion tipo) {
		this.tipo = tipo;
	}
	public Verificada (TipoOpinion tipo) {
		
		setTipoVincucha (tipo);
	}
}
