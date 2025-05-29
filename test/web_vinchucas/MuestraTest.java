package web_vinchucas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {
	
	Muestra miMuestra;
	
	Usuario miUsuario;
	Foto miFoto;
	Ubicacion miUbicacion;
	
	float distancia;
	
	Web miWeb;
	
	Muestra muestra_1;
	Muestra muestra_2;
	Muestra muestra_3;
	
	List<Muestra> listaDeMuestras;
	List<Muestra> misMuestrasCercanas;
	
	
	Ubicacion ubicacion_1;
	Ubicacion ubicacion_2;
	Ubicacion ubicacion_3;
	
	List<Ubicacion> listaDeUbicaciones;
	List<Ubicacion> miLista;
	List<Ubicacion> misUbicacionesCercanas;
	
	
	Map<Ubicacion, Muestra> mapUM;
	Map<Ubicacion, Muestra> miMap;
	
	
	@BeforeEach
	void setUp() throws Exception {
		miUsuario = mock(Usuario.class);
		miFoto = mock(Foto.class);
		miUbicacion = mock(Ubicacion.class);
		
		miMuestra = new Muestra(miUsuario, miFoto, miUbicacion);
		
		distancia = 15;
		
		miWeb = mock(Web.class);
		
		muestra_1 = mock(Muestra.class);
		muestra_2 = mock(Muestra.class);
		muestra_3 = mock(Muestra.class);
		
		listaDeMuestras = new ArrayList<Muestra>();
		listaDeMuestras.add(muestra_1);
		listaDeMuestras.add(muestra_2);
		listaDeMuestras.add(muestra_3);
		
		misMuestrasCercanas = new ArrayList<Muestra>();
		misMuestrasCercanas.add(muestra_1);
		misMuestrasCercanas.add(muestra_3);
		
		listaDeUbicaciones = new ArrayList<Ubicacion>();
		listaDeUbicaciones.add(ubicacion_1);
		listaDeUbicaciones.add(ubicacion_2);
		listaDeUbicaciones.add(ubicacion_3);
		
		misUbicacionesCercanas = new ArrayList<Ubicacion>();
		misUbicacionesCercanas.add(ubicacion_1);
		misUbicacionesCercanas.add(ubicacion_3);
		
		mapUM = new HashMap<Ubicacion,Muestra>();
		mapUM.put(ubicacion_1, muestra_1);
		mapUM.put(ubicacion_2, muestra_2);
		mapUM.put(ubicacion_3, muestra_3);
		
		when(miWeb.todasLasMuestras()).thenReturn(listaDeMuestras);
		
		when(muestra_1.getUbicacion()).thenReturn(ubicacion_1);
		when(muestra_2.getUbicacion()).thenReturn(ubicacion_2);
		when(muestra_3.getUbicacion()).thenReturn(ubicacion_3);
		
		when(miUbicacion.ubicacionesCercanas(listaDeUbicaciones,distancia)).thenReturn(misUbicacionesCercanas);
		
	}

	@Test
	void testGetFoto() {
		assertEquals(miFoto,miMuestra.getFoto());
	}
	
	@Test
	void testGetPersona() {
		assertEquals(miUsuario,miMuestra.getPersona());
	}
	
	@Test
	void testGetUbicacion() {
		assertEquals(miUbicacion,miMuestra.getUbicacion());
	}
	
    /*
    @Test
	void testTodasLasUbicaciones() {
		//Exercise
		miLista = miMuestra.todasLasUbicaciones(mapUM);
		
		//verify
		assertEquals (miLista,listaDeUbicaciones);		
	}
	
	
	@Test
	void testMuestrasPorUbicacion() {
		
		//Exercise
		miMap = miMuestra.muestrasPorUbicacion(miWeb);
		
		//Verify
		verify(miWeb).todasLasMuestras();
		verify(muestra_1).getUbicacion();
		verify(muestra_2).getUbicacion();
		verify(muestra_3).getUbicacion();
		
		assertEquals(miMap, mapUM);
	}
	
	void testMuestrasCercanas() {
		
		//Exercise
		List<Muestra> resultado = miMuestra.muestrasCercanas(miWeb, distancia);
		
		//Verify
		assertEquals (misUbicacionesCercanas, resultado);
	}
	
     */
	
	
}
