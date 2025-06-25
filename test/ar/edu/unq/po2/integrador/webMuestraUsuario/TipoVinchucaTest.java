package ar.edu.unq.po2.integrador.webMuestraUsuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TipoVinchucaTest {

	TipoVinchuca miVinchuca;
	
	@BeforeEach
	void setUp() throws Exception{
		miVinchuca = TipoVinchuca.VINCHUCA_GUASAYANA;
	}
	
	@Test
	void testGetValor() {
		//Exercise
		String respuesta = miVinchuca.getValor();
		assertEquals(respuesta, "Vinchuca Guasayana");
	}
}
