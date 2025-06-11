package ZonaOrganizanizacionUbicacion;
import web_vinchucas.*;

public interface FuncionalidadExterna{ 
  /**
   * Es una interface que implementan todas las que se settean como funcionalidad en Organizacion.
   */
  public void nuevoEvento(Organizacion organizacion, ZonaCobertura zona, Muestra muestra); 
}