package ar.edu.unq.po2.integrador.buscador;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.verificacion.*;
import ar.edu.unq.po2.integrador.webMuestraUsuario.*;





class SoloVotadasTest {

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
	SoloVotadas filtro;
	
	@BeforeEach
	void setUp () {
		//sut:
		filtro = new SoloVotadas ();
		
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
		listaFinal.add(muestra2Stub);
		listaFinal.add(muestra1Stub);
		//verify:
		assertTrue(filtro.buscar(listaDeMuestras).containsAll(listaFinal) && listaFinal.containsAll(filtro.buscar(listaDeMuestras)));
	}



}
