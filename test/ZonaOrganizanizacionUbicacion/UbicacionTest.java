package ZonaOrganizanizacionUbicacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import web_vinchucas.Muestra;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class UbicacionTest {
	private Ubicacion miubicacion;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;

	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Muestra[] arrayMuestras = { muestra1, muestra2, muestra3 };
	private ArrayList<Ubicacion> ubicacionesCercanas = new ArrayList<Ubicacion>();

	@BeforeEach
	void setUp() throws Exception {
		miubicacion = new Ubicacion(10.0, 45.0);
		ubicacion2 = new Ubicacion(66.5, 46.4);
		ubicacion3 = new Ubicacion(30.4, 50.3);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
 
		ubicacionesCercanas.add(ubicacion2);
		ubicacionesCercanas.add(ubicacion3);

	}

	@Test
	void testUbicacion() {

		assertEquals(Ubicacion.class, miubicacion.getClass());
	}

	// setters y getters

	@Test
	void testGetLatitud() {
		assertEquals(10.0, miubicacion.getLatidud());
	}

	@Test
	void testGetLongitud() {
		assertEquals(45.0, miubicacion.getLongitud());
	}

	@Test
	void testSetLatitud() {
		double nuevoValor = 43.4;
		miubicacion.setLatitud(43.4);
		assertEquals(nuevoValor, miubicacion.getLatidud());
	}

	@Test
	void testSetLongitud() {
		double nuevoValor = 23.3;
		miubicacion.setLongitud(23.3);
		assertEquals(nuevoValor, miubicacion.getLongitud());
	}
	// funcionalidades

	@Test
	void testListaUbicacionesConDistanciaMenorA() {
		
		List<Ubicacion> lista = miubicacion.ubicacionesCercanas(ubicacionesCercanas, 50.0);
		
		assertEquals(1, lista.size());
	}
	/**
	 * IMPORTANTE PREGUNTAR SI IMPLEMENTO ESTA FUNCIONALIDAD 
	 * O LA DEJO QUE LA IMPLEMENTE LA CLASE MUESTRA
	 * 
	 * 
	 */

}
