package ZonaOrganizanizacionUbicacion;

import java.lang.Math;

import java.util.List;

public class Ubicacion {
	private Double latitud;
	private Double longitud;

	public Ubicacion(Double latitud, Double longitud) {
		// TODO Auto-generated constructor stub
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public List<Ubicacion> ubicacionesCercanas(List<Ubicacion> listaUbicaciones, double distancia) {
		return listaUbicaciones.stream().filter(s -> s.distanciaCon(this) < distancia).toList();
	}

	/**
	 * d = √( (x₂ - x₁)² + (y₂ - y₁)²)
	 * 
	 * @param distancia entre dos puntos en el plano.
	 * @return
	 */
	public double distanciaCon(Ubicacion distancia2) {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(this.getLatidud() - distancia2.getLatidud(), 2)
				+ Math.pow(this.getLongitud() - distancia2.getLongitud(), 2));
	}

	public double raizCuadrada(double numero) {
		return 0;
	}

	public void setLatitud(double latitud) {
		// TODO Auto-generated method stub
		this.latitud = latitud;
	}

	public void setLongitud(double longitud) {
		// TODO Auto-generated method stub
		this.longitud = longitud;
	}

	public Double getLatidud() {
		return this.latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

}
