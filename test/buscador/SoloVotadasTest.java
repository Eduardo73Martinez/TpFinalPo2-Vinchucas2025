package buscador;
import web_vinchucas.*;
import verificacion.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





class SoloVotadasTest {

	//doc:
	Web webStub = mock (Web.class);
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	OpinionBasicos opinionBasicosDummy = mock (OpinionBasicos.class);
	OpinionExpertos opinionExpertosDummy = mock (OpinionExpertos.class);
	Verificada verificadaDummy = mock (Verificada.class);
	 
	//sut:
	SoloVotadas filtro = new SoloVotadas (webStub);
	
	@BeforeEach
	void setUp () {
		//sut:
		filtro = new SoloVotadas (webStub);
		
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
		listaFinal.add(muestra2Stub);
		listaFinal.add(muestra1Stub);
		//verify:
		assertTrue(filtro.buscar().containsAll(listaFinal) && listaFinal.containsAll(filtro.buscar()));
	}

	@Test
	void esDelTipoEsperadoTest() {
		//verify:
		assertEquals(filtro.esDelTipoEsperado(muestra1Stub),true);
		assertEquals(filtro.esDelTipoEsperado(muestra2Stub),true);
		assertEquals(filtro.esDelTipoEsperado(muestra3Stub),false);
	}

}
