package web_vinchucas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

class UbicacionTest {
	private Ubicacion ubicacion;
	private Muestra muestra;
	private ArrayList<Muestra> arrayMuestras;

	@BeforeEach
	void setUp() throws Exception {
		ubicacion = new Ubicacion(45.9, 45.5);
		muestra = mock(Muestra.class);
		
	}
	@Test
	void testUbicacion() {
		fail("Not yet implemented");
	}

	@Test
	void testDistanciaEntreDosUbicaciones() {
		fail("Not yet implemented");
	}
	@Test
	void testListaUbicacionesConDistanciaMenorA() {
		fail("Not yet implemented");
	}
	
	@Test
	void testListaMuestrasObtenidasAMenosDeTalDistancia() {
		fail("Not yet implemented");
	}
	
	//setters y getters 
	
	@Test
	void testGetLatitud() {
		fail("Not yet implemented");
	}
	@Test
	void testGetLongitud() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSetLatitud() {
		fail("Not yet implemented");
	}
	@Test
	void testSetLongitud() {
		fail("Not yet implemented");
	}





}
