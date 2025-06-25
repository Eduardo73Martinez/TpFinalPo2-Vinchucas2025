package web_vinchucas;

import ZonaOrganizanizacionUbicacion.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Web {
	Long proximoId = 0l;
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	GestorDeUbicaciones gestorUbs;
	
	//Devuelve el gestor de ubicaciones
	public GestorDeUbicaciones getGestorUbicaciones() {
		return gestorUbs;
	}
	
	//Devuelve la lista con todas las muestras
	public List<Muestra> todasLasMuestras() {
		return muestras;
	}
	
	//Devuelve la lista con todos los usuarios
	public List<Usuario> todosLosUsuarios(){
		return usuarios;
	}
	
	//Devuelve el id que tendra el proximo usuario
	public Long getProximoId() {
		return proximoId;
	}

	//Agrega una muestra dada a la lista de muestras y notifica al gestor de ubicaciones
	public void agregarMuestra(Muestra nuevaMuestra) {
		muestras.add(nuevaMuestra);
		this.notificarNuevaMuestra(nuevaMuestra);
	}
	
	//Quita la muestra dada de la lista de muestras (si no existe en la lista, no hace nada)
	public void quitarMuestra(Muestra muestra) {
		if (this.muestras.contains(muestra)) {
			muestras.remove(muestra);
		}
	}
	
	//Agrega el usuario dado a la lista de usuarios y actualiza el proximoId
	public void agregarUsuario() {
		Usuario usuarioNuevo = new Usuario(this, proximoId);
		usuarios.add(usuarioNuevo);
		this.proximoId++;
	}
	
	//Quita el usuario dado de la lista de usuarios (si no existe, no hace nada)
	public void quitarUsuario(Usuario usuario) {
		if (this.usuarios.contains(usuario)) {
			usuarios.remove(usuario);
		}
	}
	
	//Actualiza el nivel de todos los usuarios de una lista dada
	public void actualizarNivel(List<Usuario> usuarios) {
		usuarios.stream().forEach(u->u.actualizarNivel());
	}
	
	//Setea el nivel Especialista en todos los usuarios de una lista dada
	public void convertirEnEspecialistas(List<Usuario> usuarios) {
		usuarios.stream().forEach(u->u.convertirEnEspecialista());
	}
	
	//Envia la ubicacion dada al gestor de ubicaciones y retorna una ubicacion verificada
	public Ubicacion registrarEnElGestor(Ubicacion ubicacion) {
		return gestorUbs.obtenerUbicacion(ubicacion);
	}
	
	//Notifica al gestor de ubicaciones de la creacion de la muestra dada
	protected void notificarNuevaMuestra(Muestra muestra) {
		gestorUbs.notificarNuevaMuestra(muestra);
	}
	
	//Notifica al gestor de ubicaciones de la validacion de la muestra dada
	public void notificarNuevaValidacion(Muestra muestra) {
		gestorUbs.notificarNuevaValidacion(muestra);
	}
	
	public Web(GestorDeUbicaciones gestorUbs) {
		this.gestorUbs = gestorUbs;
	}

}
