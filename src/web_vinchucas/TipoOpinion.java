package web_vinchucas;

public enum TipoOpinion implements IOpinable{

	CHINCHE_FOLIADA("Chinche Foliada"), PHTIA_CHINCHE("Phtia-Chinche"), NINGUNA("Ninguna"), IMAGEN_POCO_CLARA("Imagen poco clara");
	
	String valor;
	
	TipoOpinion (String v){
		this.valor = v;
	}
	
	public String getValor() {
		return this.valor;
	}
}
