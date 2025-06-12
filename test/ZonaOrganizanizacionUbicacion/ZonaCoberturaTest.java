package ZonaOrganizanizacionUbicacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZonaCoberturaTest {
	private ZonaCobertura zonaDeCobertura;
	private Ubicacion epicentro;
	private double radioEnKilometros = 300.4;
	private Organizacion organizacion1;
	private Organizacion organizacion2;
	private Organizacion organizacion3;
	private Organizacion organizacion4;
	private ArrayList<Organizacion> organizaciones = new ArrayList<Organizacion>();

	@BeforeEach
	void setUp() throws Exception {
		epicentro = mock(Ubicacion.class);
		zonaDeCobertura = new ZonaCobertura("Area 1", epicentro, radioEnKilometros);

	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	void testSetNombre() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEpicentro() {
		fail("Not yet implemented");
	}

	@Test
	void testSetEpicentro() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRadio() {
		fail("Not yet implemented");
	}

	@Test
	void testSetRadio() {
		fail("Not yet implemented");
	}

	@Test
	void testMuestrasReportadas() {
		fail("Not yet implemented");
	}

	@Test
	void testZonasQueSeSolapan() {
		fail("Not yet implemented");
	}

	@Test
	void testCargaMuestra() {
		fail("Not yet implemented");
	}

	@Test
	void testValidacionMuestra() {
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

}
