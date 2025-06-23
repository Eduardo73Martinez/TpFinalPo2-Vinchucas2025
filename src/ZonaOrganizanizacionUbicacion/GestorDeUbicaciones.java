package ZonaOrganizanizacionUbicacion;

import java.util.*;
import web_vinchucas.*;

public class GestorDeUbicaciones {
	private Map<Ubicacion, List<ZonaCobertura>> zonasPorUbicacion;
	private List<ZonaCobertura> todasLasZonas;

	/**
	 * 
	 * @param lat LATITUD DE LA UBICACION
	 * @param lon LONGITUD DE LA UBICACION
	 * @return UNA UBICACION, SI NO EXISTE LA CREAMOS Y AGREGAMOS AL GESTOR COMO
	 *         CLAVE DE LAS ZONAS.
	 */
	public Ubicacion obtenerUbicacion(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		this.validarUbicacion(ubicacion);
		return ubicacion; 
	}

	public void validarUbicacion(Ubicacion ubicacion) {
		if (!this.getZonasPorUbicacion().containsKey(ubicacion)) {
			this.zonasPorUbicacion.put(ubicacion, new ArrayList<ZonaCobertura>());
		} 
	}
	/**
	 * ASOCIA UNA ZONA CON UNA UBICACION. 
	 * @param zona
	 * @param ubicacion
	 */
	public void asociarZona(ZonaCobertura zona, Ubicacion ubicacion) {
		Ubicacion ubicacionR = this.obtenerUbicacion(ubicacion);
		//this.validarZonaEnUbicacion(); VALIDA  QUE LA UBICACION ESTA CUBIERTA POR ESA ZONA.
		List<ZonaCobertura> zonasDeU = this.getZonasPorUbicacion().get(ubicacionR); // BUSCO LA LISTA EN EL MAP.
		zonasDeU.add(zona); // ACTUALIZO LA LISTA 
		this.getZonasPorUbicacion().put(ubicacionR, zonasDeU);// LA ASOCIO NUEVAMENTE EN EL MAP.
		this.getTodasLasZonas().add(zona); // LA AGREGO A LA LISTA GENERAL.
	} 

	/**
	 * BUSCA Y NOTIFICA A LAS ZONAS QUE CORRESPONDAN QUE APARCIÓ UNA MUESTRA NUEVA.
	 * 
	 * @param muestra MUESTRA QUE SE CARGÓ AL SISTEMA.
	 * 
	 */
	public void notificarNuevaMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		Ubicacion ubicacionABuscar = this.obtenerUbicacion(muestra.getUbicacion());
		this.zonasPorUbicacion.get(ubicacionABuscar).stream().forEach(zona -> zona.cargarMuestraEnZona(muestra));

	}

	/***
	 * BUSCA Y NOTIFICA A LAS ZONAS QUE CORRESPONDAN QUE SE VALIDÓ UNA MUESTRA.
	 * 
	 * @param muestra MUESTRA QUE SE VALIDÓ
	 */
	public void notificarNuevaValidacion(Muestra muestra) {
		// TODO Auto-generated method stub

		Ubicacion ubicacionABuscar = this.obtenerUbicacion(muestra.getUbicacion());
		this.zonasPorUbicacion.get(ubicacionABuscar).stream().forEach(zona -> zona.validacion(muestra));
	}

	/**
	 * SU RESPONSABILIDAD ES GESTIONAR UBICACIONES Y ZONAS Y AVISAR SI HAY ALGUN EVENTO EN 
	 * ALGUNA UBICACION.
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
