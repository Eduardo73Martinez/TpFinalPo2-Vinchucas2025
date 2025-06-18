package web_vinchucas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

class WebTest {
	Web sistemaWeb; 
	List<Muestra> muestras = new ArrayList<>(); 
	List<Usuario> usuarios = new ArrayList<>(); 
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;
	

	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);

		usuario1 = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		usuario3 = mock(Usuario.class);
		
		muestras.add(muestra1);muestras.add(muestra3);muestras.add(muestra3);
		usuarios.add(usuario1);usuarios.add(usuario2);usuarios.add(usuario3);
		sistemaWeb =new Web(muestras, usuarios);
	}

	@Test
	void testWeb() {
		//assertEquals(null, null);
	}

	@Test
	void testTodasLasMuestras() {
		assertEquals(muestras.size(), sistemaWeb.todasLasMuestras().size());
	}

	@Test
	void testAgregarMuestra() {
		Muestra muestra4 = mock(Muestra.class); 
		
		sistemaWeb.agregarMuestra(muestra4);
		
		assertEquals(4, sistemaWeb.getMuestrasSubidas().size());
	}

	@Test
	void testSacarMuestra() {
		sistemaWeb.sacarMuestra(muestra3);
		assertEquals(2, sistemaWeb.getMuestrasSubidas().size());
	}
	@Test
	void testSacarMuestraQueNoExisiteEnSistema() {
		Muestra muestra4 = mock(Muestra.class);
		sistemaWeb.sacarMuestra(muestra4);
		assertEquals(3, sistemaWeb.getMuestrasSubidas().size());
	}

	@Test
	void testDesuscribirUsuario() {
		sistemaWeb.desuscribirUsuario(usuario3);
		assertFalse(sistemaWeb.getUsuariosRegistrados().contains(usuario3));
	}
	@Test
	void testDesuscribirUsuarioQueNoExisiteEnSistema() {
		Usuario usuario4 = mock(Usuario.class);
		sistemaWeb.desuscribirUsuario(usuario4);
		assertEquals(3, sistemaWeb.getMuestrasSubidas().size());
	}

	@Test
	void testGetMuestrasSubidas() {
		assertEquals(muestras.size(), sistemaWeb.getMuestrasSubidas().size());
	}

	@Test
	void testSetMuestrasSubidas() {
		List<Muestra> muestras2 = new ArrayList<>();
		
		sistemaWeb.setMuestrasSubidas(muestras2);
		assertEquals(muestras2, sistemaWeb.getMuestrasSubidas());
	}

	@Test
	void testGetUsuariosRegistrados() {
		assertEquals(usuarios, sistemaWeb.getUsuariosRegistrados());
	}

	@Test
	void testSetUsuariosRegistrados() {
		List<Usuario> usuarios2 = new ArrayList<>();
		sistemaWeb.setUsuariosRegistrados(usuarios2);
		assertEquals(usuarios2, sistemaWeb.getUsuariosRegistrados());
	}

}
