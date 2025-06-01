package verificacion;
import web_vinchucas.Muestra;
import web_vinchucas.Usuario;
public abstract class Verificacion {




	protected Muestra muestra;
	abstract boolean esVerificada();
	abstract boolean puedeVotar (Usuario usuario);
	abstract void verificar(); //recalcula el tipo de verificacion
	abstract boolean esVotada;
	private void setMuestra (Muestra muestra){
		this.muestra = muestra;
	}
	public Verificacion (Muestra muestra) {
		setMuestra (muestra);
	}
		
	

}
