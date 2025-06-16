package buscador;


import java.util.List;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

abstract class Filtro {
	
	Web web;
	abstract List<Muestra> buscar();
	private void setWeb (Web web) {
		//PROPOSITO:setea la web
		this.web = web;
	}
	protected List<Muestra> todasLasMuestras () {
		//PROPOSITO:devuelve todas las muestras de web
		return web.todasLasMuestras();
	}
	public Filtro (Web web) {
		setWeb (web);
	}
}
