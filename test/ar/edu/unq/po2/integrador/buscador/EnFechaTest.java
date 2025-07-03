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


class EnFechaTest {

	
	//doc:
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	
	EstrategiaFecha estrategia = mock(EstrategiaFecha.class);
	
	//sut:
	EnFecha filtro;
	
	//setUp:
	List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
	
	@BeforeEach
	void setUp () {
		
		//sut:
		filtro =  new EnFecha( LocalDate.of(2000,11,26), estrategia);
		
		//setUp:
		when (estrategia.fechaDeMuestraParaEsteTipo(muestra1Stub)).thenReturn (LocalDate.of(2000,11,26));
		when (estrategia.fechaDeMuestraParaEsteTipo(muestra2Stub)).thenReturn (LocalDate.of(2001,11,26));
		when (estrategia.fechaDeMuestraParaEsteTipo(muestra3Stub)).thenReturn (LocalDate.of(2000,01,01));
		
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);
		
	}
	@Test
	void buscarTest() {
		//exercise:
		List <Muestra> listaFinal = filtro.buscar(listaDeMuestras);
		//solo debe ser la muestra 1 al ser la unica que es igual en fecha de ultima votacion a la fecha ingresada
		//verify:
		assertTrue(listaFinal.contains(muestra1Stub));
		assertFalse(listaFinal.contains(muestra2Stub));
		assertFalse(listaFinal.contains(muestra3Stub));
		
	}


}
