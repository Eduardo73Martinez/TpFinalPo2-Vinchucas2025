package ar.edu.unq.po2.integrador.buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;


class CreadoEnTest {

	
	//doc:
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	
	//sut:
	CreadoEn filtro;
	
	//setUp:
	List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
	
	@BeforeEach
	void setUp () {
		
		//sut:
		filtro =  new CreadoEn( LocalDate.of(2000,11,26));
		
		//setUp:
		when (muestra1Stub.getFechaCreacion()).thenReturn (LocalDate.of(2000,11,26));
		when (muestra2Stub.getFechaCreacion()).thenReturn (LocalDate.of(2001,11,26));
		when (muestra3Stub.getFechaCreacion()).thenReturn (LocalDate.of(2000,01,01));
		
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);
		
	}
	@Test
	void buscarTest() {
		//setUp:
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra1Stub); //solo debe ser la muestra 1 al ser la unica que es igual en fecha de ultima votacion a la fecha ingresada
		//verify:
		assertTrue(filtro.buscar(listaDeMuestras).containsAll(listaFinal) && listaFinal.containsAll(filtro.buscar(listaDeMuestras)));
		
	}


}
