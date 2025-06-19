package web_vinchucas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class GestorDeUsuarios {
	
	Web web;
	Long ultimoId;
	List<Usuario> usuarios;
	
	public GestorDeUsuarios(Web web) {
		this.web = web;
		this.ultimoId = 0l;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	//Devuelve la lista de usuarios generados
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	//Devuelve un usuario Nuevo
	public Usuario agregarNuevoUsuario() {
		Usuario usuario = new Usuario(web, ultimoId);
		this.usuarios.add(usuario);
		ultimoId++;
		return usuario;
	}
	
	//Convierte al Usuario en Especialista
	public void convertirEnEspecialista(Usuario usuario) {
		usuario.setNivel(Nivel.ESPECIALISTA);
	}
		
	//Actualiza el nivel de todos los usuarios del sistema (que no sean especialistas)
	public void actualizarTodosLosNiveles() {
		usuarios.stream()
		.forEach(u->this.actualizarNivel(u));
	}
	
	//Actualiza el nivel del usuario segun cumpla con el criterio establecido
	public void actualizarNivel(Usuario usuario) {
		if (usuario.getNivel()!=Nivel.ESPECIALISTA) {
			LocalDate unMesAtras = LocalDate.now().minus(30, ChronoUnit.DAYS);
			Long ultimasRevisiones = this.cantidadAntesDeFecha(usuario.getFechasRevisiones(),unMesAtras);
			Long ultimosEnvios = this.cantidadAntesDeFecha(usuario.getFechasEnvios(),unMesAtras);
		    Nivel nuevoNivel = this.nivelSegunCriterio(ultimasRevisiones, ultimosEnvios);
			if (usuario.getNivel()!=nuevoNivel) { 
				usuario.setNivel(nuevoNivel); 
			}
		}	
	}
	
	//Devuelve un Long que indica la cantidad de elementos en una lista de fechas, posteriores a una fecha dada
	protected Long cantidadAntesDeFecha(List<LocalDate> lista, LocalDate fecha) {
		Long cantidad = lista.stream()
						.filter(i->i.isAfter(fecha))
						.count();
		return cantidad;
	}
	
	
	/* 
	 * Retorna un Nivel segun los valores de revisiones y envios dados por parametro
	 */
	protected Nivel nivelSegunCriterio(Long revisiones, Long envios) {
		Nivel nuevoNivel = Nivel.BASICO;
		if(revisiones>20 && envios>10) {
			nuevoNivel = Nivel.EXPERTO;
		}
		return nuevoNivel;
	}
	
	

}
