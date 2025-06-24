package web_vinchucas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ZonaOrganizanizacionUbicacion.Ubicacion;

public class UsuarioTest {
	
	Usuario miUsuario;
	
	Web miWeb;
	Long id;

	List<Opinion> misOpiniones;
	List<Muestra> misMuestras;
	List<Muestra> misMuestrasVacia;
	List<LocalDate> listaConFecha;
	
	Muestra muestra_1;  Muestra muestra_2;  Muestra muestra_3;  Muestra muestra_4;  Muestra muestra_5;
	Muestra muestra_6;  Muestra muestra_7;  Muestra muestra_8;  Muestra muestra_9;  Muestra muestra_10;
	Muestra muestra_11; Muestra muestra_12; Muestra muestra_13; Muestra muestra_14; Muestra muestra_15;
	Muestra muestra_16; Muestra muestra_17; Muestra muestra_18; Muestra muestra_19; Muestra muestra_20;
	Muestra muestra_21;
	
	Ubicacion ubicacion_1;
	
	IOpinable opinable_1;
	
	Opinion opinion_1; Opinion opinion_2; Opinion opinion_3; Opinion opinion_4; Opinion opinion_5;
	Opinion opinion_6; Opinion opinion_7; Opinion opinion_8; Opinion opinion_9; Opinion opinion_10;
	Opinion opinion_11; Opinion opinion_12; Opinion opinion_13; Opinion opinion_14; Opinion opinion_15;
	Opinion opinion_16; Opinion opinion_17; Opinion opinion_18; Opinion opinion_19; Opinion opinion_20;
	Opinion opinion_21; 
	
	TipoVinchuca tipoVinchuca_1;
	
	Double lat;
	Double lon;

	@BeforeEach
	void setUp() throws Exception {
	
		//DOC:
		miWeb = mock(Web.class);
		id = 3025l;
		
		//SUT:
		miUsuario = new Usuario(miWeb, id);
		
		//DOC:
		misOpiniones = new ArrayList<Opinion>();
		misMuestrasVacia = new ArrayList<Muestra>();
				
		muestra_1  = mock(Muestra.class); muestra_2  = mock(Muestra.class); muestra_3  = mock(Muestra.class);
		muestra_4  = mock(Muestra.class); muestra_5  = mock(Muestra.class); muestra_6  = mock(Muestra.class);
		muestra_7  = mock(Muestra.class); muestra_8  = mock(Muestra.class); muestra_9  = mock(Muestra.class);
		muestra_10 = mock(Muestra.class); muestra_11 = mock(Muestra.class); muestra_12 = mock(Muestra.class);
		muestra_13 = mock(Muestra.class); muestra_14 = mock(Muestra.class); muestra_15 = mock(Muestra.class);
		muestra_16 = mock(Muestra.class); muestra_17 = mock(Muestra.class); muestra_18 = mock(Muestra.class);
		muestra_19 = mock(Muestra.class); muestra_20 = mock(Muestra.class); muestra_21 = mock(Muestra.class);
		
		misMuestras = Arrays.asList(muestra_1,  muestra_2,  muestra_3,  muestra_4,  muestra_5,
									muestra_6,  muestra_7,  muestra_8,  muestra_9,  muestra_10, 
									muestra_11, muestra_12, muestra_13, muestra_14, muestra_15, 
									muestra_16, muestra_17, muestra_18, muestra_19, muestra_20,
									muestra_21);
		/*
		* 
		* intente usar un forEach para el mock pero no lo pude hacer andar
		* misMuestras.forEach(m->m = mock(Muestra.class));
		*/
		
		ubicacion_1 = mock(Ubicacion.class);
		
		opinable_1 = mock(IOpinable.class);
		opinion_1 = mock(Opinion.class);
		
		tipoVinchuca_1 = mock(TipoVinchuca.class);
		lat = 30d;
		lon = 32d;
		
		listaConFecha = new ArrayList<LocalDate>();
		listaConFecha.add(LocalDate.now());
		
		when(ubicacion_1.getLatidud()).thenReturn(lat);
		when(ubicacion_1.getLongitud()).thenReturn(lon);
		when(miWeb.verificarUbicacion(ubicacion_1)).thenReturn(ubicacion_1);
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
		assertEquals(miUsuario.getMuestras(),misMuestrasVacia);
	}
	
	@Test
	void testSetNivel() {
		//Exercise
		miUsuario.setNivel(Nivel.EXPERTO);
		
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
		assertEquals(nuevaMuestra.getUbicacion().getLatidud(),lat);
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
		assertEquals(muestraCreada.getUbicacion().getLatidud(),lat);
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
	
	
	@Test
	void testConvertirEnEspecialista() {
		//Exercise
		miUsuario.convertirEnEspecialista();
		//Verify
		assertEquals(miUsuario.getNivel(),Nivel.ESPECIALISTA);
	}
	
	@Test
	void testActualizarNivelCuandoEsEspecialista() {
		//SetUp
		miUsuario.convertirEnEspecialista();
		
		//Exercise
		miUsuario.actualizarNivel();
		
		//Verify
		assertEquals(miUsuario.getNivel(),Nivel.ESPECIALISTA);
	}
	
	@Test
	void testActualizarNivelCuandoEsBasicoYCorrespondeExperto() {
		//SetUp
		/* Hago que el usuario cree 11 muestras con fecha del dia de Hoy */
		int inicio = 0; int ultimo = 11;
		while (inicio<ultimo) { 
			miUsuario.enviarMuestra(tipoVinchuca_1, 15d, 10d);
			inicio++;
		}
		/* El usuario opina en 21 muestras
		 * intente hacerlo con un forEach pero no lo pude hacer andar
		*
		*/
		
		misMuestras.forEach(m-> when(m.puedeOpinar(miUsuario)).thenReturn(true));
		/*
		when( muestra_1.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_2.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_3.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_4.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_5.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_6.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_7.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_8.puedeOpinar(miUsuario)).thenReturn(true);
		when( muestra_9.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_10.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_11.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_12.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_13.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_14.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_15.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_16.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_17.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_18.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_19.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_20.puedeOpinar(miUsuario)).thenReturn(true);
		when(muestra_21.puedeOpinar(miUsuario)).thenReturn(true);
		*/
		misMuestras.forEach(m-> miUsuario.opinar(m,opinable_1));
		
		//Exercise
		miUsuario.actualizarNivel();
		
		//Verify
		assertEquals(miUsuario.getNivel(),Nivel.EXPERTO);
	}
	
	@Test
	void testActualizarNivelCuandoEsBasicoYNoCumpleParaExperto() {
		//Exercise
		miUsuario.actualizarNivel();
				
		//Verify
		assertEquals(miUsuario.getNivel(),Nivel.BASICO);
	}
	
	@Test
	void testCantidadAntesDeFechaCuandoCumplen() {
		//Exercise
		Long fechas = miUsuario.cantidadAntesDeFecha(listaConFecha, LocalDate.now().minus(1, ChronoUnit.DAYS));
		
		//Verify
		assertEquals(fechas,1);
	}
	
	@Test
	void testCantidadAntesDeFechaCuandoNoCumplen() {
		//SetUp
		LocalDate referencia = LocalDate.now().plus(31, ChronoUnit.DAYS);
		
		//Exercise
		Long fechas = miUsuario.cantidadAntesDeFecha(listaConFecha, referencia);
		
		//Verify
		assertEquals(fechas,0);
	}
	
	@Test
	void testNivelSegunCriterioDaParaExperto() {
		Nivel nivel;
		//Exercise
		nivel = miUsuario.nivelSegunCriterio(25l, 25l);
		
		//Verify
		assertEquals(nivel, Nivel.EXPERTO);
	}
	
	void testNivelSegunCriterioNoDaParaExperto() {
		Nivel nivel;
		//Exercise
		nivel = miUsuario.nivelSegunCriterio(0l, 25l);
		
		//Verify
		assertEquals(nivel, Nivel.BASICO);
	}
} 
