package web_vinchucas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MuestraTest {
	
	Muestra miMuestra;
	
	Usuario miUsuario;
	Foto miFoto;
	Ubicación miUbicación;
	
	Web miWeb;
	
	Muestra muestra_1;
	Muestra muestra_2;
	Muestra muestra_3;
	
	List<Muestra> listaDeMuestras;
	
	Ubicación ubicación_1;
	Ubicación ubicación_2;
	Ubicación ubicación_3;
	
	Map<Ubicación, Muestra> mapUM;
	Map<Ubicación, Muestra> miMap;
	
	
	@BeforeEach
	void setUp() throws Exception {
		miUsuario = new Usuario();
		miFoto = new Foto();
		miUbicación = new Ubicación();
		
		miMuestra = new Muestra(miUsuario, miFoto, miUbicación);
		
		miWeb = mock(Web.class);
		
		muestra_1 = mock(Muestra.class);
		muestra_2 = mock(Muestra.class);
		muestra_3 = mock(Muestra.class);
		
		listaDeMuestras = new ArrayList<Muestra>();
		listaDeMuestras.add(muestra_1);
		listaDeMuestras.add(muestra_2);
		listaDeMuestras.add(muestra_3);
		
		mapUM = new HashMap<Ubicación,Muestra>();
		mapUM.put(ubicación_1, muestra_1);
		mapUM.put(ubicación_2, muestra_2);
		mapUM.put(ubicación_3, muestra_3);
		
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
		assertEquals(miUbicación,miMuestra.getUbicacion());
	}
	
	@Test
	void testMuestrasPorUbicacion() {
		//SetUp
		when(miWeb.todasLasMuestras()).thenReturn(listaDeMuestras);
		when(muestra_1.getUbicacion()).thenReturn(ubicación_1);
		when(muestra_2.getUbicacion()).thenReturn(ubicación_2);
		when(muestra_3.getUbicacion()).thenReturn(ubicación_3);
		
		//Excercise
		miMap = miMuestra.muestrasPorUbicacion(miWeb);
		
		//Verify
		verify(miWeb).todasLasMuestras();
		verify(muestra_1).getUbicacion();
		verify(muestra_2).getUbicacion();
		verify(muestra_3).getUbicacion();
		
		assertEquals(miMap, mapUM);
	}
	
	

}
