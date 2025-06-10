package buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;
import verificacion.*;
import web_vinchucas.*;



import static org.junit.jupiter.api.Assertions.assertEquals;

class SoloVerificadasTest {

	Web webStub = mock (Web.class);
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	OpinionBasicos opinionBasicosStub = mock (OpinionBasicos.class);
	OpinionExpertos opinionExpertosStub = mock (OpinionExpertos.class);
	Verificada verificadaStub = mock (Verificada.class);
	
	SoloVerificadas filtro = new SoloVerificadas (webStub);
	
	@BeforeEach
	void setUp () {
		
		when (opinionBasicosStub.esVerificada()).thenReturn (false);
		when (opinionExpertosStub.esVerificada()).thenReturn (false);
		when (verificadaStub.esVerificada()).thenReturn (false);
		
		when (muestra1Stub.getVerificacion()).thenReturn (opinionBasicosStub);
		when (muestra2Stub.getVerificacion()).thenReturn (opinionExpertosStub);
		when (muestra3Stub.getVerificacion()).thenReturn (verificadaStub);
		
		List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);
		when (webStub.todasLasMuestras()).thenReturn(listaDeMuestras);
		
	}
	@Test
	void buscarTest() {
		
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra3Stub);
		assertEquals(filtro.buscar(),listaFinal);
	}

	@Test
	void esDelTipoEsperadoTest() {
		assertEquals(filtro.esDelTipoEsperado(muestra1Stub),false);
		assertEquals(filtro.esDelTipoEsperado(muestra2Stub),false);
		assertEquals(filtro.esDelTipoEsperado(muestra3Stub),true);
	}
}
