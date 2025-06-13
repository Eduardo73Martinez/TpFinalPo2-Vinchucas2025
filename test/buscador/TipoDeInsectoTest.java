package buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;
import verificacion.*;
import web_vinchucas.*;
import buscador.*;
class TipoDeInsectoTest {

	Web webStub = mock (Web.class);
	Muestra muestra1Stub = mock (Muestra.class);
	Muestra muestra2Stub = mock (Muestra.class);
	Muestra muestra3Stub = mock (Muestra.class);
	
	
	TipoDeInsecto filtro = new TipoDeInsecto (webStub,TipoVinchuca.VINCHUCA_GUASAYANA);
	
	@BeforeEach
	void setUp () {
		
		
		when (muestra1Stub.resultadoActual()).thenReturn ("Vinchuca Infestans");
		when (muestra2Stub.resultadoActual()).thenReturn ("Vinchuca Sordida");
		when (muestra3Stub.resultadoActual()).thenReturn ("Vinchuca Guasayana");
		
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
		System.out.println("el resultado de busqueda es" + filtro.buscar());
		assertEquals(filtro.buscar(),listaFinal);
	}

}
