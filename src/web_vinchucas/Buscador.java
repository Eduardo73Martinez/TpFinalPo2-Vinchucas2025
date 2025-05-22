package web_vinchucas;

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
