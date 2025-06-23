package ZonaOrganizanizacionUbicacion;
import web_vinchucas.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

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
		organizacion1= mock(Organizacion.class);
		organizacion2= mock(Organizacion.class);
		organizacion3= mock(Organizacion.class);
		muestra1 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		ubicacion2= mock(Ubicacion.class);
		
		organizaciones.add(organizacion1);
		organizaciones.add(organizacion2);
		organizaciones.add(organizacion3);
		
		muestras.add(muestra1);
		muestras.add(muestra2);
		
		epicentro = mock(Ubicacion.class);
		zonaDeCobertura = new ZonaCobertura("Area 1", epicentro, radioEnKilometros,muestras, organizaciones);
		
		//OTRA UBICACION Y ZONA PARA TESTEAR INTERSECCIONES.
		
		zona2 = new ZonaCobertura("zona 2", ubicacion2, radioEnKilometros, muestras, organizaciones);

	} 

	@Test
	void test() {
		fail("Not yet implemented");
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
		assertTrue(zonaDeCobertura.getMuestras().contains(muestra3) );
	}

	@Test
	void testValidacion() {
		//VALIDAR ES EQUIVALENTE A RESULTADO ACTUAL EN EL CODIGO DE LUCIO.
		when(muestra1.resultadoActual()).thenReturn("SORDIDA");
		fail("Not yet implemented");
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
	void testNOTieneCoberturaLaMuestra() {
		
	}
	@Test
	void testQueNoCargaMuestraEnZonaPorNoCovertura() {
		when(muestra1.getUbicacion()).thenReturn(ubicacion2);
		when(ubicacion2.getLatidud()).thenReturn(2.0);
		when(ubicacion2.getLongitud()).thenReturn(2.0);
		
		zonaDeCobertura.cargarMuestra(muestra1);
		
		verify(organizacion1, never()).notifyMeCarga(zonaDeCobertura, muestra1);
	}
	@Test
	void testCargarMuestraEnZonaPorCovertura() {
		when(muestra4.getUbicacion()).thenReturn(ubicacion2);
		when(ubicacion2.getLatidud()).thenReturn(2.0);
		when(ubicacion2.getLongitud()).thenReturn(2.0);
		
		zonaDeCobertura.cargarMuestra(muestra1);
		
		verify(organizacion1).notifyMeCarga(zonaDeCobertura, muestra1);
	}

	@Test
	void testHayIntersecciones() {
		fail("Not yet implemented");
	}

}
