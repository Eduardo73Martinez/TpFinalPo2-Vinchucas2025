package ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion;
/**
 * ESTA INTERFAZ IMPLEMENTAN CUALQUIER TIPO DE 
 * ORGANIZACION SOLO ES PARA SIGNATURA O FIRMA DE LAS 
 * ORGANIZACIONES QUE LA IMPLEMENTEN
 * 
 * @author EDUARDO
 *
 */
public interface IOrganizacion {
	public String getTipoOrganizacion();

	public int getCantidadDeEmpleados();

	public Ubicacion getUbicacion();
}
