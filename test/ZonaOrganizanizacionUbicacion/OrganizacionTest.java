package ZonaOrganizanizacionUbicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionTest {
	private Organizacion organizacion;
	private FuncionalidadExterna funcionalidad;
	private FuncionalidadExterna nuevafuncionalidad;
	private Ubicacion ubicacion;
	private ZonaCobertura zona1;
	private ZonaCobertura zona2; 
	private ZonaCobertura zona3;
	private ZonaCobertura zona4;
	private List<ZonaCobertura> listaZonas = new ArrayList<ZonaCobertura>();
	
	

	@BeforeEach
	void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		zona1 = mock(ZonaCobertura.class);
		zona2 = mock(ZonaCobertura.class);
		zona3 = mock(ZonaCobertura.class);
		zona4 = mock(ZonaCobertura.class);
		funcionalidad= mock(FuncionalidadExterna.class);
		nuevafuncionalidad = mock(FuncionalidadExterna.class);
		
		
		this.listaZonas.add(zona1);
		this.listaZonas.add(zona2); 
		this.listaZonas.add(zona3);
		
		organizacion = new Organizacion("Medica", 556, funcionalidad, ubicacion,this.listaZonas);
		
	}
	/**
	 * constructor
	 */
	@Test
	void testOrganizacion() {
		assertEquals(Organizacion.class, organizacion.getClass());
	}

	@Test
	void testGetFuncionalidadExtera() {
		
		assertEquals(funcionalidad, organizacion.getFuncionalidadExterna());
	}

	@Test
	void testSetFuncionalidadExterna() {
		organizacion.setFuncionalidadExterna(nuevafuncionalidad);
		assertEquals(nuevafuncionalidad, organizacion.getFuncionalidadExterna());
	}

	@Test
	void testSubscribe() {
		organizacion.subscribe(zona4);
		assertEquals(4, organizacion.getZonasSubscriptas().size());
	}
	@Test
	void testGetZonasSubscriptas() {
		assertTrue(organizacion.getZonasSubscriptas().contains(zona1));
	}

	@Test
	void testUnsubscribe() {
		organizacion.unsubscribe(zona1);
		assertEquals(2, organizacion.getZonasSubscriptas().size());
	}

	@Test
	void testGetTipoOrganizacion() {
		assertEquals("Medica", organizacion.getTipoOrganizacion());
	}

	@Test
	void testGetCantidadDeEmpleados() {
		assertEquals(556, organizacion.getCantidadDeEmpleados());
	}

	@Test
	void testGetUbicacion() {
		assertEquals(ubicacion, organizacion.getUbicacion());
	}

	@Test
	void testNotifyMe() {
		fail("Not yet implemented");
	}

}
