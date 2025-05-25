package web_vinchucas;

public class NoVerificada {
	
	abstract boolean esVerificada();
	abstract boolean puedeVotar (Usuario usuario);
	abstract void verificar(); //recalcula el tipo de verificacion
	public NoVerificada (Muestra muestra) {
		super (muestra);
	}
}
