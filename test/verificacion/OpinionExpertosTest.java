package verificacion;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web_vinchucas.Muestra;
import web_vinchucas.Nivel;
import web_vinchucas.Opinion;
import web_vinchucas.TipoVinchuca;
import web_vinchucas.Usuario;

class OpinionExpertosTest {

	Muestra muestraStub = mock(Muestra.class);
	
	Usuario Mock = mock(Usuario.class);
	OpinionExpertos verificacionExp = new OpinionExpertos ();
	List<Opinion> listaDeOpinionesQueCambianEstado = new ArrayList<Opinion>();
	List<Opinion> listaDeOpinionesQueNoCambianEstado = new ArrayList<Opinion>();
	
	Usuario basicoStub = mock(Usuario.class);
	Usuario especialistaStub = mock(Usuario.class); //como especialista y experto responden lo mismo
													 //en esBasico() no es necesario probar con ambos
	
	Opinion opinionGuasayana = mock(Opinion.class);
	Opinion opinionGuasayanaDos = mock (Opinion.class);
	Opinion opinionInfestans = mock (Opinion.class);
	Opinion opinionInfestansDos= mock (Opinion.class);
	
	
	@BeforeEach
	void setUp () {
		verificacionExp = new OpinionExpertos (); //en realidad no es necesario hacer setUp en
													   //esta clase especifica, pero para no cambiar 
													   //tanto el test si la cambio aun asi lo hago
		
	
		when (opinionGuasayana.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_GUASAYANA);
		when (opinionGuasayanaDos.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_GUASAYANA);
		when (opinionInfestans.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_INFESTANS);
		when (opinionInfestansDos.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_INFESTANS);
		
		
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
		assertEquals(verificacionExp.puedeVotar(basicoStub),false);
		assertEquals(verificacionExp.puedeVotar(especialistaStub),true);
	}
	void esVotadaTest() {
		assertEquals (verificacionExp.esVotada(),true);
	}
	@Test
	void verificarTestCambiaEstado() {
		when (muestraStub.getOpiniones()).thenReturn(listaDeOpinionesQueCambianEstado);
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a una conclusion (Guasayana)
		verificacionExp.verificar(muestraStub);
		assertEquals(verificacionExp.esVerificada(),true);
	}
	@Test
	void verificarTestNoCambiaEstado() {
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueNoCambianEstado);
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a un empate
		//ya que en caso de empate no cambia el estado
		verificacionExp.verificar(muestraStub);
		assertEquals(verificacionExp.esVerificada(),false);
	}
	
	@Test
	void resultadoActual() {
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueCambianEstado); //la opinion mayoritaria es Guasayana
		assertEquals (verificacionExp.resultadoActual() ,"Vinchuca Guasayana");
	}
	@Test
	void resultadoActualSinDefinirTest(){
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueNoCambianEstado); //hay empate
		assertEquals (verificacionExp.resultadoActual() ,"No definido");
	}

}
