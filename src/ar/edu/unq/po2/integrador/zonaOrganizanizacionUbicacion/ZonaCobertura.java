package ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion;

import java.util.List;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

/*
 * HAY UN OBESERVER EN ESTA CLASE, AL AVISAR A LAS ORGANIZACIONES. CUANDO OCURRE UN EVENTO 
 * LES AVISA A TODAS LAS SUBSCRIPTAS.
 */
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

	public void validacion(Muestra muestra) {
		if (this.tieneCoberturaLaMuestra(muestra)) {
			this.organizaciones.stream().forEach(organizacion -> organizacion.notifyMeValidation(this, muestra));
		}
	}

	public void cargarMuestraEnZona(Muestra muestra) {
		if (this.tieneCoberturaLaMuestra(muestra)) {
			this.organizaciones.stream().forEach(organizacion -> organizacion.notifyMeCarga(this, muestra));
			this.cargarMuestra(muestra);
		}
	}
	/***
	 * QUITAMOS LA MUESTRA NUEVO METODO. 
	 * @param muestra
	 */
	public void quitarMuestraEnZona(Muestra muestra) {
		if (this.getMuestras().contains(muestra)) {
			this.getMuestras().remove(muestra);
		}
	}

	public List<ZonaCobertura> intersecciones(List<ZonaCobertura> zonaDeCoberturas) {
		return zonaDeCoberturas.stream().filter(zona -> zona.interseccionConZona(this)).toList();
	}

	public boolean interseccionConZona(ZonaCobertura zona) {
		return this.epicentro.distanciaCon(zona.getEpicentro()) <= this.getRadio();
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
	 * CARGA LA MUESTRA . LO HACEMOS PRIVADO PARA NO CONFUNDIR CON EL CORGARMUESTRA EN ZONA.
	 * QUE VERIFICA LAS COBERTURAS ANTES DE AGREGAR.
	 * @param muestra
	 */
	public void cargarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		this.muestras.add(muestra);

	}

	public List<Muestra> getMuestras() {
		// TODO Auto-generated method stub
		return this.muestras;
	}

	public List<Organizacion> getOrganizaciones() {
		return this.organizaciones;
	}

}
