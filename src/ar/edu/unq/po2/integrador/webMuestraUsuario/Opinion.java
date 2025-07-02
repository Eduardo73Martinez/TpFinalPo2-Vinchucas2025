package ar.edu.unq.po2.integrador.webMuestraUsuario;

import java.time.LocalDate;

public class Opinion {
	
	private Usuario usuario;
	private Muestra muestra;
	private IOpinable valorOpinion;
	private Nivel nivelUsuario;
	private LocalDate fecha;
	
	//Devuelve el Usuario que dejo la opinion
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	//Devuelve la Muestra opinada
	public Muestra getMuestra() {
		return muestra;
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
	
	public Opinion(Usuario usuario, Muestra muestra, IOpinable vo) {
		this.usuario = usuario;
		this.muestra = muestra;
		this.nivelUsuario = usuario.getNivel();
		this.fecha = LocalDate.now();
		this.valorOpinion = vo;
	}

}
