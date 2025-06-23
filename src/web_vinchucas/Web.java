package web_vinchucas;

import ZonaOrganizanizacionUbicacion.*;

import java.util.ArrayList;
import java.util.List;

public class Web {
	List<Muestra> muestras = new ArrayList<Muestra>();
	GestorDeUsuarios gestorUs = new GestorDeUsuarios(this);
	GestorDeUbicaciones gestorUbs = new GestorDeUbicaciones(this);
	
	public Web(GestorDeUsuarios gestorUs, GestorDeUbicaciones gestorUbs) {
		this.gestorUs = gestorUs;
		this.gestorUbs = gestorUbs;
		
	}
	
	public GestorDeUsuarios getGestorDeUsuarios() {
		return gestorUs;
	}
	
	public GestorDeUbicaciones getGestorUbicaciones() {
		return gestorUbs;
	}

	public List<Muestra> todasLasMuestras() {
		return muestras;
	}

	public void agregarMuestra(Muestra nuevaMuestra) {
		muestras.add(nuevaMuestra);
		this.notificarNuevaMuestra(nuevaMuestra);
	}
	
	public Ubicacion obtenerUbicacion(Double lat, Double lon) {
		return gestorUbs.obtenerUbicacion(lat, lon);
	}
	
	protected void notificarNuevaMuestra(Muestra muestra) {
		gestorUbs.notificarNuevaMuestra(muestra);
	}
	
	public void notificarNuevaValidacion(Muestra muestra) {
		gestorUbs.notificarNuevaValidacion(muestra);
	}

}
