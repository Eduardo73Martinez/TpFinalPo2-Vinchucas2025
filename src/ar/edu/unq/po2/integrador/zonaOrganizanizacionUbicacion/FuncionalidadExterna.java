package ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion;
import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

public interface FuncionalidadExterna{ 
  /**
   * Es una interface que implementan todas las que se settean como funcionalidad en Organizacion.
   */
  public void nuevoEvento(Organizacion organizacion, ZonaCobertura zona, Muestra muestra); 
}