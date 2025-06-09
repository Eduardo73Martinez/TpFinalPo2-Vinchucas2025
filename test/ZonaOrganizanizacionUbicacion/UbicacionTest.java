package ZonaOrganizanizacionUbicacion;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import web_vinchucas.Muestra;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class UbicacionTest {
	private Ubicacion ubicacion;
	private Ubicacion ubicacion2;
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Muestra[] arrayMuestras = { muestra1, muestra2, muestra3 };

	@BeforeEach
	void setUp() throws Exception {
		ubicacion = new Ubicacion(45.9, 45.5);
		ubicacion2 = new Ubicacion(66.5, 46.4);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);

	}

	@Test
	void testUbicacion() {

		assertEquals(Ubicacion.class, ubicacion.getClass());
	}

	@Test
	void testDistanciaEntreDosUbicaciones() {
		// assertEquals(null, null);
	}

	@Test
	void testListaUbicacionesConDistanciaMenorA() {

		fail("Not yet implemented");
	}

	@Test
	void testListaMuestrasObtenidasAMenosDeTalDistancia() {
		fail("Not yet implemented");
	}

	// setters y getters

	@Test
	void testGetLatitud() {
		assertEquals(45.9, ubicacion.getLatidud());
	}

	@Test
	void testGetLongitud() {
		assertEquals(45.5, ubicacion.getLongitud());
	}

	@Test
	void testSetLatitud() {
		double nuevoValor = 43.4;
		ubicacion.setLatitud(43.4);
		assertEquals(nuevoValor, ubicacion.getLatidud());
	}

	@Test
	void testSetLongitud() {
		double nuevoValor = 23.3;
		ubicacion.setLongitud(23.3);
		assertEquals(nuevoValor, ubicacion.getLongitud());
	}

}
