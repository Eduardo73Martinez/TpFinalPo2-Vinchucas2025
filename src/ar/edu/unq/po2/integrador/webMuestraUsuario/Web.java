package ar.edu.unq.po2.integrador.webMuestraUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.integrador.buscador.SoloVotadas;
import ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion.*;

public class Web {
	private Long proximoId = 0l;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<ZonaCobertura> zonasCobertura = new ArrayList<ZonaCobertura>();
	
	//Devuelve la lista con todas las muestras
	public List<Muestra> todasLasMuestras() {
		return muestras;
	}
	
	//Devuelve la lista con todos los usuarios
	public List<Usuario> todosLosUsuarios(){
		return usuarios;
	}
	
	//Devuelve la lista con todasLasZonas
	public List<ZonaCobertura> todasLasZonas(){
		return zonasCobertura;
	}
	
	//Devuelve el id que tendra el proximo usuario
	public Long getProximoId() {
		return proximoId;
	}

	//Agrega una muestra dada a la lista de muestras y envia la notificacion a las zonas
	public void agregarMuestra(Muestra nuevaMuestra) {
		muestras.add(nuevaMuestra);
		this.notificarNuevaMuestra(nuevaMuestra);
	}
	
	//Notifica la lista de zonas de la creacion de la muestra dada
	protected void notificarNuevaMuestra(Muestra muestra) {
		zonasCobertura.stream().forEach(z->z.notificarNuevaMuestra(muestra));
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
	
	//Agrega la zona dada a la lista de zonas y le envia todas las muestras sin validar
	public void agregarZona(ZonaCobertura zona) {
		zonasCobertura.add(zona);
		this.enviarMuestrasSinValidar(zona);
	}
	
	//Envia a la zona dada las muestras sin validar que existen en la web
	private void enviarMuestrasSinValidar(ZonaCobertura zona) {
		SoloVotadas filtro = new SoloVotadas();
		List <Muestra> muestrasSinValidar = filtro.buscar(muestras);
		muestrasSinValidar.stream().forEach(m->zona.notificarNuevaMuestra(m));
	}
	
	//Quita la zona dada a la lista de zonas (si no existe, no hace nada)
	public void quitarZona(ZonaCobertura zona) {
		if (this.zonasCobertura.contains(zona)) {
			zonasCobertura.remove(zona);
		}
	}
	
	public Web() {
	}

}
