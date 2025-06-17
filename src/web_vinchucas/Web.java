package web_vinchucas;

import java.util.List;

public class Web {
	private List<Muestra> muestrasSubidas;
	private List<Usuario> usuariosRegistrados;
	// private AppWebMovil aplicacionDelUsuario;
	// TENEMOS UNA VERSION MAS ACTUALIZADA EN NUESTRO MODELO TODAVIA FALTA
	// CONFIRMACION.

	public Web(List<Muestra> muestrasSubidas, List<Usuario> usuariosRegistrados) {
		super();
		this.muestrasSubidas = muestrasSubidas;
		this.usuariosRegistrados = usuariosRegistrados;
	}

	public List<Muestra> todasLasMuestras() {
		// TODO Auto-generated method stub
		return this.getMuestrasSubidas();
	}

	public void agregarMuestra(Muestra nuevaMuestra) {
		// TODO Auto-generated method stub
		this.muestrasSubidas.add(nuevaMuestra);
	}

	public void sacarMuestra(Muestra nuevaMuestra) {
		// TODO Auto-generated method stub
		if (this.getMuestrasSubidas().contains(nuevaMuestra)) {
			this.muestrasSubidas.remove(nuevaMuestra);
		}
	}

	public void desuscribirUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if (this.getUsuariosRegistrados().contains(usuario)) {
			this.usuariosRegistrados.remove(usuario);
		}
	}

	public List<Muestra> getMuestrasSubidas() {
		return muestrasSubidas;
	}

	public void setMuestrasSubidas(List<Muestra> muestrasSubidas) {
		this.muestrasSubidas = muestrasSubidas;
	}

	public List<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(List<Usuario> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}

}
