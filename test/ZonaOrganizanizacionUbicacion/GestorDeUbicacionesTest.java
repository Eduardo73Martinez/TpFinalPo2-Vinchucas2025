package ZonaOrganizanizacionUbicacion;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorDeUbicacionesTest {
	Map<Ubicacion, List<ZonaCobertura>> zonasPorUbicacion;
	Ubicacion ubicacion1;
	Ubicacion ubicacion2;
	Ubicacion ubicacion3;
	List<ZonaCobertura> zonas1= new ArrayList<>();
	List<ZonaCobertura> zonas2= new ArrayList<>();
	List<ZonaCobertura> zonas3= new ArrayList<>();
	
	ZonaCobertura zonaA = mock(ZonaCobertura.class);
	ZonaCobertura zonaB = mock(ZonaCobertura.class);
	ZonaCobertura zonaC = mock(ZonaCobertura.class);
	
	ZonaCobertura zonaD = mock(ZonaCobertura.class);
	ZonaCobertura zonaE = mock(ZonaCobertura.class);
	ZonaCobertura zonaF = mock(ZonaCobertura.class);

	ZonaCobertura zonaG = mock(ZonaCobertura.class);
	ZonaCobertura zonaH = mock(ZonaCobertura.class);
	ZonaCobertura zonaI = mock(ZonaCobertura.class);
	
	@BeforeEach
	void setUp() throws Exception {
		//MOCKEO LAS UBICACIONES
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		ubicacion3 = mock(Ubicacion.class);
		
		//AGREGO LAS ZONAS A LAS LISTAS 
		zonas1.add(zonaA);zonas1.add(zonaB);zonas1.add(zonaC);
		zonas2.add(zonaD);zonas2.add(zonaE);zonas2.add(zonaF);
		zonas2.add(zonaG);zonas2.add(zonaH);zonas2.add(zonaI);
		
		//CREO EL MAP 
		zonasPorUbicacion = new HashMap<>();
		zonasPorUbicacion.put(ubicacion1, zonas1);
		zonasPorUbicacion.put(ubicacion2, zonas2);
		zonasPorUbicacion.put(ubicacion3, zonas3);
		
	}
	
	/**
	 * Implementar al final.
	 */
	@Test
	void testObtenerUbicacion() {
		fail("Not yet implemented");
	}

	@Test
	void testValidarUbicacion() {
		
		fail("Not yet implemented");
	}

	@Test
	void testNotificarNuevaMuestra() {
		fail("Not yet implemented");
	}

	@Test
	void testNotificarNuevaValidacion() {
		fail("Not yet implemented");
	}

	@Test
	void testGestorDeUbicaciones() {
		fail("Not yet implemented");
	}

	@Test
	void testGetZonasPorUbicacion() {
		fail("Not yet implemented");
	}

	@Test
	void testSetZonasPorUbicacion() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTodasLasZonas() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTodasLasZonas() {
		fail("Not yet implemented");
	}
	/**
	 * ES IMPORTANTE EL ULTIMO
	 */
	@Test
	void testAsociarZona() {
		fail("Not yet implemented");
	}

}
