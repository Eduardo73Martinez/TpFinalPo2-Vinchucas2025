package ZonaOrganizanizacionUbicacion;

import java.util.*;

public class Organizacion {
	private String tipoOrganizacion;
	private int cantidadDeEmpleados;
	private FuncionalidadExterna funcionalidad;
	private Ubicacion ubicacion;
	private List<ZonaCobertura> zonasSubscriptas;

	public List<ZonaCobertura> getZonasSubscriptas() {
		return zonasSubscriptas;
	}

	public FuncionalidadExterna getFuncionalidadExterna() {
		return this.funcionalidad;
	}

	public void setFuncionalidadExterna(FuncionalidadExterna funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public void subscribe(ZonaCobertura zona) {
		zona.sucribeOrganizacion(this);
		this.zonasSubscriptas.add(zona);
	}

	public void unsubscribe(ZonaCobertura zona) {
		zona.unsubscribeOrganizacion(this);
		if (this.zonasSubscriptas.contains(zona))
			this.zonasSubscriptas.remove(zona);
		else
			new RuntimeException("No esta en la lista");
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

	public Organizacion(String tipoOrganizacion, int cantidadDeEmpleados, FuncionalidadExterna funcionalidad,
			Ubicacion ubicacion, List<ZonaCobertura> zonasSubscriptas) {
		super();
		this.tipoOrganizacion = tipoOrganizacion;
		this.cantidadDeEmpleados = cantidadDeEmpleados;
		this.funcionalidad = funcionalidad;
		this.ubicacion = ubicacion;
		this.zonasSubscriptas = zonasSubscriptas;
	}

	public void notifyMe() {

	}
}
