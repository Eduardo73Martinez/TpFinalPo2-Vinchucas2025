package buscador;

import static org.mockito.Mockito.*;
import java.util.*;
import org.junit.jupiter.api.*;
import verificacion.*;
import web_vinchucas.*;

public class SoloVerificadas extends PorVerificacion {

	public  boolean esDelTipoEsperado (Muestra muestra){
		return muestra.getVerificacion().esVerificada();
	}
	public SoloVerificadas (Web web){
		super (web);
	}
}
