package verificacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web_vinchucas.Muestra;
import web_vinchucas.Nivel;
import web_vinchucas.TipoOpinion;
import web_vinchucas.TipoVinchuca;
import web_vinchucas.Usuario;



public class VerificadaTest {
	
	Muestra muestraDummy = mock(Muestra.class);
	Usuario basicoStub = mock(Usuario.class);
	Usuario especialistaStub = mock(Usuario.class); //como especialista y experto responden lo mismo
													 //en esBasico() no es necesario probar con ambos
	
	
	Verificada verificada = new Verificada (TipoVinchuca.VINCHUCA_INFESTANS);
	
	//creo los mock y la verificada a testear
	@BeforeEach
	void setUp () {
		verificada = new Verificada (TipoVinchuca.VINCHUCA_INFESTANS); //en realidad no es necesario hacer setUp en
													   //esta clase especifica, pero para no cambiar 
													   //tanto el test si la cambio aun asi lo hago
		
		
		when (basicoStub.getNivel()).thenReturn (Nivel.BASICO);
	
		
	}
	@Test
	void esVerificadaTest() {
		assertEquals(verificada.esVerificada(),true);
	}
	void esVotadaTest() {
		assertEquals (verificada.esVotada(),true);
	}
	@Test
	void puedeVotarTest(){
		assertEquals(verificada.puedeVotar(basicoStub),false);
		assertEquals(verificada.puedeVotar(especialistaStub),false);
	}
	@Test
	void verificarTest() {
		verificada.verificar(muestraDummy);
		assertEquals(verificada.esVerificada(),true);
	}
	@Test
	void resultadoActualTest() {
		
		assertEquals(verificada.resultadoActual(muestraDummy),"Vinchuca Infestans");
	}

}
