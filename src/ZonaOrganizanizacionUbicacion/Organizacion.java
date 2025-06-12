package ZonaOrganizanizacionUbicacion;

import java.util.*;
import web_vinchucas.*;

public class Organizacion {
	private String tipoOrganizacion;
	private int cantidadDeEmpleados;
	private FuncionalidadExterna funcionalidadCargaMuestra;
	private FuncionalidadExterna funcionalidadValidacionMuestra;
	private Ubicacion ubicacion;
	/**
	 * NO LO PIDE EL ENUCIADO PERO YO REGISTRO IGUALMENTE DONDE ESPERO RECIBIR
	 * INFORMACION. SOLAMENTE COMO INFORMACION, NO HACE NADA.
	 */
	private List<ZonaCobertura> zonasSubscriptas;

	public List<ZonaCobertura> getZonasSubscriptas() {
		return zonasSubscriptas;
	}

	public FuncionalidadExterna getFuncionalidadExternaCarga() {
		return this.funcionalidadCargaMuestra;
	}

	public FuncionalidadExterna getFuncionalidadExternaValidacion() {
		return this.funcionalidadValidacionMuestra;
	}

	public void subscribe(ZonaCobertura zona) {
		zona.sucribeOrganizacion(this);
		this.zonasSubscriptas.add(zona);
	}

	public void unsubscribe(ZonaCobertura zona) {
		zona.unsubscribeOrganizacion(this);
		if (this.zonasSubscriptas.contains(zona))
			this.zonasSubscriptas.remove(zona);
	}

	public String getTipoOrganizacion() {
		return tipoOrganizacion;
	}

	public int getCantidadDeEmpleados() {
		return cantidadDeEmpleados;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Organizacion(String tipoOrganizacion, int cantidadDeEmpleados, FuncionalidadExterna carga,
			FuncionalidadExterna validacion, Ubicacion ubicacion, List<ZonaCobertura> zonasSubscriptas) {
		super();
		this.tipoOrganizacion = tipoOrganizacion;
		this.cantidadDeEmpleados = cantidadDeEmpleados;
		this.funcionalidadCargaMuestra = carga;
		this.funcionalidadValidacionMuestra = validacion;
		this.ubicacion = ubicacion;
		this.zonasSubscriptas = zonasSubscriptas;
	}

	public void notifyMeValidation(ZonaCobertura zona, Muestra muestra) {
		this.getFuncionalidadExternaValidacion().nuevoEvento(this, zona, muestra);
		;

	}

	public void notifyMeCarga(ZonaCobertura zona, Muestra muestra) {
		this.getFuncionalidadExternaCarga().nuevoEvento(this, zona, muestra);
		;
	}
}
