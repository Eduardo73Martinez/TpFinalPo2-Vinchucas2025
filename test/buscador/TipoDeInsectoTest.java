package buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;
import verificacion.*;
import web_vinchucas.*;

class TipoDeInsectoTest {

	Web webStub = mock (Web.class);
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	Verificada verificadaInfestansStub = mock (Verificada.class);
	Verificada verificadaSordidaStub = mock (Verificada.class);
	Verificada verificadaGuasayanaStub = mock (Verificada.class);
	
	SoloVerificadas filtro = new SoloVerificadas (webStub);
	
	@BeforeEach
	void setUp () {
		
		when (verificadaInfestansStub.getVinchuca()).thenReturn (TipoVinchuca.INFESTANS);
		when (verificadaSordidaStub.getVinchuca()).thenReturn (TipoVinchuca.SORDIDA);
		when (verificadaGuasayanaStub.getVinchuca()).thenReturn (TipoVinchuca.GUASAYANA);
		
		when (muestra1Stub.getVerificacion()).thenReturn (verificadaInfestansStub);
		when (muestra2Stub.getVerificacion()).thenReturn (verificadaSordidaStub);
		when (muestra3Stub.getVerificacion()).thenReturn (verificadaGuasayanaStub);
		
		List <Muestra> listaDeMuestras = new ArrayList<Muestra>();
		listaDeMuestras.add(muestra1Stub);
		listaDeMuestras.add(muestra2Stub);
		listaDeMuestras.add(muestra3Stub);
		when (webStub.todasLasMuestras()).thenReturn(listaDeMuestras);
		
	}
	@Test
	void buscarTest() {
		
		List <Muestra> listaFinal = new ArrayList<Muestra>();
		listaFinal.add(muestra3Stub);
		assertEquals(filtro.buscar(GUASAYANA),listaFinal);
	}

}
