package ZonaOrganizanizacionUbicacion;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOError;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web_vinchucas.Muestra;

class GestorDeUbicacionesTest {
	GestorDeUbicaciones gestor;
	Map<Ubicacion, List<ZonaCobertura>> zonasPorUbicacion;
	Ubicacion ubicacion1;
	Ubicacion ubicacion2;
	Ubicacion ubicacion3;
	List<ZonaCobertura> zonas1= new ArrayList<>();
	List<ZonaCobertura> zonas2= new ArrayList<>();
	List<ZonaCobertura> zonas3= new ArrayList<>();
	List<ZonaCobertura> todasLasZonas;
	Muestra muestra = mock(Muestra.class);
	
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
		zonas2.add(zonaG);zonas2.add(zonaH);
		
		//CREO EL MAP 
		zonasPorUbicacion = new HashMap<>();
		zonasPorUbicacion.put(ubicacion1, zonas1);
		zonasPorUbicacion.put(ubicacion2, zonas2);
		zonasPorUbicacion.put(ubicacion3, zonas3);
		
		//INSTANCIO EL OBJETO

		todasLasZonas = zonasPorUbicacion.values().stream().flatMap(List::stream).collect(Collectors.toList());
		gestor = new GestorDeUbicaciones(zonasPorUbicacion, todasLasZonas);
		
		
	}
	
	/**
	 * Implementar al final.
	 */
	@Test
	void testObtenerUbicacion() {
		assertEquals(ubicacion3, gestor.obtenerUbicacion(ubicacion3));
	}

	@Test
	void testValidarUbicacion() {
		// La ubicación ya está en el mapa (setUp la agregó)
		assertTrue(gestor.getZonasPorUbicacion().containsKey(ubicacion1));

		gestor.registrarUbicacion(ubicacion1);

		// El mapa no debería haber cambiado
		assertEquals(3, gestor.getZonasPorUbicacion().size());
		assertSame(zonas1, gestor.getZonasPorUbicacion().get(ubicacion1));
	}
	
	@Test
	void testValidarUbicacionFalse() {
		Ubicacion ubicacion4 = mock(Ubicacion.class);

		gestor.registrarUbicacion(ubicacion4);

		// El mapa no debería haber cambiado
		assertEquals(4, gestor.getZonasPorUbicacion().size());
	}

	@Test
	void testNotificarNuevaMuestra() {
		when(muestra.getUbicacion()).thenReturn(ubicacion1);
		
		gestor.notificarNuevaMuestra(muestra);
		
		verify(muestra).getUbicacion();
		verify(zonaB).cargarMuestraEnZona(muestra);
	}

	@Test
	void testNotificarNuevaValidacion() {
		when(muestra.getUbicacion()).thenReturn(ubicacion2);
		
		gestor.notificarNuevaValidacion(muestra);
		
		verify(muestra).getUbicacion();
		verify(zonaD).validacion(muestra);
	}

	@Test
	void testSetZonasPorUbicacion() {
		Map<Ubicacion, List<ZonaCobertura>> nuevoMap = new HashMap<>();
		gestor.setZonasPorUbicacion(nuevoMap);
		assertEquals(0,gestor.getZonasPorUbicacion().size());
	}

	@Test
	void testGetTodasLasZonas() {
		
		assertSame(todasLasZonas,gestor.getTodasLasZonas());
	} 

	@Test
	void testSetTodasLasZonas() {
		
		List<ZonaCobertura> zonasNueva = new ArrayList<>();
		
		gestor.setTodasLasZonas(zonasNueva);
		
		assertSame(zonasNueva,gestor.getTodasLasZonas());
	}
	
	@Test
	void testAsociarZona() throws SinCoberturaException {
		zonas3.add(zonaI);
		
		gestor.asociarUbicacionConZona(ubicacion3, zonaI);
		
		assertTrue(gestor.getTodasLasZonas().contains(zonaI));
	}
	
	@Test
	void testValidarZonaEnUbicacion() {
	    // Configuramos los mocks
	    when(zonaI.getEpicentro()).thenReturn(ubicacion2);
	    when(zonaI.getRadio()).thenReturn(500.0);
	    when(ubicacion3.distanciaCon(ubicacion2)).thenReturn(1000.0);

	    // Ahora ejecutamos y verificamos que lance la excepción
	    SinCoberturaException exception = assertThrows(SinCoberturaException.class, () -> {
	        gestor.validarZonaEnUbicacion(ubicacion3, zonaI);
	    });

	    // Verificamos el mensaje de la excepción
	    assertEquals("La Ubicacion no está dentro de la cobertura", exception.getMessage());
	}
	
	@Test
	void testSacarZona() {
		gestor.sacarZona(zonaA);
		assertEquals(7, gestor.getTodasLasZonas().size());
	}


}
