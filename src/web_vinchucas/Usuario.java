package web_vinchucas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import ZonaOrganizanizacionUbicacion.*;

public class Usuario {
	 
	Web web;
	Double id;
	Nivel nivel;
	List<Opinion> opiniones = new ArrayList<Opinion>();
	List<Muestra> muestras = new ArrayList<Muestra>();
	
	public Usuario(Web web, Double id) {
		this.web = web;
		this.id = id;
		this.nivel = Nivel.BASICO;
	}
	
	//Devuelve el Id del usuario
	public Double getId() {
		return id;
	}
	
	//Devuelve el nivel del Usuario
	public Nivel getNivel() {
		return nivel;
	}
	
	//Devuelve una lista con las opiniones que registro el usuario
	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	//Devuelve una lista con las muestras que genero el usuario
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	//Convierte al Usuario en Especialista
	public void convertirEnEspecialista() {
		this.cambiarNivel(Nivel.ESPECIALISTA);
	}
	
	//Cambia el nivel del Usuario
	protected void cambiarNivel(Nivel nuevoNivel) {
		this.nivel = nuevoNivel;
	}

	//Si el usuario puede opinar en la muestra dada, Registra una nueva opinion el IOpinable dado
	//Si el usuario no puede votar, no hace nada.
	public void opinar(Muestra m, IOpinable vo) {
		if (m.puedeOpinar(this)) {
			Opinion miOpinion = new Opinion(this.nivel, vo);
			m.agregarOpinion(miOpinion);
			this.opiniones.add(miOpinion);
		}
	}
	
	//Envia a la web una Muestra con el TipoVinchuca y coordenadas dados por parametro
	public void enviarMuestra(TipoVinchuca t, Double latitud, Double longitud) {
		Muestra nuevaMuestra = this.crearMuestra(t, latitud, longitud);
		this.muestras.add(nuevaMuestra);
		web.agregarMuestra(nuevaMuestra);
	}
	
	//Crea una nueva Muestra con el TipoVinchuca y coordenadas dados por parametro
	protected Muestra crearMuestra(TipoVinchuca t,Double latitud, Double longitud) {
		Foto foto = new Foto();
		Ubicacion ubicacion = new Ubicacion(latitud,longitud);
		Muestra nuevaMuestra = new Muestra(this,t,foto,ubicacion);
		return nuevaMuestra;
	}
	
	//Retorna una lista de LocalDate con las fechas de todas las opiniones que emitio el usuario
	public List<LocalDate> getFechasRevisiones(){
		List<LocalDate> revisiones = this.opiniones.stream().map(o -> o.getFecha()).toList();
		
		return revisiones;
	}

	//Retorna una lista de LocalDate con las fechas de envio de todas las muestras que genero el usuario
	public List<LocalDate> getFechasEnvios(){
		List<LocalDate> envios = this.muestras.stream().map(m -> m.getFechaCreacion()).toList();
		
		return envios;
	}
	
	//Actualiza el nivel del usuario segun cumpla con el criterio establecido
	public void actualizarNivel() {
		if (this.nivel!=Nivel.ESPECIALISTA) {
			LocalDate unMesAtras = LocalDate.now().minus(30, ChronoUnit.DAYS);
			Long ultimasRevisiones = cantidadAntesDeFecha(this.getFechasRevisiones(),unMesAtras);
			Long ultimosEnvios = cantidadAntesDeFecha(this.getFechasEnvios(),unMesAtras);
		    Nivel nuevoNivel = this.nivelSegunCriterio(ultimasRevisiones, ultimosEnvios);
			if (this.nivel!=nuevoNivel) { 
				this.cambiarNivel(nuevoNivel); 
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
