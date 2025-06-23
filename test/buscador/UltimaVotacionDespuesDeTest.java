package buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.*;
import web_vinchucas.*;

class UltimaVotacionDespuesDeTest {

	//doc:
	Web webStub = mock (Web.class);
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	
	//setUp:
	List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
		
		
	//sut:
	UltimaVotacionDespuesDe filtro;
	@BeforeEach
	void setUp () {
		
		//sut:
		
		filtro = new UltimaVotacionDespuesDe( LocalDate.of(2000,11,26));
		
		//setUp:
		when (muestra1Stub.getFechaUltimaVotacion()).thenReturn (LocalDate.of(2000,11,26));
		when (muestra2Stub.getFechaUltimaVotacion()).thenReturn (LocalDate.of(2001,11,26));
		when (muestra3Stub.getFechaUltimaVotacion()).thenReturn (LocalDate.of(2000,01,01));
		
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);
		
		
	}
	@Test
	void buscarTest() {
		//setUp:
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra2Stub); //solo debe ser la lista 2 al ser la unica que va despues
		//verify:
		assertTrue(filtro.buscar(listaDeMuestras).containsAll(listaFinal) && listaFinal.containsAll(filtro.buscar(listaDeMuestras)));
		
	}

}
