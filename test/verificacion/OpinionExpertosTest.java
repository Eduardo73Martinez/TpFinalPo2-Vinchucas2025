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
	OpinionExpertos verificacionExp = new OpinionExpertos (muestraMock);
	List<Opinion> listaDeOpinionesQueCambianEstado = new ArrayList<Opinion>();
	List<Opinion> listaDeOpinionesQueNoCambianEstado = new ArrayList<Opinion>();
	Experto tipoExperto= new Experto (Experto.class);
	
	
	@BeforeEach
	void setUp () {
		verificacionExp = new Verificada (muestraMock); //en realidad no es necesario hacer setUp en
													   //esta clase especifica, pero para no cambiar 
													   //tanto el test si la cambio aun asi lo hago
		when (basicoMock.esBasico()).thenReturn (true);
		when (especialistaMock.esBasico()).thenReturn (false);
		
		Opinion opinionGuasayana = new Opinion (tipoExperto,Guasayana);
		Opinion opinionGuasayanaDos = new Opinion (tipoExperto,Guasayana);
		Opinion opinionInfestans = new Opinion (tipoExperto,Infestans);
		Opinion opinionInfestansDos= new Opinion (tipoExperto,Infestans);
		
		listaDeOpinionesQueCambianEstado.add(opinionGuasayana);
		listaDeOpinionesQueCambianEstado.add(opinionGuasayanaDos);
		listaDeOpinionesQueCambianEstado.add(opinionInfestans);
		
		listaDeOpinionesQueNoCambianEstado.add(opinionInfestans);
		listaDeOpinionesQueNoCambianEstado.add(opinionInfestansDos);
		listaDeOpinionesQueNoCambianEstado.add(opinionGuasayana);
		listaDeOpinionesQueNoCambianEstado.add(opinionGuasayanaDos);
		
	}
	@Test
	void esVerificadaTest() {
		assertEquals(verificacionExp.esVerificada(),false);
	}
	@Test
	void puedeVotarTest(){
		assertEquals(verificacionExp.puedeVotar(basicoMock),false);
		assertEquals(verificacionExp.puedeVotar(especialistaMock),true);
	}
	@Test
	void verificarTestCambiaEstado() {
		when (muestraMock.getOpiniones().thenReturn (listaDeOpinionesQueCambianEstado));
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a una conclusion (Guasayana)
		verificacionExp.verificar();
		assertEquals(verificacionExp.esVerificada(),true);
	}
	@Test
	void verificarTestNoCambiaEstado() {
		when (muestraMock.getOpiniones().thenReturn (listaDeOpinionesQueNoCambianEstado));
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a un empate
		//ya que en caso de empate no cambia el estado
		verificacionExp.verificar();
		assertEquals(verificacionExp.esVerificada(),false);
	}
	@Test
	void opinionMayoritariaTest() {
		when (muestraMock.getOpiniones().thenReturn (listaDeOpinionesQueCambianEstado)); //la opinion mayoritaria es Guasayana
		assertEquals (verificacionExp.opinionMayoritaria() ,Guasayana);
	}
}
