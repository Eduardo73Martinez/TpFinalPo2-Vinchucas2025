package web_vinchucas;

public enum TipoVinchuca implements IOpinable{

	VINCHUCA_INFESTANS("Vinchuca Infestans"), VINCHUCA_SORDIDA("Vinchuca Sordida"), VINCHUCA_GUASAYANA("Vinchuca Guasayana");
	
	String valor;
	
	//Devuelve el String asociado al TipoVinchuca
	public String getValor() {
		return this.valor;
	}
	
	TipoVinchuca(String v) {
		this.valor = v;
	}
}
