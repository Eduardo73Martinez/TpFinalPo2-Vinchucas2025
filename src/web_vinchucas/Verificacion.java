package web_vinchucas;

public abstract class  Verificacion {

	protected Muestra muestra;
	abstract boolean esVerificada();
	abstract boolean puedeVotar (Usuario usuario);
	abstract void verificar(); //recalcula el tipo de verificacion
	private void setMuestra (Muestra muestra){
		this.muestra = muestra;
	}
	public Verificacion (Muestra muestra) {
		setMuestra (muestra);
	}
	
}
