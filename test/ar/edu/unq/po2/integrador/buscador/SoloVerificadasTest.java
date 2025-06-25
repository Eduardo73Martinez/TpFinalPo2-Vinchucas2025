package ar.edu.unq.po2.integrador.buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;

import ar.edu.unq.po2.integrador.verificacion.*;
import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

class SoloVerificadasTest {

	//doc:

	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	OpinionBasicos opinionBasicosDummy = mock (OpinionBasicos.class);
	OpinionExpertos opinionExpertosDummy = mock (OpinionExpertos.class);
	Verificada verificadaDummy = mock (Verificada.class);
	
	//setUp:
	List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
	
	//sut:
	SoloVerificadas filtro ;
	
	@BeforeEach
	void setUp () {
		
		//sut:
		filtro = new SoloVerificadas ();
		//setUp:
	
		
		when (muestra1Stub.getVerificacion()).thenReturn (opinionBasicosDummy);
		when (muestra2Stub.getVerificacion()).thenReturn (opinionExpertosDummy);
		when (muestra3Stub.getVerificacion()).thenReturn (verificadaDummy);
		
		
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);

	}
	@Test
	void buscarTest() {
		
		//setUp:
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra3Stub);
		//verify:
		assertTrue(filtro.buscar(listaDeMuestras).containsAll(listaFinal) && listaFinal.containsAll(filtro.buscar(listaDeMuestras)));
		
	}

	@Test
	void esDelTipoEsperadoTest() {
		//verify:
		assertEquals(filtro.esDelTipoEsperado(muestra1Stub),false);
		assertEquals(filtro.esDelTipoEsperado(muestra2Stub),false);
		assertEquals(filtro.esDelTipoEsperado(muestra3Stub),true);
		
	}
}
