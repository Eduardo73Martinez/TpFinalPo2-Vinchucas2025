package verificacion;



import java.util.List;

import java.util.stream.Collectors;

import web_vinchucas.IOpinable;
import web_vinchucas.Muestra;
import web_vinchucas.Nivel;
import web_vinchucas.Opinion;
import web_vinchucas.Usuario;

public class OpinionBasicos extends NoVerificada {
	public boolean esVerificada() {
		return false;
	}
	public boolean puedeVotar (Usuario usuario) {
		return true;
	}
	public String resultadoActual (Muestra muestra) {
		if (hayAlMenosDosOpinionesDiferentes (getIOpinable(muestra))) {
			if (hayOpinionMayoritaria(getIOpinable(muestra))) {
				return opinionMayoritaria(getIOpinable(muestra)).getValor();
			} else {
				return "No definido";
			} 
			
		}else {
				return muestra.getVinchuca().getValor();
			}
	}
	
	public void verificar(Muestra muestra) {
		//hago que pase a ser OpinionExpertos al haber al menos una opinon de experto o especialista
		if (algunExpertoOEspecialistaOpino (muestra)) {
		OpinionExpertos opinionExperto = new OpinionExpertos ();
		muestra.setVerificacion (opinionExperto);
		}
	}
	private boolean algunExpertoOEspecialistaOpino(Muestra muestra) {
		return getOpiniones(muestra).stream().anyMatch(
				elemento->elemento.getNivelOpinion() == Nivel.EXPERTO ||
				elemento.getNivelOpinion() == Nivel.ESPECIALISTA);
		//esto devuelve true si algun elemento de la lista de opiniones de muestra fue dejado por 
		//alguien que es experto o especialista
	}
	private List<Opinion> getOpiniones(Muestra muestra){
		return muestra.getOpiniones();
	}
	
	protected List<IOpinable> getIOpinable(Muestra muestra){
		//devuelve los enums de las opiniones
		return 
				muestra.getOpiniones().stream()
				.map(opinion->opinion.getValorOpinion())
				.collect(Collectors.toList());
	}
	
	public boolean esVotada() {
		return false;
	}
	
	
	
	public OpinionBasicos () {
	
	}
}
