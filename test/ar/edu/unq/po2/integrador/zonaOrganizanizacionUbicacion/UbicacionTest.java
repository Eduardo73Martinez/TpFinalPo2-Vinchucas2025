package ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class UbicacionTest {
	private Ubicacion miubicacion;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;

	private Muestra muestra1;
	
	private ArrayList<Ubicacion> ubicacionesCercanas = new ArrayList<Ubicacion>();

	@BeforeEach
	void setUp() throws Exception {
		miubicacion = new Ubicacion(10.0, 45.0);
		ubicacion2 = new Ubicacion(66.5, 46.4);
		ubicacion3 = new Ubicacion(30.4, 50.3);
		muestra1 = mock(Muestra.class);
		
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

	@Test
	void testEquals() {
		Ubicacion ubicacion4 = ubicacion2;
		assertTrue(ubicacion2.equals(ubicacion4));
		assertFalse(miubicacion.equals(ubicacion4));
		assertFalse(miubicacion.equals(muestra1));
	}

	@Test
	void testNotEquals() {
		Ubicacion ubicacion4 = ubicacion2;
		assertFalse(miubicacion.equals(ubicacion4));
	}

	@Test
	void testHashCodeIgualParaObjetosIguales() {
		Ubicacion u1 = new Ubicacion(12.1, 10.0);
		Ubicacion u2 = new Ubicacion(12.1, 10.0);

		assertEquals(u1, u2); // Verifica equals
		assertEquals(u1.hashCode(), u2.hashCode(), "Los hashCodes deben ser iguales");
	}

	@Test
	void testHashCodeDistintoParaObjetosDistintos() {
		Ubicacion u1 = new Ubicacion(12.1, 10.0);
		Ubicacion u2 = new Ubicacion(11.0, 9.0);

		// No hay garantía, pero es muy probable que sean distintos
		assertNotEquals(u1.hashCode(), u2.hashCode(), "HashCodes deberían ser distintos si los valores lo son");
	}

}
