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

	public void setLatitud(double latitud) {
		// TODO Auto-generated method stub
		this.latidud = latitud;
	}

	public void setLongitud(double longitud) {
		// TODO Auto-generated method stub
		this.longitud = longitud;
	}
	
	
	/*
	 * 
	 * 
	 * java doc 
	 * 
	 * estoy probando agregar lineas 
	 * paraa ver si estan 
	 * en el grafico de
	 * github
	 */
	
	
	
	
	
	
	
	
	
	

	public Double getLatidud() {
		return latidud;
	}

	public Double getLongitud() {
		return longitud;
	}
}
