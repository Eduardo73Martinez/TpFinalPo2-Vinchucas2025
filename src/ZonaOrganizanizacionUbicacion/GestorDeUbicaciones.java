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
	public Ubicacion obtenerUbicacion(Double lat, Double lon) {
		// TODO Auto-generated method stub
		Ubicacion ubicacionNueva = new Ubicacion(lat, lon);
		this.agregarUbicacion(ubicacionNueva);
		return ubicacionNueva;
	}

	public void agregarUbicacion(Ubicacion ubicacion) {
		if (!this.getZonasPorUbicacion().containsKey(ubicacion)) {
			this.zonasPorUbicacion.put(ubicacion, new ArrayList<ZonaCobertura>());
		}
	}

	/**
	 * BUSCA Y NOTIFICA A LAS ZONAS QUE CORRESPONDAN QUE APARCIÓ UNA MUESTRA NUEVA.
	 * 
	 * @param muestra MUESTRA QUE SE CARGÓ AL SISTEMA.
	 * 
	 */
	public void notificarNuevaMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		Ubicacion ubicacionABuscar = this.obtenerUbicacion(muestra.getUbicacion().getLatidud(),muestra.getUbicacion().getLatidud());
		this.zonasPorUbicacion.get(ubicacionABuscar).stream().forEach(zona -> zona.cargarMuestraEnZona(muestra));

	}

	/***
	 * BUSCA Y NOTIFICA A LAS ZONAS QUE CORRESPONDAN QUE SE VALIDÓ UNA MUESTRA.
	 * 
	 * @param muestra MUESTRA QUE SE VALIDÓ
	 */
	public void notificarNuevaValidacion(Muestra muestra) {
		// TODO Auto-generated method stub

		Ubicacion ubicacionABuscar = this.obtenerUbicacion(muestra.getUbicacion().getLatidud(),muestra.getUbicacion().getLatidud());
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
