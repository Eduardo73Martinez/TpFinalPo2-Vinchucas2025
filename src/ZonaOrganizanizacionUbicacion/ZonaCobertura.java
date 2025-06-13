package ZonaOrganizanizacionUbicacion;

import java.util.List;
import web_vinchucas.*;

/*
 * 
 * ZONA DE COBERTURA... ESTA CLASE IMPLEMENTA UN ESTRATEGY 
 */
public class ZonaCobertura {
	private String nombre;
	private Ubicacion epicentro;
	private double radio;
	private List<Muestra> muestras;
	private List<Organizacion> organizaciones;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param nombre            NOMBRE DE LA MUESTRA
	 * @param epicentro         UBICACION
	 * @param radioEnKilometros RADIO DE ALCANCE (DOUBLE)
	 * @param muestras          LISTA DE MUESTRAS REGISTRADAS
	 * @param organizaciones    ORGANIZACIONES SUBSCRIPTAS
	 * 
	 */
	public ZonaCobertura(String nombre, Ubicacion epicentro, double radioEnKilometros, List<Muestra> muestras,
			List<Organizacion> organizaciones) {
		// TODO Auto-generated constructor stub

	}

	/**
	 * SUSCRIPCIONES DE LAS ZONA
	 * 
	 * @param organizacion ORGANIZACION QUE QUEREMOS QUE RECIBA NOTIFICACIONES.
	 */
	public void sucribeOrganizacion(Organizacion organizacion) {
		// TODO Auto-generated method stub
		this.organizaciones.add(organizacion);

	}

	/**
	 * DESUSCRIPCION DE LAS ZONA
	 * 
	 * @param organizacion ORGANIZACION QUE QUEREMOS QUE YA NO RECIBA
	 *                     NOTIFICACIONES.
	 */
	public void unsubscribeOrganizacion(Organizacion organizacion) {
		// TODO Auto-generated method stub
		this.organizaciones.remove(organizacion);

	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.nombre = nombre;
	}

	public Ubicacion getEpicentro() {
		// TODO Auto-generated method stub
		return this.epicentro;
	}

	public Double getRadio() {
		// TODO Auto-generated method stub
		return this.radio;
	}

	public void setRadio(double radioN) {
		// TODO Auto-generated method stub
		this.radio = radioN;
	}

	public void cargarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		this.muestras.add(muestra);

	}

	public List<Muestra> getMuestras() {
		// TODO Auto-generated method stub
		return this.muestras;
	}

}
