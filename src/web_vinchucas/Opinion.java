package web_vinchucas;

import java.time.LocalDate;

public class Opinion {
	
	IOpinable valorOpinion;
	Nivel nivelUsuario;
	LocalDate fecha;
	
	public Opinion(Nivel nivel, IOpinable vo) {
		this.nivelUsuario = nivel;
		this.fecha = LocalDate.now();
		this.valorOpinion = vo;
	}

	public IOpinable getValorOpinion() {
		return this.valorOpinion;
	}
	
	public Nivel getNivelOpinon() {
		return this.nivelUsuario;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}

}
