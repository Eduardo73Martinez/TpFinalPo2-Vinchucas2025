package buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web_vinchucas.Muestra;
import web_vinchucas.Web;

class CreadoAntesDeTest {

	//doc:
	Web webStub = mock (Web.class);
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	
	//sut:
	CreadoAntesDe filtro;
	
	@BeforeEach
	void setUp () {
		
		//sut:
		filtro = new CreadoAntesDe(webStub, LocalDate.of(2000,11,26));
		
		//setUp:
		
		when (muestra1Stub.getFechaCreacion()).thenReturn (LocalDate.of(2000,11,26));
		when (muestra2Stub.getFechaCreacion()).thenReturn (LocalDate.of(2001,11,26));
		when (muestra3Stub.getFechaCreacion()).thenReturn (LocalDate.of(2000,01,01));
		List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);
		when (webStub.todasLasMuestras()).thenReturn (listaDeMuestras);
		
	}
	@Test
	void buscarTest() {
		//setUp:
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra3Stub); //solo debe ser la lista 2 al ser la unica que va antes
		//verify:
		assertTrue(filtro.buscar().containsAll(listaFinal) && listaFinal.containsAll(filtro.buscar()));
	
		
	}
}
