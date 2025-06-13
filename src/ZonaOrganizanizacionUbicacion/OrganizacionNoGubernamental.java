package ZonaOrganizanizacionUbicacion;
/**
 * ESTA INTERFAZ IMPLEMENTAN CUALQUIER TIPO DE 
 * ORGANIZACION SOLO ES PARA SIGNATURA O FIRMA DE LAS 
 * ORGANIZACIONES QUE LA IMPLEMENTEN
 * 
 * @author EDUARDO
 *
 */
public interface OrganizacionNoGubernamental {
	public String getTipoOrganizacion();

	public int getCantidadDeEmpleados();

	public Ubicacion getUbicacion();
}
