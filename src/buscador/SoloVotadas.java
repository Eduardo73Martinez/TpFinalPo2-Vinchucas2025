package buscador;

import java.util.List;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

public class SoloVotadas extends PorVerificacion{

	public List<Muestra> esDelTipoEsperado (Muestra muestra){
		return muestra.getVerificacion().esVotada();
	}
	public SoloVotadas (Web web){
		super (web);
	}
}
