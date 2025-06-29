package ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;

class OrganizacionTest {
	private Organizacion organizacion;
	private FuncionalidadExterna carga;
	private FuncionalidadExterna validacion;
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
		carga = mock(FuncionalidadExterna.class);
		validacion = mock(FuncionalidadExterna.class);

		this.listaZonas.add(zona1);
		this.listaZonas.add(zona2);
		this.listaZonas.add(zona3);

		organizacion = new Organizacion("Medica", 556, carga, validacion, ubicacion, this.listaZonas);

	}

	/**
	 * constructor
	 */
	@Test
	void testOrganizacion() {
		assertEquals(Organizacion.class, organizacion.getClass());
	}

	@Test
	void testGetFuncionalidadExteraCarga() {

		assertEquals(carga, organizacion.getFuncionalidadExternaCarga());
	}

	@Test
	void testGetFuncionalidadExteraValidacion() {

		assertEquals(validacion, organizacion.getFuncionalidadExternaValidacion());
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
	/*
	 * FALTAN LOS DOS ULTIMOS MENSAJES. LOS IMPLEMENTE DESPUES DE RELEER EL
	 * ENUNCIADO.
	 * 
	 */

	@Test
	void testNotifyMenotifyMeValidation() {
		Muestra muestra = mock(Muestra.class);
		organizacion.notifyMeValidation(zona1, muestra);
		verify(validacion).nuevoEvento(organizacion, zona1, muestra);
	}

	@Test
	void testNotifyMeCarga() {
		Muestra muestra = mock(Muestra.class);
		organizacion.notifyMeCarga(zona1, muestra);
		verify(carga).nuevoEvento(organizacion, zona1, muestra);
	}
	
	@Test
	void testSetFuncionalidadExteraCarga() {
		FuncionalidadExterna nuevaCarga = mock(FuncionalidadExterna.class);
		
		organizacion.setCarga(nuevaCarga);

		assertEquals(nuevaCarga, organizacion.getFuncionalidadExternaCarga());
	}

	@Test
	void testSetFuncionalidadExteraValidacion() {
		FuncionalidadExterna nuevaValidacion = mock(FuncionalidadExterna.class);
		
		organizacion.setValidacion(nuevaValidacion);

		assertEquals(nuevaValidacion, organizacion.getFuncionalidadExternaValidacion());
	}

}
