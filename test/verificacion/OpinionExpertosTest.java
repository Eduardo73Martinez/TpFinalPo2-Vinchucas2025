package verificacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpinionExpertosTest {

	Muestra muestraMock = mock(Muestra.class);
	Usuario basicoMock = mock (Usuario.class);
	Usuario especialistaMock = mock (Usuario.class); //como especialista y experto responden lo mismo
													 //en esBasico() no es necesario probar con ambos
	Usuario Mock = mock (Usuario.class);
	Verificada verificada = new Verificada (muestraMock);
	List<Opinion> listaDeOpinionesQueCambianEstado = new ArrayList<Opinion>();
	List<Opinion> listaDeOpinionesQueNoCambianEstado = new ArrayList<Opinion>();
	@BeforeEach
	void setUp () {
		verificada = new Verificada (muestraMock); //en realidad no es necesario hacer setUp en
													   //esta clase especifica, pero para no cambiar 
													   //tanto el test si la cambio aun asi lo hago
		when (basicoMock.esBasico()).thenReturn (true);
		when (especialistaMock.esBasico()).thenReturn (false);
		
		
		
	}
	@Test
	void esVerificadaTest() {
		assertEquals(verificada.esVerificada(),false);
	}
	@Test
	void puedeVotarTest(){
		assertEquals(verificada.puedeVotar(basicoMock),false);
		assertEquals(verificada.puedeVotar(especialistaMock),true);
	}
	@Test
	void verificarTestCambiaEstado() {
		when (muestraMock.getOpiniones().thenReturn ())
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a una conclusion
		verificada.verificar();
		assertEquals(verificada.esVerificada(),true);
	}
	@Test
	void verificarTestCambiaEstado() {
		when (muestraMock.getOpiniones().thenReturn ())
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a un empate
		//ya que en caso de empate no cambia el estado
		verificada.verificar();
		assertEquals(verificada.esVerificada(),true);
	}
}
