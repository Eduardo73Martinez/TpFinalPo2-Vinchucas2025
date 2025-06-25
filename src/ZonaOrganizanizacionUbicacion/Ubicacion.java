package ZonaOrganizanizacionUbicacion;

import java.lang.Math;

import java.util.List;
import java.util.Objects;

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
	 * @param  OTRA UBICACION
	 * @return LA DISTANCIA ENTRE DOS UBICACIONES.
	 */
	public double distanciaCon(Ubicacion ubicacion2) {
		// TODO Auto-generated method stub
		return this.raizCuadrada(this.potencia(this.getLatidud() - ubicacion2.getLatidud())
				+ this.potencia(this.getLongitud() - ubicacion2.getLongitud()));
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
	
	/**
	 * METODOS PARA QUE SOLAMENTE SEAN IGUALES LAS UBICACIONES CUANDO 
	 * SUS COORDENADAS SON IGUALES. 
	 * 
	 * HASH CODE ES PARA QUE SEAN IGUALES CON EQUALS EN LOS MAPS.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true; // MISMA REFERENCIA AL OBJETO
		if (!(obj instanceof Ubicacion)) return false;// NULL O CLASES DIFERENTEES (INSTANCEOF ACEPTA SUBCLASES DE UBICACION)

		Ubicacion other = (Ubicacion) obj;
		return Objects.equals(latitud, other.latitud) && Objects.equals(longitud, other.longitud);
	}
	@Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }

}
