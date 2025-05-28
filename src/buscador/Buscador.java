package web_vinchucas;

import web_vinchucas.Web;

public abstract class Buscador {
	
	Web web;
	protected todasLasMuestras () {
		return web.todasLasMuestras():
	}
	private void setWeb (Web web) {
		this.web = web;
	}
	
	public Buscador (Web web) {
		setWeb (web);
	}
}
