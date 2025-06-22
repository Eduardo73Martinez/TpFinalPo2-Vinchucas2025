package buscador;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;

import web_vinchucas.*;




public class OrTest {

	//doc:
	Filtro filtro1Stub = mock(Filtro.class);
	Filtro filtro2Stub = mock (Filtro.class);
	Muestra muestra1Dummy = mock (Muestra.class);
	Muestra muestra2Dummy = mock (Muestra.class);
	Muestra muestra3Dummy = mock (Muestra.class);

	//setUp:
		List <Muestra> listaDeTodasLasMuestras = new ArrayList<Muestra>();
	
	//sut:
	Or or;
	
	@BeforeEach
	void setUp () {
		//sut:
		or = new Or (filtro1Stub,filtro2Stub);
		
		//setUp:
		List <Muestra> listaFiltrada1 = new ArrayList<Muestra>();
		List <Muestra> listaFiltrada2 = new ArrayList<Muestra>();
		listaFiltrada1.add(muestra1Dummy);
		listaFiltrada2.add(muestra2Dummy);
		listaFiltrada1.add(muestra3Dummy);
		listaFiltrada2.add(muestra3Dummy);
		when ((filtro1Stub.buscar(listaDeTodasLasMuestras ))).thenReturn (listaFiltrada1);
		when (filtro2Stub.buscar(listaDeTodasLasMuestras )).thenReturn (listaFiltrada2);
		//al hacer un or de listas deberia quedar lo de ambas listas que seria las 3 muestras
	}
	@Test
	void buscarTest() {
		
		//setUp:
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra1Dummy);
		listaFinal.add(muestra2Dummy);
		listaFinal.add(muestra3Dummy);
		//verify:
		assertTrue(or.buscar(listaDeTodasLasMuestras ).containsAll(listaFinal) && listaFinal.containsAll(or.buscar(listaDeTodasLasMuestras )));
	}
	
	
	
}


