package buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;
import verificacion.*;
import web_vinchucas.*;

class SoloVerificadasTest {

	//doc:
	Web webStub = mock (Web.class);
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	OpinionBasicos opinionBasicosDummy = mock (OpinionBasicos.class);
	OpinionExpertos opinionExpertosDummy = mock (OpinionExpertos.class);
	Verificada verificadaDummy = mock (Verificada.class);
	
	//sut:
	SoloVerificadas filtro ;
	
	@BeforeEach
	void setUp () {
		
		//sut:
		filtro = new SoloVerificadas (webStub);
		//setUp:
	
		
		when (muestra1Stub.getVerificacion()).thenReturn (opinionBasicosDummy);
		when (muestra2Stub.getVerificacion()).thenReturn (opinionExpertosDummy);
		when (muestra3Stub.getVerificacion()).thenReturn (verificadaDummy);
		
		List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);
		when (webStub.todasLasMuestras()).thenReturn(listaDeMuestras);
		
	}
	@Test
	void buscarTest() {
		
		//setUp:
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra3Stub);
		//verify:
		assertTrue(filtro.buscar().containsAll(listaFinal) && listaFinal.containsAll(filtro.buscar()));
		
	}

	@Test
	void esDelTipoEsperadoTest() {
		//verify:
		assertEquals(filtro.esDelTipoEsperado(muestra1Stub),false);
		assertEquals(filtro.esDelTipoEsperado(muestra2Stub),false);
		assertEquals(filtro.esDelTipoEsperado(muestra3Stub),true);
		
	}
}
