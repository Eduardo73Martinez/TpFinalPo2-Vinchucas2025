package ar.edu.unq.po2.integrador.webMuestraUsuario;

public enum TipoOpinion implements IOpinable{

	CHINCHE_FOLIADA("Chinche Foliada"), PHTIA_CHINCHE("Phtia-Chinche"), NINGUNA("Ninguna"), IMAGEN_POCO_CLARA("Imagen poco clara");
	
	private String valor;
	
	//Devuelve un string con el valor asociado al TipoOpinion
	public String getValor() {
		return this.valor;
	}
	
	TipoOpinion (String v){
		this.valor = v;
	}
}
