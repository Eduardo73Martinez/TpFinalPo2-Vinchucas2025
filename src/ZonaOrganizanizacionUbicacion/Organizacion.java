package ZonaOrganizanizacionUbicacion;

import java.util.*;
import web_vinchucas.*;

public class Organizacion implements OrganizacionNoGubernamental {
	private String tipoOrganizacion;
	private int cantidadDeEmpleados;
	private FuncionalidadExterna carga;
	private FuncionalidadExterna validacion;
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
		return this.carga;
	}

	public FuncionalidadExterna getFuncionalidadExternaValidacion() {
		return this.validacion;
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

	/**
	 * 
	 * @param tipoOrganizacion    EL TIPO DE ORGANIZACION BENFICA, SALUD, ONG, EC
	 * @param cantidadDeEmpleados CANTIDAD DE EMPLEADO QUE TRABAJAN EN ESTA
	 *                            ORGANIZACION
	 * @param carga               LA FUNCIONALIDAD EXTERNA QUE FUNCIONA EN LA CARGA
	 * @param validacion          LA FUNCIONALIDAD EXTERNA QUE FUNCIONA EN LA
	 *                            VALIDACION
	 * @param ubicacion           LA UBICACION DONDE SE ENCUENTRA LA ORGANIZACION
	 * @param zonasSubscriptas    LA ZONA A LAS CUALES SE SUBSCRIBIO
	 */
	public Organizacion(String tipoOrganizacion, int cantidadDeEmpleados, FuncionalidadExterna carga,
			FuncionalidadExterna validacion, Ubicacion ubicacion, List<ZonaCobertura> zonasSubscriptas) {
		super();
		this.tipoOrganizacion = tipoOrganizacion;
		this.cantidadDeEmpleados = cantidadDeEmpleados;
		this.carga = carga;
		this.validacion = validacion;
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

	public void setCarga(FuncionalidadExterna carga) {
		this.carga = carga;
	}

	public void setValidacion(FuncionalidadExterna validacion) {
		this.validacion = validacion;
	}
}
