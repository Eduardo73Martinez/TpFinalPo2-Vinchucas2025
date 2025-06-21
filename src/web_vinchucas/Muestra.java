package web_vinchucas;

import verificacion.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ZonaOrganizanizacionUbicacion.*;

//import org.mockito.stubbing.OngoingStubbing;


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
		this.agregarOpinion(new Opinion(u.getNivel(),t));
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
	
	//Devuelve un string con el resultado actual de la verificacion de la Muestra
	public String resultadoActual() {
		return this.estado.resultadoActual(this);
	}
	
	//Devuelve la foto de la muestra 
	public Foto getFoto() {
		return this.foto;
	}
	
	//Devuelve la vinchuca que se asigno a la muestra
	public IOpinable getVinchuca() {
		return this.vinchuca;
	}
	
	//Devuelve la ubicacion de la muestra
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
	//Devuelve el usuario que publico la muestra
	public Usuario getPersona() {
		return this.autor;
	} 
	
	//Devuelve la lista de opiniones que se registraron para dicha muestra
	public List<Opinion> getOpiniones(){
		return this.opiniones;
	}
	
	//Devuelve la fecha en que se creo la muestra
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}
	
	//Devuelve la fecha en que se voto por ultima vez 
	public LocalDate getFechaUltimaVotacion() {
		return fechaUltimaVotacion;
	}
	
	//Agrega una opinion sobre la muestra
	public void agregarOpinion(Opinion o) {
		this.opiniones.add(o);
		this.fechaUltimaVotacion = LocalDate.now();
		this.estado.verificar(this);
	}
	
	//Devuelve el estado de Verificacion actual de la muestra
	public Verificacion getVerificacion() {
		return this.estado;
	}
	
	//Setea el estado de verificacion actual de la muestra
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
	
	//Setea el IOpinable de la muestra. Este mensaje lo llama el estado cuando la muestra queda verificada
	public void actualizarVinchuca(IOpinable o) {
		this.vinchuca = o;
	}
	
	//Devuelve una lista con aquellas muestras de la Web dada, que sean cercanas a la distancia dada 
	public List<Muestra> muestrasCercanas(Web w, double f){
		// Se convierte la lista de muestras de la web en un Map con clave Ubicacion y valor Muestra:
		Map<Ubicacion, List<Muestra>> mapUM = this.muestrasPorUbicacion(w);
		
		// Se genera una lista con todas las ubicaciones a partir del Map:
		List<Ubicacion> todasLasUb = this.todasLasUbicaciones(mapUM);
		
		// Se obtienen las ubicaciones cercanas
		List<Ubicacion> ubCercanas = ubicacion.ubicacionesCercanas(todasLasUb,f);
		
		// Se recorre la lista de ubicaciones cercanas y se genera una lista de las muestras
		// obteniendo el valor de muestra asociado a cada clave ubicacion en el primer Map
		return this.obtenerMuestrasCercanas(ubCercanas, mapUM); 
	}
	
	//Devuelve un diccionario con todas las muestras segun su ubicacion 
	protected Map<Ubicacion,List<Muestra>> muestrasPorUbicacion(Web w){
		Map<Ubicacion,List<Muestra>> map = 
				w.todasLasMuestras().stream()
				.collect(Collectors.groupingBy(Muestra::getUbicacion));
		return map;
	}
	
	//Devuelve una lista con todas las ubicaciones del map dado
	protected List<Ubicacion> todasLasUbicaciones(Map<Ubicacion,List<Muestra>> map){
		List<Ubicacion> lista = new ArrayList<>();
		lista.addAll(map.keySet());
		return lista;
	}
	
	//Devuelve una lista de las muestras del map que estan asociadas a las ubicaciones de la lista dada
	protected List<Muestra> obtenerMuestrasCercanas(List<Ubicacion> ubs, Map<Ubicacion,List<Muestra>> map){
		List<Muestra> muestrasCercanas = new ArrayList<Muestra>();
		for(Ubicacion ub:ubs) {
			muestrasCercanas.addAll(map.get(ub));
		}
		return muestrasCercanas;
	}

	//Indica si el usuario dado puede opinar sobre la muestra
	public boolean puedeOpinar(Usuario u) {
		return estado.puedeVotar(u);
	}
	
	
}	