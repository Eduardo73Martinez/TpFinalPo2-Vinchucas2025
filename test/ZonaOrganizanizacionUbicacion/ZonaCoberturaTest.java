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

	
	
	@BeforeEach
	void setUp() throws Exception {
		organizaciones.add(organizacion1);
		organizaciones.add(organizacion2);
		organizaciones.add(organizacion3);
		
		muestras.add(muestra1);
		muestras.add(muestra2);
		
		epicentro = mock(Ubicacion.class);
		zonaDeCobertura = new ZonaCobertura("Area 1", epicentro, radioEnKilometros,muestras, organizaciones);

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
	void testSetEpicentro() {
		Ubicacion nuevoEpicentro = mock(Ubicacion.class); 
		assertEquals(nuevoEpicentro, zonaDeCobertura.getEpicentro());
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
	void testZonasQueSeSolapan() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testDesuscribirOrganizacion() {
		fail("Not yet implemented");
	}
	@Test
	void testTieneCoberturaLaMuestra() {
		fail("Not yet implemented");
	}

	@Test
	void testHayIntersecciones() {
		fail("Not yet implemented");
	}

}
