package web_vinchucas;

import verificacion.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Muestra {
	Usuario autor;
	TipoVinchuca vinchuca;
	Foto foto;
	Ubicacion ubicacion;
	LocalDate fechaCreacion;
	Verificacion estado; 
	
	List<Opinion> opiniones = new ArrayList<Opinion>();
	
	public Muestra(Usuario u, TipoVinchuca t, Foto f, Ubicacion ub) {
		this.autor = u;
		this.vinchuca = t;
		this.foto = f;
		this.estado = new OpinionBasicos(this);
		this.ubicacion = ub;
		this.fechaCreacion = LocalDate.now();
	}
	public String resultadoActual() {
		return this.estado.resultadoActual();
	}
	public Foto getFoto() {
		return this.foto;
	}
	public TipoVinchuca getVinchuca() {
		return this.vinchuca;
	}
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	public Usuario getPersona() {
		return this.autor;
	} 
	public List<Opinion> getOpiniones(){
		return this.opiniones;
	}
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}
	public void agregarOpinion(Opinion o) {
		this.opiniones.add(o);
	}
	public void setVerificacion(Verificacion v) {
		this.estado = v;
	}
	public List<Muestra> muestrasCercanas(Web w, float f){
		// Se convierte la lista de muestras de la web en un Map con clave Ubicacion y valor Muestra:
		Map<Ubicacion, Muestra> mapUM = this.muestrasPorUbicacion(w);
		
		// Se genera una lista con todas las ubicaciones a partir del Map:
		List<Ubicacion> todasLasUb = this.todasLasUbicaciones(mapUM);
		
		// Se obtienen las ubicaciones cercanas
		List<Ubicacion> ubCercanas = ubicacion.ubicacionesCercanas(todasLasUb,f);
		
		// Se recorre la lista de ubicaciones cercanas y se genera una lista de las muestras
		// obteniendo el valor de muestra asociado a cada clave ubicacion en el primer Map
		return this.obtenerMuestrasCercanas(ubCercanas, mapUM); 
	}
	
	protected Map<Ubicacion,Muestra> muestrasPorUbicacion(Web w){
		Map<Ubicacion,Muestra> map = 
				w.todasLasMuestras().stream().collect(
						Collectors.toMap(
								m -> m.getUbicacion(), 
								m -> m)
						);
		return map;
	}
	
	protected List<Ubicacion> todasLasUbicaciones(Map<Ubicacion,Muestra> map){
		List<Ubicacion> lista = new ArrayList<>();
		lista.addAll(map.keySet());
		return lista;
	}
	
	protected List<Muestra> obtenerMuestrasCercanas(List<Ubicacion> ubs, Map<Ubicacion,Muestra> map){
		List<Muestra> muestrasCercanas = new ArrayList<Muestra>();
		for(Ubicacion ub:ubs) {
			muestrasCercanas.add(map.get(ub));
		}
		return muestrasCercanas;
	}
	public boolean puedeOpinar(Nivel estado2) {
		return estado.puedeVotar(autor);
	}
	
	 
}	