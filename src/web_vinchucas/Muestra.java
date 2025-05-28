package web_vinchucas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Muestra {
	Usuario autor;
	Foto foto;
	Ubicación ubicacion;
	Verificacion estado; 
	
	List<Opinion> opiniones = new ArrayList<Opinion>();
	
	public Muestra(Usuario u, Foto f, Ubicación ub) {
		this.autor = u;
		this.foto = f;
		this.estado = new OpinionBasicos();
		this.ubicacion = ub;
		
		
	}
	public Foto getFoto() {
		return this.foto;
	}
	public Ubicación getUbicacion() {
		return this.ubicacion;
	}
	public Usuario getPersona() {
		return this.autor;
	} 
	public List<Muestra> muestrasCercanas(Web w, float f){
		// Se convierte la lista de muestras de la web en un Map con clave Ubicacion y valor Muestra:
		Map<Ubicación, Muestra> mapUM = this.muestrasPorUbicacion(w);
		
		// Se genera una lista con todas las ubicaciones a partir del Map:
		List<Ubicación> todasLasUb = this.todasLasUbicaciones(mapUM);
		
		// Se obtienen las ubicaciones cercanas
		List<Ubicación> ubCercanas = ubicacion.ubicacionesCercanas(todasLasUb,f);
		
		// Se recorre la lista de ubicaciones cercanas y se genera una lista de las muestras
		// obteniendo el valor de muestra asociado a cada clave ubicacion en el primer Map
		List<Muestra> muestrasCercanas = new ArrayList<Muestra>();
		for(Ubicación ub:ubCercanas) {
			muestrasCercanas.add(mapUM.get(ub));
		}
		
		return muestrasCercanas; 
	}
	
	protected Map<Ubicación,Muestra> muestrasPorUbicacion(Web w){
		Map<Ubicación,Muestra> map = 
				w.todasLasMuestras().stream().collect(
						Collectors.toMap(
								m -> m.getUbicacion(), 
								m -> m)
						);
		return map;
	}
	
	protected List<Ubicación> todasLasUbicaciones(Map<Ubicación,Muestra> map){
		List<Ubicación> lista = new ArrayList<>();
		lista.addAll(map.keySet());
		return lista;
	}
	
}	