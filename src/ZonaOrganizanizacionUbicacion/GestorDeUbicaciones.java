package ZonaOrganizanizacionUbicacion;

import java.io.IOError;
import java.util.*;
import web_vinchucas.*;

public class GestorDeUbicaciones {
	private Map<Ubicacion, List<ZonaCobertura>> zonasPorUbicacion;
	private List<ZonaCobertura> todasLasZonas;
	
	/**
	 * SU RESPONSABILIDAD ES GESTIONAR UBICACIONES Y ZONAS Y AVISAR SI HAY ALGUN
	 * EVENTO EN ALGUNA UBICACION.
	 * 
	 * @param zonasPorUbicacion
	 * @param todasLasZonas
	 */
	public GestorDeUbicaciones(Map<Ubicacion, List<ZonaCobertura>> zonasPorUbicacion,
			List<ZonaCobertura> todasLasZonas) {
		super();
		this.zonasPorUbicacion = zonasPorUbicacion;
		this.todasLasZonas = todasLasZonas;
	}
	
	/**
	 * BUSCA Y NOTIFICA A LAS ZONAS QUE CORRESPONDAN QUE APARECIÓ UNA MUESTRA NUEVA.
	 * 
	 * @param muestra MUESTRA QUE SE CARGÓ AL SISTEMA.
	 * 
	 */
	public void notificarNuevaMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		this.obtenerUbicacion(muestra.getUbicacion());
		this.zonasPorUbicacion.get(muestra.getUbicacion()).stream().forEach(zona -> zona.cargarMuestraEnZona(muestra));

	}

	/***
	 * BUSCA Y NOTIFICA A LAS ZONAS QUE CORRESPONDAN QUE SE VALIDÓ UNA MUESTRA.
	 * 
	 * @param muestra MUESTRA QUE SE VALIDÓ
	 */
	public void notificarNuevaValidacion(Muestra muestra) {
		// TODO Auto-generated method stub

		this.obtenerUbicacion(muestra.getUbicacion());
		this.zonasPorUbicacion.get(muestra.getUbicacion()).stream().forEach(zona -> zona.validacion(muestra));
	}

	/**
	 * REGISTRA UNA ZONA QUE CUBRE UNA UBICACION; CHEQUEA ANTES DE ASOCIAR SI LA
	 * ZONA LA CUBRE (FUNCION EXCLUSIVA DEL MAP).
	 *  
	 * @param zona
	 * @param ubicacion
	 * @throws SinCoberturaException
	 */
	public void asociarUbicacionConZona(Ubicacion ubicacion, ZonaCobertura zona) throws SinCoberturaException {
		this.validarZonaEnUbicacion(ubicacion, zona); // VALIDA QUE LA UBICACION ESTA CUBIERTA POR ESA ZONA.
		this.actualizarUbicacionConListaDeZonas(ubicacion);
	}

	/**
	 * VALIDA QUE LA UBICACION ESTÁ DENTRO DE LA COVERTURA.
	 * 
	 * @param ubicacion
	 * @param zona
	 * @throws SinCoberturaException
	 */
	public void validarZonaEnUbicacion(Ubicacion ubicacion, ZonaCobertura zona) throws SinCoberturaException {
		// TODO Auto-generated method stub
		if (ubicacion.distanciaCon(zona.getEpicentro()) > zona.getRadio()) {
			throw new SinCoberturaException("La Ubicacion no está dentro de la cobertura");
		}

	}

	/***
	 * ACTIALIZA LA UBICACION CON LA LISTA DE ZONAS QUE LA CUBREN.
	 * 
	 * @param ubicacion
	 */
	private void actualizarUbicacionConListaDeZonas(Ubicacion ubicacion) {
		List<ZonaCobertura> listaZonas = this.zonasQueCubrenLaUbicacion(ubicacion);// BUSCA TODAS LAS ZONAS QUE LA CUBREN 
		this.getZonasPorUbicacion().put(ubicacion, listaZonas);// ACTUALIZA EL MAP

	}

	/**
	 * BUSCA LAS ZONAS QUE CUBREN LA UBICACION DADA EN LA LISTA DE ZONAS. (EN
	 * NUESTRO MODELO TODAS LAS ZONAS DEBEN ESTAR REGISTRADAS EN ESA COLLECCION).
	 * 
	 * @param ubicacion
	 * @return LA LISTA DE ZONAS QUE LA CUBREN ESA UBICACIÓN.
	 */
	public List<ZonaCobertura> zonasQueCubrenLaUbicacion(Ubicacion ubicacion) {
		return this.getTodasLasZonas().stream().filter(zona -> zona.tieneCoberturaLaUbicacion(ubicacion)).toList();
	}

	

	/**
	 * SU FUNCION ES AGREGAR A LA LISTA GENERAL DE ZONA Y ACTUALIZAR EL MAP.
	 */
	public void registrarZona(ZonaCobertura zona) {
		this.getTodasLasZonas().add(zona); // AGREGA LA ZONA A LA LISTA GENERAL 
		this.asociarUbicacionConZona(zona.getEpicentro(), zona); // ACTUALIZA EL MAP CON ESA ZONA.
	}

	public void sacarZona(ZonaCobertura zona) {
		this.getTodasLasZonas().remove(zona);
		// ACTUALIZA EL MAP POR LA LISTA DE UBICACIONES.
		this.getZonasPorUbicacion().keySet().stream().forEach(ubicacion -> this.actualizarUbicacionConListaDeZonas(ubicacion));
	}
	
	/**
	 *  REGISTRA UNA UBICACION SI NO SE ENCUENTRA EN EL GESTOR.
	 * 
	 * @param lat LATITUD DE LA UBICACION
	 * @param lon LONGITUD DE LA UBICACION
	 * @return UNA UBICACION, SI NO EXISTE LA CREAMOS Y AGREGAMOS AL GESTOR COMO
	 *         CLAVE DE LAS ZONAS.
	 */
	public void obtenerUbicacion(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		this.registrarUbicacion(ubicacion);
	}

	/**
	 * AGREGA UNA UBICACION AL MAP SI NO EXISTE, CON LAS ZONAS QUE LA CUBREN.	 * 
	 * @param ubicacion
	 */
	public void registrarUbicacion(Ubicacion ubicacion) {
		if (!this.getZonasPorUbicacion().containsKey(ubicacion)) {
			this.actualizarUbicacionConListaDeZonas(ubicacion);
		}
	}
 

	// GETTERS Y SETTERS
	public Map<Ubicacion, List<ZonaCobertura>> getZonasPorUbicacion() {
		return zonasPorUbicacion;
	}

	public void setZonasPorUbicacion(Map<Ubicacion, List<ZonaCobertura>> zonasPorUbicacion) {
		this.zonasPorUbicacion = zonasPorUbicacion;
	}

	public List<ZonaCobertura> getTodasLasZonas() {
		return todasLasZonas;
	}

	public void setTodasLasZonas(List<ZonaCobertura> todasLasZonas) {
		this.todasLasZonas = todasLasZonas;
	}

}
