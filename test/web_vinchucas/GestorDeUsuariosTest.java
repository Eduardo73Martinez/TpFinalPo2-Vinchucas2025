package web_vinchucas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestorDeUsuariosTest {
	
	Web web;
	GestorDeUsuarios miGestorDeUsuarios;
	
	Usuario usuario_1;
	Usuario usuario_2;
	Usuario usuario_3;
	
	LocalDate fechaReferencia;
	LocalDate fechaVieja;
	
	List<LocalDate> listaFechas5ViejasY5Nuevas;
	List<LocalDate> listaFechas25Nuevas;

	@BeforeEach
	void setUp() throws Exception {
		
		web = mock(Web.class);
		
		miGestorDeUsuarios = new GestorDeUsuarios(web);
		
		usuario_1 = mock(Usuario.class);
		usuario_2 = mock(Usuario.class);
		usuario_3 = mock(Usuario.class);
		
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
	void testGetUsuarios() {
		//Exercise
		List<Usuario> listaUsuarios = miGestorDeUsuarios.getUsuarios();
		//Verify
		assertEquals(listaUsuarios.size(),0);
	}
	
	@Test
	void testAgregarNuevoUsuario() {
		//Exercise
		miGestorDeUsuarios.agregarNuevoUsuario();
		
		//Verify
		assertEquals(miGestorDeUsuarios.getUsuarios().size(),1);
		
		//Exercise 2
		miGestorDeUsuarios.agregarNuevoUsuario();
		
		//Verify 2
		assertEquals(miGestorDeUsuarios.getUsuarios().size(),2);
	}
	
	@Test
	void testConvertirEnEspecialista() {
		//Exercise
		miGestorDeUsuarios.convertirEnEspecialista(usuario_1);
		//Verify
		verify(usuario_1).setNivel(Nivel.ESPECIALISTA);
	}
	
	@Test
	void testActualizarNivelABasicoPorQueNoAlcanzanEnviosNiRevisiones() {
		//SetUp
		when(usuario_1.getNivel()).thenReturn(Nivel.EXPERTO);
		when(usuario_1.getFechasEnvios()).thenReturn(listaFechas5ViejasY5Nuevas);
		when(usuario_1.getFechasRevisiones()).thenReturn(listaFechas5ViejasY5Nuevas);
		
		//Exercise
		miGestorDeUsuarios.actualizarNivel(usuario_1);
		
		//Verify
		verify(usuario_1).setNivel(Nivel.BASICO);
	}
	

	@Test
	void testActualizarNivelABasicoPorQueNoAlcanzanEnvios() {
		//SetUp
		when(usuario_1.getNivel()).thenReturn(Nivel.EXPERTO);
		when(usuario_1.getFechasEnvios()).thenReturn(listaFechas5ViejasY5Nuevas);
		when(usuario_1.getFechasRevisiones()).thenReturn(listaFechas25Nuevas);
		
		//Exercise
		miGestorDeUsuarios.actualizarNivel(usuario_1);
		
		//Verify
		verify(usuario_1).setNivel(Nivel.BASICO);
	}

	@Test
	void testActualizarNivelABasicoPorQueNoAlcanzanRevisiones() {
		//SetUp
		when(usuario_1.getNivel()).thenReturn(Nivel.EXPERTO);
		when(usuario_1.getFechasEnvios()).thenReturn(listaFechas25Nuevas);
		when(usuario_1.getFechasRevisiones()).thenReturn(listaFechas5ViejasY5Nuevas);
		
		//Exercise
		miGestorDeUsuarios.actualizarNivel(usuario_1);
		
		//Verify
		verify(usuario_1).setNivel(Nivel.BASICO);
	}

	@Test
	void testActualizarNivelAExperto() {
		//SetUp
		when(usuario_1.getNivel()).thenReturn(Nivel.BASICO);
		when(usuario_1.getFechasEnvios()).thenReturn(listaFechas25Nuevas);
		when(usuario_1.getFechasRevisiones()).thenReturn(listaFechas25Nuevas);
		
		//Exercise
		miGestorDeUsuarios.actualizarNivel(usuario_1);
		
		//Verify
		verify(usuario_1).setNivel(Nivel.EXPERTO);
	}
	
	@Test
	void testActualizarUsuarioEspecialista() {
		//SetUp
		when(usuario_1.getNivel()).thenReturn(Nivel.ESPECIALISTA);
		//Exercise
		miGestorDeUsuarios.actualizarNivel(usuario_1);
		//Verify
		verify(usuario_1, never()).setNivel(Nivel.BASICO);
		verify(usuario_1, never()).setNivel(Nivel.EXPERTO);
	}
	
	@Test
	void testCantidadAntesDeFechaCon5ViejasY5Nuevas() {
		//Exercise
		Long cant = miGestorDeUsuarios.cantidadAntesDeFecha(listaFechas5ViejasY5Nuevas, fechaReferencia);
		//Verify
		assertEquals(cant,5);
	}
	
	@Test
	void testCantidadAntesDeFechaCon25Nuevas() {
		//Exercise
		Long cant = miGestorDeUsuarios.cantidadAntesDeFecha(listaFechas25Nuevas, fechaReferencia);
		//Verify
		assertEquals(cant,25);
	}
	
	@Test
	void testNivelSegunCriterioInsuficienteAmbos() {
		//Exercise
		Nivel obtenido = miGestorDeUsuarios.nivelSegunCriterio(5l, 5l);
		//Verify
		assertEquals(obtenido,Nivel.BASICO);
	}

	@Test
	void testNivelSegunCriterioEnviosInsuficientes() {
		//Exercise
		Nivel obtenido = miGestorDeUsuarios.nivelSegunCriterio(25l, 5l);
		//Verify
		assertEquals(obtenido,Nivel.BASICO);
	}

	@Test
	void testNivelSegunCriterioRevisionesInsuficientes() {
		//Exercise
		Nivel obtenido = miGestorDeUsuarios.nivelSegunCriterio(5l, 25l);
		//Verify
		assertEquals(obtenido,Nivel.BASICO);
	}

	@Test
	void testNivelSegunCriterioConEnviosYRevisionesSuficientesParaExperto() {
		//Exercise
		Nivel obtenido = miGestorDeUsuarios.nivelSegunCriterio(25l, 25l);
		//Verify
		assertEquals(obtenido,Nivel.EXPERTO);
	}
	
	@Test 
	void actualizarTodosLosNiveles() {
		//SetUp
		int n = 0;
		while(n<3) {
			miGestorDeUsuarios.agregarNuevoUsuario();
			n++;
		}
		List<Usuario> usuariosCreados = miGestorDeUsuarios.getUsuarios();
		usuariosCreados.get(0).setNivel(Nivel.EXPERTO);
		usuariosCreados.get(1).setNivel(Nivel.ESPECIALISTA);
		
		//Exercise
		miGestorDeUsuarios.actualizarTodosLosNiveles();
		
		//Verify
		assertEquals(usuariosCreados.get(0).getNivel(),Nivel.BASICO);
		assertEquals(usuariosCreados.get(1).getNivel(),Nivel.ESPECIALISTA);
		assertEquals(usuariosCreados.get(2).getNivel(),Nivel.BASICO);
		
		
	}
}
