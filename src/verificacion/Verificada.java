package verificacion;

import web_vinchucas.Muestra;
import web_vinchucas.Usuario;

public class Verificada extends Verificacion{
	TipoOpinion tipo;
	public boolean esVerificada() {
		return true;
	}
	public boolean puedeVotar (Usuario usuario) {
		return false;
	}
	public boolean verificar() {
		//si ya esta verificada es definitivo y no recalcula
	}
	public void getVincucha () {
		return tipo;
	}
	private void setTipoVincucha (TipoOpinion tipo) {
		this.tipo = tipo;
	}
	public Verificada (Muestra muestra,TipoOpinion tipo) {
		super (muestra);
		setTipoVincucha (tipo);
	}
}
