package web_vinchucas;

import java.time.LocalDate;

public class Opinion {
	
	Long idUsuario;
	IOpinable valorOpinion;
	Nivel nivelUsuario;
	LocalDate fecha;
	
	public Opinion(Long idUsuario, Nivel nivel, IOpinable vo) {
		this.idUsuario = idUsuario;
		this.nivelUsuario = nivel;
		this.fecha = LocalDate.now();
		this.valorOpinion = vo;
	}
	
	//Devuelve el Id del Usuario que dejo la opinion
	public Long getIdUsuario() {
		return this.idUsuario;
	}
	
	//Devuelve el IOpinable correspondiente a la opinion
	public IOpinable getValorOpinion() {
		return this.valorOpinion;
	}
	
	//Devuelve el nivel del usuario al momento de registrar la opinion
	public Nivel getNivelOpinion() {
		return this.nivelUsuario;
	}
	
	//Devuelve la fecha en la que se registro la opinion
	public LocalDate getFecha() {
		return this.fecha;
	}

}
