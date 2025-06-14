package verificacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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

class OpinionBasicosTest { 

	//doc:
	Muestra muestraStub = mock(Muestra.class);
	Opinion opinionGuasayana = mock(Opinion.class);
	Opinion opinionGuasayanaExperto = mock (Opinion.class);
	Opinion opinionInfestans = mock (Opinion.class);
	
	Usuario basicoStub = mock(Usuario.class); 
	Usuario especialistaStub = mock(Usuario.class);
	
	
	List<Opinion> listaDeOpinionesQueCambianEstado = new ArrayList<Opinion>();
	List<Opinion> listaDeOpinionesQueNoCambianEstado = new ArrayList<Opinion>();
	
	//sut:
	OpinionBasicos verificacionBasic = new OpinionBasicos ();
	
	@BeforeEach
	void setUp () {
		
		
		//sut:
		verificacionBasic = new OpinionBasicos ();
		when (opinionGuasayana.getNivelOpinion()).thenReturn( Nivel.BASICO );
		when (opinionGuasayanaExperto.getNivelOpinion()).thenReturn(Nivel.EXPERTO );
		when (opinionInfestans.getNivelOpinion()).thenReturn(  Nivel.BASICO);
		
		when (opinionGuasayana.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_GUASAYANA);
		when (opinionGuasayanaExperto.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_GUASAYANA);
		when (opinionInfestans.getValorOpinion()).thenReturn (TipoVinchuca.VINCHUCA_INFESTANS);
		
		listaDeOpinionesQueCambianEstado.add(opinionGuasayana);
		listaDeOpinionesQueCambianEstado.add(opinionGuasayanaExperto);
		listaDeOpinionesQueCambianEstado.add(opinionInfestans);
		
		listaDeOpinionesQueNoCambianEstado.add(opinionInfestans);
		listaDeOpinionesQueNoCambianEstado.add(opinionGuasayana);
	
	}
	@Test
	void verificarCambiaEstadoTest(){
		when (muestraStub.getOpiniones()).thenReturn(listaDeOpinionesQueCambianEstado);
		verificacionBasic.verificar(muestraStub);
		verify (muestraStub).setVerificacion((any(OpinionExpertos.class))); //esto comprueba que se haya mandado una instancia de OpinionExpertos
		
	}
	void verificarNoCambiaEstadoTest(){
		when (muestraStub.getOpiniones()).thenReturn(listaDeOpinionesQueNoCambianEstado);
		verificacionBasic.verificar(muestraStub);
		verify (muestraStub).setVerificacion((any())); //esto comprueba que no se haya llamado a setVerificacion
	}

	@Test
	void puedeVotarTest(){
		assertEquals(verificacionBasic.puedeVotar(basicoStub),true);
		assertEquals(verificacionBasic.puedeVotar(especialistaStub),true);
	}
	@Test
	void esVotadaTest(){
		assertEquals(verificacionBasic.esVotada(),false);
	}
	@Test
	void esVerificadaTest(){
		assertEquals(verificacionBasic.esVerificada(),false);
	}
	@Test
	void resultadoActualTest(){
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueCambianEstado); //la opinion mayoritaria es Guasayana
		assertEquals (verificacionBasic.resultadoActual(muestraStub)  ,"Vinchuca Guasayana");
	}
	@Test
	void resultadoActualSinDefinirTest(){
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueNoCambianEstado); //hay empate
		assertEquals (verificacionBasic.resultadoActual(muestraStub) ,"No definido");
	}

}
