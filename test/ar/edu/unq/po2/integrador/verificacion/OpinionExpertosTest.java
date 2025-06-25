package ar.edu.unq.po2.integrador.verificacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

import static org.mockito.Mockito.*;

class OpinionExpertosTest {
    
	//doc:
	Muestra muestraStub = mock(Muestra.class); //tambien hace de mock
	
	Usuario experto = mock(Usuario.class);
	Usuario basico = mock(Usuario.class);
	
	List<Opinion> listaDeOpinionesQueCambianEstado = new ArrayList<Opinion>();
	List<Opinion> listaDeOpinionesQueNoCambianEstado = new ArrayList<Opinion>();
	List<Opinion> listaDeOpinionesVacia = new ArrayList<Opinion>();
	
	Usuario basicoStub = mock(Usuario.class);
	Usuario especialistaStub = mock(Usuario.class); //como especialista y experto responden lo mismo
													 //en esBasico() no es necesario probar con ambos
	
	Opinion opinionGuasayana = mock(Opinion.class);
	Opinion opinionGuasayanaDos = mock (Opinion.class);
	Opinion opinionInfestans = mock (Opinion.class);
	Opinion opinionInfestansDos= mock (Opinion.class);
	Opinion opinionInfestansTres= mock (Opinion.class);

	
	//sut:
	OpinionExpertos verificacionExp;
	
	
	@BeforeEach
	void setUp () {
		
		//sut:
		verificacionExp = new OpinionExpertos ();
		
		
		//setUp:
		when (experto.getNivel()).thenReturn (Nivel.EXPERTO);
		when (basico.getNivel()).thenReturn (Nivel.BASICO);
		
		when (opinionGuasayana.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_GUASAYANA);
		when (opinionGuasayanaDos.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_GUASAYANA);
		when (opinionInfestans.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_INFESTANS);
		when (opinionInfestansDos.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_INFESTANS);
		when (opinionInfestansTres.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_INFESTANS);
		
		when (opinionInfestans.getNivelOpinion()).thenReturn (Nivel.EXPERTO);
		when (opinionInfestansDos.getNivelOpinion()).thenReturn (Nivel.BASICO);
		when (opinionInfestansTres.getNivelOpinion()).thenReturn (Nivel.EXPERTO);
		when (opinionGuasayana.getNivelOpinion()).thenReturn (Nivel.EXPERTO);
		when (opinionGuasayanaDos.getNivelOpinion()).thenReturn (Nivel.EXPERTO);
		
		listaDeOpinionesQueCambianEstado.add(opinionGuasayana);
		listaDeOpinionesQueCambianEstado.add(opinionGuasayanaDos);
		listaDeOpinionesQueCambianEstado.add(opinionInfestans);
		listaDeOpinionesQueCambianEstado.add(opinionInfestansDos); //al ser opinion basico no afecta
		
		listaDeOpinionesQueNoCambianEstado.add(opinionInfestans);
		listaDeOpinionesQueNoCambianEstado.add(opinionInfestansTres);
		listaDeOpinionesQueNoCambianEstado.add(opinionGuasayana);
		listaDeOpinionesQueNoCambianEstado.add(opinionGuasayanaDos);
		
		}
	
		
		
	
	@Test
	void verificarTestCambiaEstado() {
		
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn(listaDeOpinionesQueCambianEstado);
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a una conclusion (Guasayana)
		//exercise:
		verificacionExp.verificar(muestraStub);
		//verify:
		verify (muestraStub).setVerificacion((any(Verificada.class))); //esto comprueba que se haya mandado una instancia de verificada
		
		
	}

	@Test
	void verificarTestNoCambiaEstado() {
		
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueNoCambianEstado);
		
		//debo hacer que al pedirle a muestra opiniones el resultado llegue a un empate
		//ya que en caso de empate no cambia el estado
		
		//exercise:
		verificacionExp.verificar(muestraStub);
		//verify:
		verify (muestraStub,never()).setVerificacion(any()); //comprueba que no se llamo a setVerificacion
	}
	
	@Test
	void puedeVotarTest() {
		
		//verify:
		assertEquals(verificacionExp.puedeVotar(basico), false);
		assertEquals(verificacionExp.puedeVotar(experto), true);
		
	}
	
	@Test
	void resultadoActual() {
		
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueCambianEstado); //la opinion mayoritaria es Guasayana
		//verify:
		assertEquals (verificacionExp.resultadoActual(muestraStub) ,"Vinchuca Guasayana");
	}
	@Test
	void resultadoActualSinDefinirTest(){
		
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueNoCambianEstado); //hay empate
		//verify:
		assertEquals (verificacionExp.resultadoActual(muestraStub) ,"No definido");
	}
	

}
