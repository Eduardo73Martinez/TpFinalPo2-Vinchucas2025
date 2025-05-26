package web_vinchucas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Muestra {
	Usuario autor;
	Foto foto;
	Ubicacion ubicacion;
	Verificacion estado; 
	
	List<Opinion> opiniones = new ArrayList<Opinion>();
	
	public Muestra(Usuario u, Foto f, Ubicacion ub) {
		this.autor = u;
		this.foto = f;
		this.estado = new OpinionBasicos();
		this.ubicacion = ub;
	}
	public Foto getFoto() {
		return this.foto;
	}
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	public Usuario getPersona() {
		return this.autor;
	}
	public List<Muestra> muestrasCercanas(Web w, float f){
		// Se convierte la lista de muestras de la web en un Map con clave Ubicacion y valor Muestra:
		Map<Ubicacion, Muestra> mapDeUbicacionMuestra = w.todasLasMuestras().stream().collect(
				Collectors.toMap(m -> m.getUbicacion(),m -> m)
				);
		
		// Se genera una lista con todas las ubicaciones a partir del Map:
		List<Ubicacion> todasLasUbicaciones = new ArrayList<>(); 
		todasLasUbicaciones.addAll(mapDeUbicacionMuestra.keySet());
		
		// Se obtienen las ubicaciones cercanas
		List<Ubicacion> ubicacionesCercanas = ubicacion.ubicacionesCercanas(todasLasUbicaciones,f);
		
		// Se recorre la lista de ubicaciones cercanas y se genera una lista de las muestras
		// obteniendo el valor de muestra asociado a cada clave ubicacion en el primer Map
		List<Muestra> muestrasCercanas = new ArrayList<Muestra>();
		for(Ubicacion ub:ubicacionesCercanas) {
			muestrasCercanas.add(mapDeUbicacionMuestra.get(ub));
		}
		
		return muestrasCercanas; 
	}
}	