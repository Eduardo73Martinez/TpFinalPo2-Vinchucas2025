package ar.edu.unq.po2.integrador.webMuestraUsuario;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.integrador.verificacion.*;
import ar.edu.unq.po2.integrador.zonaOrganizanizacionUbicacion.*;

import static org.junit.jupiter.api.Assertions.*;

public class WebTest {
	
	Web web;
	
	Usuario usuario_1;
	Usuario usuario_2;
	Usuario usuario_3;
	
	List<Usuario> listaDeUsuarios;
	
	ZonaCobertura zona_1;
	ZonaCobertura zona_2;
	
	List<ZonaCobertura> listaDeZonas;
	
	Muestra muestra_1;
	Muestra muestra_2;
	
	Verificada verificada;
	OpinionBasicos noVerificada;
	
	Ubicacion ubicacion_1;
	
	LocalDate fechaReferencia;
	LocalDate fechaVieja;
	
	List<LocalDate> listaFechas5ViejasY5Nuevas;
	List<LocalDate> listaFechas25Nuevas;
	
	TipoVinchuca vinchuca;
	
	Double lat;
	Double lon;
	
	@BeforeEach 
	void setUp() throws Exception{
		//DOC:
		
		//SUT:
		web = new Web();
		
		//DOC:
		usuario_1 = mock(Usuario.class);
		usuario_2 = mock(Usuario.class);
		usuario_3 = mock(Usuario.class);
		
		zona_1 = mock(ZonaCobertura.class);
		zona_2 = mock(ZonaCobertura.class);
		
		muestra_1 = mock(Muestra.class);
		muestra_2 = mock(Muestra.class);
		
		verificada = mock(Verificada.class);
		noVerificada = mock(OpinionBasicos.class);
		
		ubicacion_1 = mock(Ubicacion.class);
		
		listaDeUsuarios = Arrays.asList(usuario_1,usuario_2,usuario_3);
		listaDeZonas = Arrays.asList(zona_1,zona_2);
		
		vinchuca = TipoVinchuca.VINCHUCA_GUASAYANA;
		
		lat = 15d; lon = 10d;
		
		fechaReferencia = LocalDate.now().minus(30, ChronoUnit.DAYS);		
		fechaVieja = LocalDate.now().minus(40, ChronoUnit.DAYS);
		
		listaFechas5ViejasY5Nuevas = new ArrayList<LocalDate>();
		int i=0;
		while (i<5) {
			listaFechas5ViejasY5Nuevas.add(LocalDate.now());
			listaFechas5ViejasY5Nuevas.add(fechaVieja);
			i++;
		}
		
		listaFechas25Nuevas = new ArrayList<LocalDate>();
		i=0;
		while (i<25) {
			listaFechas25Nuevas.add(LocalDate.now());
			i++;
		}
	}
	
	@Test 
	void testTodasLasMuestras() {
		//SetUp
		web.agregarMuestra(muestra_1);
		
		//Exercise
		List<Muestra> muestrasObtenidas = web.todasLasMuestras();
		
		//Verify
		assertTrue(muestrasObtenidas.contains(muestra_1));
		assertEquals(muestrasObtenidas.size(),1);
	}
	
	@Test 
	void testTodosLosUsuarios() {
		//SetUp
		web.agregarUsuario();
		
		//Exercise
		List<Usuario> usuariosObtenidos = web.todosLosUsuarios();
		
		//Verify
		assertEquals(usuariosObtenidos.size(),1);
		assertEquals(usuariosObtenidos.getFirst().getId(),0l);
		assertEquals(web.getProximoId(),1l);
	}
	
	@Test
	void testTodasLasZonas() {
		//SetUp
		web.agregarZona(zona_1);
		web.agregarZona(zona_2);
		
		//Exercise
		List<ZonaCobertura> zonas = web.todasLasZonas();
		
		//Verify
		assertEquals(zonas.size(),2);
		assertTrue(zonas.contains(zona_1));
		assertTrue(zonas.contains(zona_2));
	}

	@Test
	void testAgregarMuestra() {
		//Exercise
		web.agregarMuestra(muestra_1);
		
		//Verify
		assertEquals(web.todasLasMuestras().getFirst(),muestra_1);
	}
	
	@Test
	void testQuitarMuestraQueExiste() {
		//SetUp
		web.agregarMuestra(muestra_1);
		web.agregarMuestra(muestra_2);
		
		//Exercise
		web.quitarMuestra(muestra_1);
		
		//Verify
		List<Muestra> muestrasObtenidas = web.todasLasMuestras();
		assertEquals(muestrasObtenidas.size(),1);
		assertFalse(muestrasObtenidas.contains(muestra_1));
		assertTrue(muestrasObtenidas.contains(muestra_2));
	}
	
	@Test
	void testQuitarMuestraQueNoExiste() {
		//SetUp
		web.agregarMuestra(muestra_2);
		
		//Exercise
		web.quitarMuestra(muestra_1);
		
		//Verify
		List<Muestra> muestrasObtenidas = web.todasLasMuestras();
		assertEquals(muestrasObtenidas.size(),1);
		assertFalse(muestrasObtenidas.contains(muestra_1));
		assertTrue(muestrasObtenidas.contains(muestra_2));
	}
	
	@Test
	void testAgregarUsuario() {
		//Exercise
		web.agregarUsuario();
		
		//Verify
		List<Usuario> usuariosObtenidos = web.todosLosUsuarios();
		assertEquals(usuariosObtenidos.size(),1);
		assertEquals(usuariosObtenidos.getFirst().getId(),0l);
		assertEquals(web.getProximoId(),1l);
	}
	
	@Test
	void testQuitarUsuarioQueExiste() {
		//SetUp
		web.agregarUsuario();
		Usuario usuarioCreado = web.todosLosUsuarios().getFirst();
		
		//Exercise
		web.quitarUsuario(usuarioCreado);
		
		//Verify
		assertFalse(web.todosLosUsuarios().contains(usuarioCreado));
		assertEquals(web.todosLosUsuarios().size(),0);
	}
	
	@Test
	void testQuitarUsuarioQueNoExiste() {
		//SetUp
		web.agregarUsuario();
		Usuario usuarioCreado = web.todosLosUsuarios().getFirst();
		
		//Exercise
		web.quitarUsuario(usuario_1);
		
		//Verify
		assertTrue(web.todosLosUsuarios().contains(usuarioCreado));
		assertEquals(web.todosLosUsuarios().size(),1);
	}
	
	@Test
	void testActualizarNivel() {
		//Exercise
		web.actualizarNivel(listaDeUsuarios);;
		
		//Verify
		verify(usuario_1).actualizarNivel();
		verify(usuario_2).actualizarNivel();
		verify(usuario_3).actualizarNivel();		
	}
	
	@Test
	void testConvertirEnEspecialistas() {
		//SetUp
		web.agregarUsuario();
		web.agregarUsuario();
		
		//Exercise
		web.convertirEnEspecialistas(web.todosLosUsuarios());
		
		//Verify
		assertEquals(web.todosLosUsuarios().getFirst().getNivel(), Nivel.ESPECIALISTA);
		assertEquals(web.todosLosUsuarios().getLast().getNivel(), Nivel.ESPECIALISTA);
	}
	
	
	@Test
	void testNotificarNuevaMuestra() {
		//SetUp
		web.agregarZona(zona_1);
		web.agregarZona(zona_2);
		
		//Exercise
		web.notificarNuevaMuestra(muestra_1);
		
		//Verify
		verify(zona_1).notificarNuevaMuestra(muestra_1);
		verify(zona_2).notificarNuevaMuestra(muestra_1);
	}
	
	@Test
	void testAgregarZona() {
		//SetUp
		web.agregarMuestra(muestra_1);
		web.agregarMuestra(muestra_2);
		when(muestra_1.getVerificacion()).thenReturn(noVerificada);
		when(muestra_2.getVerificacion()).thenReturn(verificada);
		
		//Exercise
		web.agregarZona(zona_1);
		
		//Verify
		verify(zona_1).notificarNuevaMuestra(muestra_1);
		verify(zona_1,never()).notificarNuevaMuestra(muestra_2);
	}
	
	@Test
	void testQuitarZonaQueExiste() {
		//SetUp
		web.agregarZona(zona_1);
		
		//Exercise
		web.quitarZona(zona_1);
		
		//Verify
		assertFalse(web.todasLasZonas().contains(zona_1));
	}
	
	@Test
	void testQuitarZonaQueNoExiste() {
		//SetUp
		web.agregarZona(zona_1);
		
		//Exercise
		web.quitarZona(zona_2);
		
		//Verify
		assertTrue(web.todasLasZonas().contains(zona_1));
	}

}
