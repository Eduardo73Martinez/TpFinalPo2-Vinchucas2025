package buscador;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;
import web_vinchucas.*;


class AndTest {

	//doc:
	Filtro filtro1Stub = mock(Filtro.class);
	Filtro filtro2Stub = mock (Filtro.class);
	Muestra muestra1Dummy = mock (Muestra.class);
	Muestra muestra2Dummy = mock (Muestra.class);
	Muestra muestra3Dummy = mock (Muestra.class);
	Web webDummy = mock (Web.class);
	
	//sut:
	And and ;
	
	@BeforeEach
	void setUp () {
		//sut:
		and = new And (filtro1Stub,filtro2Stub,webDummy);
		
		//setUp:
		List <Muestra> listaFiltrada1 = new ArrayList<Muestra>();
		List <Muestra> listaFiltrada2 = new ArrayList<Muestra>();
		listaFiltrada1.add(muestra1Dummy);
		listaFiltrada2.add(muestra2Dummy);
		listaFiltrada1.add(muestra3Dummy);
		listaFiltrada2.add(muestra3Dummy);
		when (filtro1Stub.buscar()).thenReturn(listaFiltrada1);
		when (filtro2Stub.buscar()).thenReturn(listaFiltrada2);
		//al hacer un or de listas deberia quedar lo que este en ambas listas que seria la muestra 3
	}
	@Test
	void buscarTest() {
		//setUp:
		List <Muestra> listaFinal = ne w ArrayList<Muestra>();
		listaFinal.add(muestra3Dummy);
		//verify:
		assertTrue(and.buscar().containsAll(listaFinal) && listaFinal.containsAll(and.buscar()));
		
	}
}
