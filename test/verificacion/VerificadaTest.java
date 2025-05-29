package verificacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class VerificadaTest {
	Muestra muestraMock = mock(Muestra.class);
	Usuario basicoMock = mock (Usuario.class);
	Usuario especialistaMock = mock (Usuario.class); //como especialista y experto responden lo mismo
													 //en esBasico() no es necesario probar con ambos
	Usuario Mock = mock (Usuario.class);
	Verificada verificada = new Verificada (muestraMock,TipoOpinion INFESTANS);
	@BeforeEach
	void setUp () {
		verificada = new Verificada (muestraMock,TipoOpinion INFESTANS); //en realidad no es necesario hacer setUp en
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
