package ar.edu.unq.po2.integrador.buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;


public class FechaDeCreacionTest {
	
	//Sut:
	FechaDeCreacion estrategiaFecha;
	
	//Doc
	Muestra muestraStub;
	
	LocalDate fecha;
	
	@BeforeEach
	void setUp() throws Exception{
		//SetUp
		estrategiaFecha = new FechaDeCreacion();
		
		muestraStub = mock(Muestra.class);
		
		fecha = LocalDate.of(2025, 7, 3);
		
		when(muestraStub.getFechaCreacion()).thenReturn(fecha);
	}
	
	@Test
	void testFechaDeMuestraParaEsteTipo() {
		//Exercise
		LocalDate fechaConsultada = estrategiaFecha.fechaDeMuestraParaEsteTipo(muestraStub);
		
		//Verify
		assertTrue(fechaConsultada.isEqual(fecha));
	}
	
	
}
