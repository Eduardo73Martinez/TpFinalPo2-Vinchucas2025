package ar.edu.unq.po2.integrador.webMuestraUsuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TipoOpinionTest {

	TipoOpinion miOpinion;
	
	@BeforeEach
	void setUp() throws Exception{
		miOpinion = TipoOpinion.PHTIA_CHINCHE;
	}
	
	@Test
	void testGetValor() {
		//Exercise
		String respuesta = miOpinion.getValor();
		assertEquals(respuesta, "Phtia-Chinche");
	}
}
