package ZonaOrganizanizacionUbicacion;

import java.lang.Math;

import java.util.List;

public class Ubicacion {
	private Double latitud;
	private Double longitud;
	private ZonaCobertura zona;

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
		return this.raizCuadrada(this.potencia(this.getLatidud() - distancia2.getLatidud())
				+ this.potencia(this.getLongitud() - distancia2.getLongitud()));
	}

	public double raizCuadrada(double numero) {
		return Math.sqrt(numero);
	}

	/*
	 * n^2
	 */
	public double potencia(double numero) {
		return Math.pow(numero, 2);
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
