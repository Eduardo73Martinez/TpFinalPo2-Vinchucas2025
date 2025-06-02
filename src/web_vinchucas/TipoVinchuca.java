package web_vinchucas;

public enum TipoVinchuca implements IOpinable{

	VINCHUCA_INFESTANS("Vinchuca Infestans"), VINCHUCA_SORDIDA("Vinchuca Sordida"), VINCHUCA_GUASAYANA("Vinchuca Guasayana");
	
	String valor;
	
	TipoVinchuca(String v) {
		this.valor = v;
	}
	
	public String getValor() {
		return this.valor;
	}
}
