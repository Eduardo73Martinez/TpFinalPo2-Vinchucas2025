package verificacion;

import web_vinchucas.Muestra;
import web_vinchucas.Usuario;

public class Verificada extends Verificacion{
	public boolean esVerificada() {
		return true;
	}
	public boolean puedeVotar (Usuario usuario) {
		return false;
	}
	public boolean verificar() {
		//si ya esta verificada es definitivo y no recalcula
	}
	public Verificada (Muestra muestra) {
		super (muestra);
	}
}
