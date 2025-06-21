package buscador;



import verificacion.NoVerificada;
import web_vinchucas.Muestra;


public class SoloVotadas extends PorVerificacion{

	public boolean esDelTipoEsperado (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue votada, si no lo es da false
		return muestra.getVerificacion() instanceof NoVerificada;
	}
	public SoloVotadas (){
		
	}
}
