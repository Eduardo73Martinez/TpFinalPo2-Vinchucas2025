package ar.edu.unq.po2.integrador.verificacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.webMuestraUsuario.*;

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
	List<Opinion> listaDeUnaOpinion = new ArrayList<Opinion>();
	
	//sut:
	OpinionBasicos verificacionBasic = new OpinionBasicos ();
	
	@BeforeEach
	void setUp () {
		
		
		//sut:
		verificacionBasic = new OpinionBasicos ();
		
		//setUp:
		
		when (muestraStub.getVinchuca()).thenReturn( TipoVinchuca.VINCHUCA_GUASAYANA );
		
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
		
		listaDeUnaOpinion.add(opinionGuasayana);
	
	}
	@Test
	void verificarCambiaEstadoTest(){
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn(listaDeOpinionesQueCambianEstado);
		//exercise:
		verificacionBasic.verificar(muestraStub);
		//verify:
		verify (muestraStub).setVerificacion((any(OpinionExpertos.class))); //esto comprueba que se haya mandado una instancia de OpinionExpertos
		
	}
	@Test
	void verificarNoCambiaEstadoTest(){
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn(listaDeOpinionesQueNoCambianEstado);
		//exercise:
		verificacionBasic.verificar(muestraStub);
		//verify:
		verify (muestraStub,never()).setVerificacion((any())); //esto comprueba que no se haya llamado a setVerificacion
	}

	@Test
	void puedeVotarTest(){
		//verify:
		assertEquals(verificacionBasic.puedeVotar(basicoStub),true);
		assertEquals(verificacionBasic.puedeVotar(especialistaStub),true);
	}
	@Test
	void resultadoActualTest(){
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueCambianEstado); //la opinion mayoritaria es Guasayana
		//exercise:
		assertEquals (verificacionBasic.resultadoActual(muestraStub)  ,"Vinchuca Guasayana");
	}
	@Test
	void resultadoActualSinDefinirTest(){
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn (listaDeOpinionesQueNoCambianEstado); //hay empate
		//exercise:
		assertEquals (verificacionBasic.resultadoActual(muestraStub) ,"No definido");
	}
	@Test
	void resultadoActualConUnaSolaMuestraTest(){
		//setUp:
		when (muestraStub.getOpiniones()).thenReturn (listaDeUnaOpinion); 
		//exercise:
		assertEquals (verificacionBasic.resultadoActual(muestraStub) ,"Vinchuca Guasayana");
	}

}
