package web_vinchucas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	
	Usuario miUsuario;
	
	Web miWeb;
	Double id;

	List<Opinion> misOpiniones;
	List<Muestra> misMuestras;
	List<LocalDate> listaConFecha;
	
	Muestra muestra_1;
	Muestra muestra_2;
	
	IOpinable opinable_1;
	
	Opinion opinion_1;
	
	TipoVinchuca tipoVinchuca_1;
	
	Double lat;
	Double lon;

	@BeforeEach
	void setUp() throws Exception {
	
		//DOC:
		miWeb = mock(Web.class);
		id = 3025d;
		
		//SUT:
		miUsuario = new Usuario(miWeb, id);
		
		//DOC:
		muestra_1 = mock(Muestra.class);
		opinable_1 = mock(IOpinable.class);
		opinion_1 = mock(Opinion.class);
		
		misOpiniones = new ArrayList<Opinion>();
		misMuestras = new ArrayList<Muestra>();
		
		tipoVinchuca_1 = mock(TipoVinchuca.class);
		lat = 30d;
		lon = 32d;
		
		listaConFecha = new ArrayList<LocalDate>();
		listaConFecha.add(LocalDate.now());
	}
	
	@Test
	void testGetId() {
		assertEquals(miUsuario.getId(),id);
	}
	
	@Test
	void testGetNivel() {
		assertEquals(miUsuario.getNivel(),Nivel.BASICO);
	}
	
	@Test
	void testGetOpiniones() {
		assertEquals(miUsuario.getOpiniones(),misOpiniones);
	}
	
	@Test
	void testGetMuestras() {
		assertEquals(miUsuario.getMuestras(),misMuestras);
	}
	
	@Test
	void testActualizarNivel() {
		//Exercise
		miUsuario.actualizarNivel(Nivel.EXPERTO);
		
		//Verify
		assertEquals(miUsuario.getNivel(),Nivel.EXPERTO);
	}
	
	@Test
	void testOpinarCuandoPuedeOpinar() {
		//SetUp
		when(muestra_1.puedeOpinar(miUsuario)).thenReturn(true);
		
		//Exercise
		miUsuario.opinar(muestra_1,opinable_1);
		
		//Verify
		assertEquals(miUsuario.getOpiniones().getFirst().getValorOpinion(),opinable_1);
	}
	
	@Test
	void testOpinarCuandoNoPuedeOpinar() {
		//SetUp
		when(muestra_1.puedeOpinar(miUsuario)).thenReturn(false);
		
		
		//Exercise
		miUsuario.opinar(muestra_1,opinable_1);
		
		//Verify
		assertTrue(miUsuario.getOpiniones().isEmpty());
	}
	@Test
	void testCrearMuestra() {
		//Exercise
		Muestra nuevaMuestra = miUsuario.crearMuestra(tipoVinchuca_1, lat, lon);
		//Verify
		assertEquals(nuevaMuestra.getVinchuca(),tipoVinchuca_1);
		assertEquals(nuevaMuestra.getPersona(),miUsuario);
		assertEquals(nuevaMuestra.getUbicacion().getLatitud(),lat);
		assertEquals(nuevaMuestra.getUbicacion().getLongitud(),lon);
		
	}
	
	@Test
	void testEnviarMuestra() {
		
		//Exercise
		miUsuario.enviarMuestra(tipoVinchuca_1, lat, lon);
		
		//Verify
		Muestra muestraCreada = miUsuario.getMuestras().getFirst();
				
		verify(miWeb).agregarMuestra(muestraCreada);
		assertEquals(muestraCreada.getPersona(),miUsuario);
		assertEquals(muestraCreada.getVinchuca(),tipoVinchuca_1);
		assertEquals(muestraCreada.getUbicacion().getLatitud(),lat);
		assertEquals(muestraCreada.getUbicacion().getLongitud(),lon);
		
	}
	
	
	@Test
	void testGetFechasRevisiones() {
		//SetUp
		when(muestra_1.puedeOpinar(miUsuario)).thenReturn(true);
		miUsuario.opinar(muestra_1, opinable_1);
		
		//Exercise
		List<LocalDate> misRevisiones = miUsuario.getFechasRevisiones();
		
		//Verify
		assertEquals(misRevisiones, listaConFecha);
	}
	
	@Test
	void testGetFechasEnvios() {
		//SetUp
		miUsuario.enviarMuestra(tipoVinchuca_1, lat, lon);
		
		//Exercise
		List<LocalDate> misEnvios = miUsuario.getFechasEnvios();
		
		//Verify
		assertEquals(misEnvios, listaConFecha);
	}
	
} 
