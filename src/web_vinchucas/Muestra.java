package web_vinchucas;

import verificacion.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import org.mockito.stubbing.OngoingStubbing;

import ZonaOrganizanizacionUbicacion.Ubicacion;

public class Muestra {
	Usuario autor;
	IOpinable vinchuca;
	Foto foto;
	Ubicacion ubicacion;
	LocalDate fechaCreacion;
	LocalDate fechaUltimaVotacion;
	Verificacion estado; 
	
	
	List<Opinion> opiniones = new ArrayList<Opinion>(); 
	
	public Muestra(Usuario u, TipoVinchuca t, Foto f, Ubicacion ub) {
		this.autor = u;
		this.vinchuca = t;
		this.foto = f;
		this.estado = new OpinionBasicos();
		this.ubicacion = ub;
		this.fechaCreacion = LocalDate.now(); 
		this.fechaUltimaVotacion = null;
	}
	/**
	 *  
	 * 	COMENTO ACÁ LUCIO, SOY MARTIN,....ME PARECE QUE  ESTA PARTE NO ESTA DEL TODO BIEN. LA PARTE DEL ESTADO 
	 *  DEBERIA LLAMAR EN EL ESTADO A VERIFICAR. ME ACUERDO QUE LO CAMBIAMOS Y DEVOLVIA UN STRING PORQUE APLICABA UN IOPINABLE, PERO NO SE SI ELLOS LO VAN A ACEPTAR
	 *  (PARA MI NO ESTÁ MAL) PERO DEBERIAMOS PREGUNTARLE SI PODEMOS HACERLO PORQUE NOS PUEDEN MARCAR COMO ERROR ESTO. 
	 *  
	 *  
	 *  TENEMOS QUE ORDENAR EL ESTADO. ME PARECE QUE VOY A TENER QUE AYUDAR A QUIMEY EN ESA PARTE QUE ES MAS IMPORTANTE
	 *  PARA EL GRUPO. SU CODIGO NO FUNCIONA.
	 *  
	 *  EJEMPLO 
	 *  THIS.ESTADO.VERIFICAR(THIS) O THIS.GETESTADO().VERIFICAR(THIS)
	 *  
	 * 
	 * @return
	 */
	
	//YO NECESITO VERIFICAR() EN LA CLASE ZONASCOBERTURA CAMBIO POR RESULTADOACTUAL(). DESPUES BORRA ESTE COMENTARIO.
	public String resultadoActual() {
		return this.estado.resultadoActual(this);
	}
	public Foto getFoto() {
		return this.foto;
	}
	public IOpinable getVinchuca() {
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
	public LocalDate getFechaUltimaVotacion() {
		return fechaUltimaVotacion;
	}
	public void agregarOpinion(Opinion o) {
		this.opiniones.add(o);
		this.fechaUltimaVotacion = LocalDate.now();
	}
	public Verificacion getVerificacion() {
		return this.estado;
	}
	public void setVerificacion(Verificacion v) {
		this.estado = v;
	}
	/*
	 * COMENTO ACÁ TAMBIEN... ¿EL RESULTADO ACTUAL NO TE COMBIENE PEDIRSELO AL ESTADO?
	 * ME PARECE UN POCO INNECESARIO TENER SETEADOS DOS ESTADOS.
	 * 
	 * YA SE ENTENDI... VOS TENES SETTEADO POR DEFAULT NULL EN THIS.VINCHUCA Y CUANDO LA VERIFICAS LE ASIGNAS UNA, PERO
	 * ESTÁ POR FUERA DEL PROPIO ESTADO.
	 */
	public void actualizarVinchuca(IOpinable o) {
		this.vinchuca = o;
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
  
	public boolean puedeOpinar(Usuario u) {
		return estado.puedeVotar(u, this);
	}
	
	
}	