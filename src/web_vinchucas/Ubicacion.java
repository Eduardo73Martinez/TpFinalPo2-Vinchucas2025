package web_vinchucas;

public class Ubicacion {
	private Double latidud;
	private Double longitud;
	

	public Ubicacion(Double latitud, Double longitud) {
		// TODO Auto-generated constructor stub
		this.latidud = latitud;
		this.longitud = longitud;
	}


	public void setLatitud(double latitud) {
		// TODO Auto-generated method stub
		this.latidud = latitud;
	}


	public void setLongitud(double longitud) {
		// TODO Auto-generated method stub
		this.longitud = longitud;
	}


	public Double getLatidud() {
		return latidud;
	}



	public Double getLongitud() {
		return longitud;
	}


}
