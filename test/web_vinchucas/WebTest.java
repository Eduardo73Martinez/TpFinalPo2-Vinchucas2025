package web_vinchucas;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ZonaOrganizanizacionUbicacion.GestorDeUbicaciones;
import ZonaOrganizanizacionUbicacion.Ubicacion;

import static org.junit.jupiter.api.Assertions.*;

public class WebTest {
	
	Web web;
	
	Usuario usuario_1;
	Muestra muestra_1;
	Ubicacion ubicacion_1;
	
	GestorDeUsuarios gestorUs_1;
	GestorDeUbicaciones gestorUbs_1;
	
	TipoVinchuca vinchuca;
	
	Double lat;
	Double lon;
	
	@BeforeEach 
	void setUp() throws Exception{
		//DOC:
		gestorUs_1 = mock(GestorDeUsuarios.class);
		gestorUbs_1 = mock(GestorDeUbicaciones.class);
		
		//SUT:
		web = new Web(gestorUs_1,gestorUbs_1);
		
		//DOC:
		usuario_1 = mock(Usuario.class);
		muestra_1 = mock(Muestra.class);
		ubicacion_1 = mock(Ubicacion.class);
		
		
		vinchuca = TipoVinchuca.VINCHUCA_GUASAYANA;
		
		lat = 15d; lon = 10d;
	}
	
	@Test
	void testGestGestorDeUsuarios() {
		//Exercise y Verify
		assertEquals(web.getGestorDeUsuarios(), gestorUs_1);
	}

	@Test
	void testGestGestorDeUbicaciones() {
		//Exercise y Verify
		assertEquals(web.getGestorUbicaciones(), gestorUbs_1);
	}
	@Test
	void testAgregarMuestra() {
		//Exercise
		web.agregarMuestra(muestra_1);
		
		//Verify
		assertEquals(web.todasLasMuestras().getFirst(),muestra_1);
	}
	
	@Test
	void testObtenerUbicacion() {
		//SetUp
		when(gestorUbs_1.obtenerUbicacion(lat, lon)).thenReturn(ubicacion_1);
		
		//Exercise
		Ubicacion nuevaUb = web.obtenerUbicacion(lat, lon);
		
		//Verify
		assertEquals(nuevaUb,ubicacion_1);
	}
	
	@Test
	void testNotificarNuevaMuestra() {
		
		//Exercise
		web.notificarNuevaMuestra(muestra_1);
		
		//Verify
		verify(gestorUbs_1).notificarNuevaMuestra(muestra_1);
	}

	@Test
	void testNotificarNuevaValidacion() {
		
		//Exercise
		web.notificarNuevaValidacion(muestra_1);
		
		//Verify
		verify(gestorUbs_1).notificarNuevaValidacion(muestra_1);
	}
}
