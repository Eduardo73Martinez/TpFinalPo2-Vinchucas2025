package ZonaOrganizanizacionUbicacion;

import java.util.List;
import web_vinchucas.*;

public class ZonaCobertura {
	private String nombre;
	private Ubicacion epicentro;
	private double radio;
	private List<Muestra> muestras; // MUESTRAS QUE ESTAN CUBIERTAS POR ESTA ORGANIZACION
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
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radioEnKilometros;
		this.muestras = muestras;
		this.organizaciones = organizaciones;

	}
	// METODOS QUE PIDE EL TP
	/***
	 * SUSCRIBE UNA ORGANIZACION A ESTA ZONA, LUEGO SERÁ NOTIFICADA DE LOS EVENTOS DE ESTA ZONA.
	 * @param organizacion
	 */
	public void sucribeOrganizacion(Organizacion organizacion) {
		// TODO Auto-generated method stub
		this.organizaciones.add(organizacion);

	}

	public void unsubscribeOrganizacion(Organizacion organizacion) {
		// TODO Auto-generated method stub
		this.organizaciones.remove(organizacion);

	}

	public boolean tieneCoberturaLaMuestra(Muestra muestra) {
		return this.tieneCoberturaLaUbicacion(muestra.getUbicacion());
	}

	public boolean tieneCoberturaLaUbicacion(Ubicacion ubicacion) {
		return this.getEpicentro().distanciaCon(ubicacion) <= this.getRadio();
	}
	/***
	 * NOTIFICA A LAS ORGANIZACIONES QUE UNA MUESTRA SE VERIFICÓ. 
	 * ANTES VALIDA SI TIENE COBERTURA.
	 * @param muestra
	 */
	public void validacion(Muestra muestra) {
		if (this.tieneCoberturaLaMuestra(muestra)) {
			this.organizaciones.stream().forEach(organizacion -> organizacion.notifyMeValidation(this, muestra));
		}
	}
	
	/**
	 * AGREGA UNA MUESTRA A LA LISTA DE MUESTRAS QUE ESTAN CUBIERTAS.
	 * ANTES VALIDA SI TIENE COBERTURA, LUEGO NOTIFICA A LAS ORGANIZACIONES CORRESPONDIENTES.
	 * @param muestra
	 */
	public void cargarMuestraEnZona(Muestra muestra) {
		if (this.tieneCoberturaLaMuestra(muestra)) {
			this.cargarMuestra(muestra);
			this.organizaciones.stream().forEach(organizacion -> organizacion.notifyMeCarga(this, muestra));
		}
	}
	
	/***
	 * MUESTRA TODAS LAS ZONAS QUE SE SOLAPAN. (LLAMÉ AL METODO INTERSECCIONES)
	 * @param zonaDeCoberturas
	 * @return
	 */
	public List<ZonaCobertura> intersecciones(List<ZonaCobertura> zonaDeCoberturas) {
		return zonaDeCoberturas.stream().filter(zona -> zona.interseccionConZona(this)).toList();
	}

	public boolean interseccionConZona(ZonaCobertura zona) {
		return this.epicentro.distanciaCon(zona.getEpicentro()) <= this.getRadio();
	}
	
	/***
	 * LISTA TODAS LAS MUESTRAS QUE ESTA ZONA CUBRE.
	 * @return
	 */
	public List<Muestra> getMuestras() {
		// TODO Auto-generated method stub
		return this.muestras;
	}
	

	// getters y setters usados.
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

	public Ubicacion setEpicentro(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		return this.epicentro = ubicacion;
	}

	public Double getRadio() {
		// TODO Auto-generated method stub
		return this.radio;
	}

	public void setRadio(double radioN) {
		// TODO Auto-generated method stub
		this.radio = radioN;
	}
	
	/**
	 * METODO INTERNO. SE USA PARA CARGAR PERO ANTES CON EL OTRO METODO
	 * NOS ASEGURAMOS QUE TENGA COBERTURA.
	 * 
	 * @param muestra
	 */
	public void cargarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		this.muestras.add(muestra);

	}

	public List<Organizacion> getOrganizaciones() {
		return this.organizaciones;
	}

}
