package web_vinchucas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerificadaTest {

	Muestra muestraMock = mock(Muestra.class);
	Usuario basicoMock = mock (Usuario.class);
	Usuario especialistaMock = mock (Usuario.class); //como especialista y experto responden lo mismo
													 //en esBasico() no es necesario probar con ambos
	Usuario Mock = mock (Usuario.class);
	Verificada verificada = new Verificada (muestraMock);
	@BeforeEach
	void setUp () {
		verificada = new NoVerificada (muestraMock); //en realidad no es necesario hacer setUp en
													   //esta clase especifica, pero para no cambiar 
													   //tanto el test si la cambio aun asi lo hago
		when (basicoMock.esBasico()).thenReturn (true);
		when (especialistaMock.esBasico()).thenReturn (false);
	}
	@Test
	void esVerificadaTest() {
		assertEquals(verificada.esVerificada(),true);
	}
	@Test
	void puedeVotarTest(){
		assertEquals(verificada.puedeVotar(basicoMock),false);
		assertEquals(verificada.puedeVotar(especialistaMock),false);
	}
	@Test
	void verificarTest() {
		verificada.verificar();
		assertEquals(verificada.esVerificada(),true);
	}
}