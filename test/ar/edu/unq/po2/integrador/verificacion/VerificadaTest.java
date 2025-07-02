package ar.edu.unq.po2.integrador.verificacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;



public class VerificadaTest {
	//doc:
	Muestra muestraDummy = mock(Muestra.class);
	Usuario basicoStub = mock(Usuario.class);
	Usuario especialistaStub = mock(Usuario.class); //como especialista y experto responden lo mismo
													 //en esBasico() no es necesario probar con ambos
	
	//sut:
	Verificada verificada;
	
	//creo los mock y la verificada a testear
	@BeforeEach
	void setUp () {
		
		//sut:
		verificada = new Verificada(); 
		
		//setUp:
		when (basicoStub.getNivel()).thenReturn (Nivel.BASICO);
		when (muestraDummy.getVinchuca()).thenReturn(TipoVinchuca.VINCHUCA_INFESTANS);
		
	}
	
	@Test
	void puedeVotarTest(){
		//verify:
		assertEquals(verificada.puedeVotar(basicoStub),false);
		assertEquals(verificada.puedeVotar(especialistaStub),false);
	}
	@Test
	void verificarTest() {
		//exercise:
		verificada.verificar(muestraDummy);
		//verify:
		assertEquals(verificada instanceof Verificada,true);
	}
	@Test
	void resultadoActualTest() {
		//verify:
		assertEquals(verificada.resultadoActual(muestraDummy),"Vinchuca Infestans");
	}

}
