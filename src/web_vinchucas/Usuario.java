package web_vinchucas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import ZonaOrganizanizacionUbicacion.Ubicacion;

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
	
	public Double getId() {
		return id;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}
	public void convertirEnEspecialista() {
		this.cambiarNivel(Nivel.ESPECIALISTA);
	}
	
	protected void cambiarNivel(Nivel nuevoNivel) {
		this.nivel = nuevoNivel;
	}

	public void opinar(Muestra m, IOpinable vo) {
		if (m.puedeOpinar(this)) {
			Opinion miOpinion = new Opinion(this.nivel, vo);
			m.agregarOpinion(miOpinion);
			this.opiniones.add(miOpinion);
		}
	}
	
	public void enviarMuestra(TipoVinchuca t, Double latitud, Double longitud) {
		Muestra nuevaMuestra = this.crearMuestra(t, latitud, longitud);
		this.muestras.add(nuevaMuestra);
		web.agregarMuestra(nuevaMuestra);
	}
	
	protected Muestra crearMuestra(TipoVinchuca t,Double latitud, Double longitud) {
		Foto foto = new Foto();
		Ubicacion ubicacion = new Ubicacion(latitud,longitud);
		Muestra nuevaMuestra = new Muestra(this,t,foto,ubicacion);
		return nuevaMuestra;
	}
	
	public List<LocalDate> getFechasRevisiones(){
		List<LocalDate> revisiones = this.opiniones.stream().map(o -> o.getFecha()).toList();
		
		return revisiones;
	}
	
	public List<LocalDate> getFechasEnvios(){
		List<LocalDate> envios = this.muestras.stream().map(m -> m.getFechaCreacion()).toList();
		
		return envios;
	}
	
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
	
	protected Long cantidadAntesDeFecha(List<LocalDate> lista, LocalDate fecha) {
		Long cantidad = lista.stream()
						.filter(i->i.isAfter(fecha))
						.count();
		return cantidad;
	}
	
	protected Nivel nivelSegunCriterio(Long revisiones, Long envios) {
		Nivel nuevoNivel = Nivel.BASICO;
		if(revisiones>20 && envios>10) {
			nuevoNivel = Nivel.EXPERTO;
		}
		return nuevoNivel;
	}
	
}
