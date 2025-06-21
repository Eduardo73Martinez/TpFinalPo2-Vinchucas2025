package buscador;

import verificacion.*;
import web_vinchucas.*;

public class SoloVotadas extends PorVerificacion{

	public boolean esDelTipoEsperado (Muestra muestra){
		//PROPOSITO:devuelve true si la muestra fue votada, si no lo es da false
		return muestra.getVerificacion() instanceof NoVerificada;
	}
	public SoloVotadas (Web web){
		super (web);
	}
}
