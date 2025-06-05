package web_vinchucas;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
	private Double latitud;
	private Double longitud;
	

	public Ubicacion(Double latitud, Double longitud) {
		// TODO Auto-generated constructor stub
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public List<Ubicacion> ubicacionesCercanas(List<Ubicacion> listaUbicaciones, float distancia){
		List<Ubicacion> nuevaLista = new ArrayList<Ubicacion>();
		//TODO: hacer metodo
		return nuevaLista;
	}

	public Double getLatitud() {
		// TODO Auto-generated method stub
		return this.latitud;
	}

	public Double getLongitud() {
		// TODO Auto-generated method stub
		return this.longitud;
	}
}
