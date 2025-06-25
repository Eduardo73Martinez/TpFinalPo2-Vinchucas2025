package ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

class ZonaCoberturaTest {
	private ZonaCobertura zonaDeCobertura;
	private Ubicacion epicentro;
	private double radioEnKilometros = 300.4;
	private Organizacion organizacion1;
	private Organizacion organizacion2;
	private Organizacion organizacion3;
	private Organizacion organizacion4;
	private List<Organizacion> organizaciones = new ArrayList<Organizacion>();
	private List<Muestra> muestras = new ArrayList<Muestra>();

	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	Ubicacion ubicacion2;
	ZonaCobertura zona2;

	@BeforeEach
	void setUp() throws Exception {
		organizacion1 = mock(Organizacion.class);
		organizacion2 = mock(Organizacion.class);
		organizacion3 = mock(Organizacion.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		ubicacion2 = mock(Ubicacion.class);

		organizaciones.add(organizacion1);
		organizaciones.add(organizacion2);
		organizaciones.add(organizacion3);

		muestras.add(muestra1);
		muestras.add(muestra2);

		epicentro = mock(Ubicacion.class);
		zonaDeCobertura = new ZonaCobertura("Area 1", epicentro, radioEnKilometros, muestras, organizaciones);

		// OTRA UBICACION Y ZONA PARA TESTEAR INTERSECCIONES.

		zona2 = new ZonaCobertura("zona 2", ubicacion2, radioEnKilometros, muestras, organizaciones);

	}

	@Test
	void testGetNombre() {

		assertEquals("Area 1", zonaDeCobertura.getNombre());
	}

	@Test
	void testSetNombre() {
		zonaDeCobertura.setNombre("Area 2");
		assertEquals("Area 2", zonaDeCobertura.getNombre());
	}

	@Test
	void testGetEpicentro() {
		assertEquals(epicentro, zonaDeCobertura.getEpicentro());
	}

	@Test
	void testGetRadio() {
		assertEquals(300.4, zonaDeCobertura.getRadio());
	}

	@Test
	void testSetRadio() {
		zonaDeCobertura.setRadio(10.4);
		assertEquals(10.4, zonaDeCobertura.getRadio());
	}

	@Test
	void testGetMuestrasReportadas() {
		muestras.add(muestra3);
		zonaDeCobertura.cargarMuestra(muestra3);
		assertEquals(muestras.size(), zonaDeCobertura.getMuestras().size());
	}

	@Test
	void testInterseccionConZona() {
		
		when(epicentro.distanciaCon(zona2.getEpicentro())).thenReturn(400.9);
		
		zonaDeCobertura.interseccionConZona(zona2);
		
		verify(epicentro).distanciaCon(ubicacion2);
	}

	@Test
	void testInterseccionConZonaMenor() {
		Ubicacion ubicacion3 = mock(Ubicacion.class);
		when(epicentro.distanciaCon(ubicacion3)).thenReturn(3.0);
		zona2.setEpicentro(ubicacion3);
		zonaDeCobertura.interseccionConZona(zona2);
		verify(epicentro).distanciaCon(ubicacion3);
	}

	@Test
	void testCargaMuestraEnZona() {
		zonaDeCobertura.cargarMuestra(muestra3);
		assertTrue(zonaDeCobertura.getMuestras().contains(muestra3));
	}

	@Test
	void testValidacionSinCovertura() {
		//VALIDAR ES EQUIVALENTE A RESULTADO ACTUAL EN EL CODIGO DE LUCIO.
		when(epicentro.distanciaCon(ubicacion2)).thenReturn(9999.9);

		
		when(muestra4.getUbicacion()).thenReturn(ubicacion2);
		
		zonaDeCobertura.validacion(muestra4);
		
		verify(organizacion1, never()).notifyMeValidation(zonaDeCobertura, muestra4);
	}

	@Test
	void testValidacionConCovertura() {
		//VALIDAR ES EQUIVALENTE A RESULTADO ACTUAL EN EL CODIGO DE LUCIO.
		when(epicentro.distanciaCon(ubicacion2)).thenReturn(299.9);

		
		when(muestra4.getUbicacion()).thenReturn(ubicacion2);
		
		zonaDeCobertura.validacion(muestra4);
		
		verify(organizacion1).notifyMeValidation(zonaDeCobertura, muestra4);
	}

	@Test
	void testSuscribirOrganizacion() {
		zonaDeCobertura.sucribeOrganizacion(organizacion4);
		assertTrue(zonaDeCobertura.getOrganizaciones().contains(organizacion4));
	}

	@Test
	void testDesuscribirOrganizacion() {
		zonaDeCobertura.unsubscribeOrganizacion(organizacion3);
		assertFalse(zonaDeCobertura.getOrganizaciones().contains(organizacion3));
	}

	@Test
	void testTieneCoberturaLaMuestra() {
		when(muestra1.getUbicacion()).thenReturn(ubicacion2);
		when(ubicacion2.getLatidud()).thenReturn(2.0);
		when(ubicacion2.getLongitud()).thenReturn(2.0);
		
		assertTrue(zonaDeCobertura.tieneCoberturaLaMuestra(muestra1));
		
	}

	@Test
	void testCargarMuestraEnZonaPorCovertura() {
		
		when(epicentro.distanciaCon(ubicacion2)).thenReturn(150.9);
		when(muestra4.getUbicacion()).thenReturn(ubicacion2);
		
		zonaDeCobertura.cargarMuestraEnZona(muestra4);
		
		verify(organizacion1).notifyMeCarga(zonaDeCobertura, muestra4);
	}

	@Test
	void testNOCargarMuestraEnZonaPorCovertura() {
		
		when(epicentro.distanciaCon(ubicacion2)).thenReturn(9999.9);		
		when(muestra4.getUbicacion()).thenReturn(ubicacion2);
		
		zonaDeCobertura.cargarMuestraEnZona(muestra4);
		
		verify(organizacion1, never()).notifyMeCarga(zonaDeCobertura, muestra4);
	}

	@Test
	void testHayIntersecciones() {
		ZonaCobertura z1 = new ZonaCobertura("z1", epicentro, 32.0, muestras, organizaciones);
		ZonaCobertura z2= new ZonaCobertura("z2", epicentro, 10.4, muestras, organizaciones);
		ZonaCobertura z3= new ZonaCobertura("z3", epicentro, 4.5, muestras, organizaciones);
		ZonaCobertura z4 = new ZonaCobertura("z4", epicentro, 45.6, muestras, organizaciones);
		
		List<ZonaCobertura> zonas= new ArrayList<>(); zonas.add(z1);zonas.add(z2);zonas.add(z3);zonas.add(z4);
		
		//TODAS LAS ZONAS TIENEN PASSADA LA MISMA UBICACION ASIQUE DEBERIA DEVOLVER LA MISMA LISTA.
		assertEquals(zonas, zonaDeCobertura.intersecciones(zonas));
		
	}

}
