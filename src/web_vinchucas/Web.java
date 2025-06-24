package web_vinchucas;

import ZonaOrganizanizacionUbicacion.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Web {
	Long proximoId = 0l;
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	GestorDeUbicaciones gestorUbs = new GestorDeUbicaciones(new HashMap<Ubicacion, List<ZonaCobertura>>(), new ArrayList<ZonaCobertura>() );
	
	public Web(GestorDeUbicaciones gestorUbs) {
		this.gestorUbs = gestorUbs;
	}
	
	public GestorDeUbicaciones getGestorUbicaciones() {
		return gestorUbs;
	}

	public List<Muestra> todasLasMuestras() {
		return muestras;
	}
	
	public List<Usuario> todosLosUsuarios(){
		return usuarios;
	}
	
	public Long getProximoId() {
		return proximoId;
	}

	public void agregarMuestra(Muestra nuevaMuestra) {
		muestras.add(nuevaMuestra);
		this.notificarNuevaMuestra(nuevaMuestra);
	}
	
	public void quitarMuestra(Muestra muestra) {
		if (this.muestras.contains(muestra)) {
			muestras.remove(muestra);
		}
	}
	
	public void agregarUsuario() {
		Usuario usuarioNuevo = new Usuario(this, proximoId);
		usuarios.add(usuarioNuevo);
		this.proximoId++;
	}
	
	public void quitarUsuario(Usuario usuario) {
		if (this.usuarios.contains(usuario)) {
			usuarios.remove(usuario);
		}
	}
	
	public void actualizarNivel(List<Usuario> usuarios) {
		usuarios.stream().forEach(u->u.actualizarNivel());
	}
	
	public void convertirEnEspecialistas(List<Usuario> usuarios) {
		usuarios.stream().forEach(u->u.convertirEnEspecialista());
	}
	
	public Ubicacion verificarUbicacion(Ubicacion ubicacion) {
		return gestorUbs.verificarUbicacion(ubicacion);
		
	}
	
	protected void notificarNuevaMuestra(Muestra muestra) {
		gestorUbs.notificarNuevaMuestra(muestra);
	}
	
	public void notificarNuevaValidacion(Muestra muestra) {
		gestorUbs.notificarNuevaValidacion(muestra);
	}

}
