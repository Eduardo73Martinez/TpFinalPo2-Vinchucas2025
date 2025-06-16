package buscador;



import web_vinchucas.Muestra;
import web_vinchucas.Web;

public class SoloVotadas extends PorVerificacion{

	public boolean esDelTipoEsperado (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue votada, si no lo es da false
		return muestra.getVerificacion().esVotada();
	}
	public SoloVotadas (Web web){
		super (web);
	}
}
