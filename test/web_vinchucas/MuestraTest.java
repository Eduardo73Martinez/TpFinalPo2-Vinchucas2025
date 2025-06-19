package web_vinchucas;
import verificacion.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ZonaOrganizanizacionUbicacion.Ubicacion;

class MuestraTest {
	
	Muestra miMuestra;
	
	Usuario miUsuario;
	TipoVinchuca miVinchuca;
	Foto miFoto;
	Ubicacion miUbicacion;
	Verificacion nuevaVerificacion;
	
	double distancia;
	
	Usuario otroUsuario;
		
	Web miWeb;
	
	Muestra muestra_1;
	Muestra muestra_2;
	Muestra muestra_3;
	Muestra muestra_4;
	
	List<Muestra> listaDeMuestras;
	List<Muestra> listaConMuestraCercana;
	List<Muestra> listaSinMuestraCercana;
			
	Ubicacion ubicacion_1;
	Ubicacion ubicacion_2;
	Ubicacion ubicacion_3;
	
	List<Ubicacion> listaDeUbicaciones;
	List<Ubicacion> miLista;
	List<Ubicacion> misUbicacionesCercanas;
	List<Ubicacion> listaConUbicacionCercana;
	List<Ubicacion> listaSinUbicacionCercana;
	
	Map<Ubicacion, List<Muestra>> mapUM;
	Map<Ubicacion, List<Muestra>> miMap;
	
	Opinion opinion_1;
	Opinion opinion_2;
	
	List<Opinion> listaDeOpiniones;
	
	IOpinable resultadoVerificacion;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//DOC:
		miUsuario = mock(Usuario.class);
		miVinchuca = mock(TipoVinchuca.class);
		miFoto = mock(Foto.class);
		miUbicacion = mock(Ubicacion.class);
		
		when(miUsuario.getId()).thenReturn(1l);
		
		//SUT:
		miMuestra = new Muestra(miUsuario, miVinchuca, miFoto, miUbicacion);
		
		
		//DOC: 
		distancia = 15d;
		
		otroUsuario = mock(Usuario.class);
		
		miWeb = mock(Web.class);
		
		muestra_1 = mock(Muestra.class);
		muestra_2 = mock(Muestra.class);
		muestra_3 = mock(Muestra.class);
		muestra_4 = mock(Muestra.class);
		
		ubicacion_1 = mock(Ubicacion.class);
		ubicacion_2 = mock(Ubicacion.class);
		ubicacion_3 = mock(Ubicacion.class);
		
		opinion_1 = mock(Opinion.class);
		opinion_2 = mock(Opinion.class);
		
		nuevaVerificacion = mock(Verificacion.class);
		resultadoVerificacion = mock(IOpinable.class);
		
		listaDeMuestras = new ArrayList<Muestra>();
		listaDeMuestras.add(muestra_1);
		listaDeMuestras.add(muestra_2);
		listaDeMuestras.add(muestra_3);
		listaDeMuestras.add(muestra_4);
		
		
		listaConMuestraCercana = new ArrayList<Muestra>();
		listaConMuestraCercana.add(muestra_1);		
		
		listaSinMuestraCercana = new ArrayList<Muestra>();
		
		listaDeUbicaciones = new ArrayList<Ubicacion>();
		listaDeUbicaciones.add(ubicacion_1);
		listaDeUbicaciones.add(ubicacion_2);
		listaDeUbicaciones.add(ubicacion_3);
		
		misUbicacionesCercanas = new ArrayList<Ubicacion>();
		misUbicacionesCercanas.add(ubicacion_1);
		misUbicacionesCercanas.add(ubicacion_3);
		
		listaConUbicacionCercana = new ArrayList<Ubicacion>();
		listaConUbicacionCercana.add(ubicacion_1);		
		
		listaSinUbicacionCercana = new ArrayList<Ubicacion>();
		
		mapUM = new HashMap<Ubicacion,List<Muestra>>();
		mapUM.put(ubicacion_1, Arrays.asList(muestra_1));
		mapUM.put(ubicacion_2, Arrays.asList(muestra_2));
		mapUM.put(ubicacion_3, Arrays.asList(muestra_3,muestra_4));
		
		listaDeOpiniones = new ArrayList<Opinion>();
		listaDeOpiniones.add(opinion_1);
		listaDeOpiniones.add(opinion_2);
		when(otroUsuario.getId()).thenReturn(2l);
	}

	@Test
	void testGetFoto() {
		assertEquals(miFoto,miMuestra.getFoto());
	}
	
	@Test
	void testGetVinchuca() {
		assertEquals(miVinchuca,miMuestra.getVinchuca());
	}
	
	@Test
	void testGetFechaCreacion() {
		assertEquals(LocalDate.now(),miMuestra.getFechaCreacion());
	}
	
	@Test
	void testGetPersona() {
		assertEquals(miUsuario,miMuestra.getPersona());
	}
	
	@Test
	void testGetUbicacion() {
		assertEquals(miUbicacion,miMuestra.getUbicacion());
	}
	
	@Test
	void testGetVerificacion() {
		assertTrue(miMuestra.getVerificacion() instanceof OpinionBasicos);
	}

	@Test
	void testGetOpiniones() {
		//Exercise
		List<Opinion> opiniones = miMuestra.getOpiniones();
		//Verify
		assertTrue(opiniones.size()==1);
		assertEquals(opiniones.getFirst().getValorOpinion().getValor(), miVinchuca.getValor());
	}
	
	@Test
	void testGetFechaUltimaVotacion() {
		assertEquals(miMuestra.getFechaUltimaVotacion(), LocalDate.now());
	}
	
	@Test
	void testAgregarOpinion() {
		
		//Exercise
		miMuestra.agregarOpinion(opinion_1);
		miMuestra.agregarOpinion(opinion_2);
		
		//Verify
		assertTrue(miMuestra.getOpiniones().size()==3);
		assertEquals(miMuestra.getOpiniones().getFirst().getValorOpinion().getValor(),miMuestra.getVinchuca().getValor());
		assertTrue(miMuestra.getOpiniones().contains(opinion_1));
		assertTrue(miMuestra.getOpiniones().contains(opinion_2));
	}
	
    @Test
    void testSetVerificacion() {
    	//Exercise    	
    	miMuestra.setVerificacion(nuevaVerificacion);
    	//Verify
    	assertEquals(miMuestra.estado,nuevaVerificacion);
    }

    
	@Test
	void testActualizarVinchuca() {
		//Exercise
		miMuestra.actualizarVinchuca(resultadoVerificacion);
		
		//Verify
		assertEquals(miMuestra.getVinchuca(),resultadoVerificacion);
	}
	
	@Test
	void testMuestrasPorUbicacion() {
		
		//SetUp
		when(miWeb.todasLasMuestras()).thenReturn(listaDeMuestras);
		when(muestra_1.getUbicacion()).thenReturn(ubicacion_1);
		when(muestra_2.getUbicacion()).thenReturn(ubicacion_2);
		when(muestra_3.getUbicacion()).thenReturn(ubicacion_3);
		when(muestra_4.getUbicacion()).thenReturn(ubicacion_3);
				
		//Exercise
		miMap = miMuestra.muestrasPorUbicacion(miWeb);
		
		//Verify
		verify(miWeb).todasLasMuestras();
		verify(muestra_1).getUbicacion();
		verify(muestra_2).getUbicacion();
		verify(muestra_3).getUbicacion();
		verify(muestra_4).getUbicacion();
		assertTrue(miMap.size()==3);
		assertTrue(miMap.get(ubicacion_1).contains(muestra_1));
		assertTrue(miMap.get(ubicacion_2).contains(muestra_2));
		assertTrue(miMap.get(ubicacion_3).contains(muestra_3));
		assertTrue(miMap.get(ubicacion_3).contains(muestra_4));
	}
	
    @Test
	void testTodasLasUbicaciones() {
    	
		//Exercise
		miLista = miMuestra.todasLasUbicaciones(mapUM);
		
		//verify
		assertTrue(miLista.contains(ubicacion_1));
		assertTrue(miLista.contains(ubicacion_2));
		assertTrue(miLista.contains(ubicacion_3));
	}
		
	@Test
	void testObtenerMuestrasCercanas() {
		
		//Exercise
		List<Muestra> muestrasCercanas = miMuestra.obtenerMuestrasCercanas(misUbicacionesCercanas, mapUM);
		
		//Verify
		assertEquals(muestrasCercanas.size(),3);
		assertTrue(muestrasCercanas.contains(muestra_1));
		assertTrue(muestrasCercanas.contains(muestra_3));
		assertTrue(muestrasCercanas.contains(muestra_4));
		assertFalse(muestrasCercanas.contains(muestra_2));
	}
	
	@Test
	void testMuestrasCercanasRecibeListaConMuestraCercana() {
		//SetUp
		when(miWeb.todasLasMuestras()).thenReturn(listaConMuestraCercana);
		when(muestra_1.getUbicacion()).thenReturn(ubicacion_1);
		when(miUbicacion.ubicacionesCercanas(listaConUbicacionCercana, distancia)).thenReturn(listaConUbicacionCercana);
		
		//Exercise
		List<Muestra> resultado = miMuestra.muestrasCercanas(miWeb,distancia);
		
		//Verify
		assertTrue(resultado.contains(muestra_1));
	}
	
	@Test
	void testMuestrasCercanasRecibeListaSinMuestraCercana() {
		//SetUp
		when(miWeb.todasLasMuestras()).thenReturn(listaConMuestraCercana);
		when(muestra_1.getUbicacion()).thenReturn(ubicacion_1);
		when(miUbicacion.ubicacionesCercanas(listaConUbicacionCercana, distancia)).thenReturn(listaSinUbicacionCercana);
		
		//Exercise
		List<Muestra> resultado = miMuestra.muestrasCercanas(miWeb,distancia);
		
		//Verify
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	void testResultadoActual() {
		//SetUp
		when(nuevaVerificacion.resultadoActual(miMuestra)).thenReturn("Resultado Actual");
		miMuestra.setVerificacion(nuevaVerificacion);
		
		//Exercise
		String resultado = miMuestra.resultadoActual();
		
		//Verify
		verify(nuevaVerificacion).resultadoActual(miMuestra);
		assertEquals(resultado, "Resultado Actual");
		}
	
	
	@Test 
	void testPuedeOpinar() {
		//Exercise
		Boolean resultado = miMuestra.puedeOpinar(otroUsuario);
		
		//Verify
		assertEquals(resultado,true);
	}

	@Test 
	void testNoPuedeOpinar() {
		//Exercise
		Boolean resultado = miMuestra.puedeOpinar(miUsuario);
		
		//Verify
		assertEquals(resultado,false);
	}
    	
}
