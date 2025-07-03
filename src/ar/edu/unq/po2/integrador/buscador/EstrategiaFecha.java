package ar.edu.unq.po2.integrador.buscador;

import java.time.LocalDate;

import ar.edu.unq.po2.integrador.webMuestraUsuario.Muestra;

public interface EstrategiaFecha {

	abstract LocalDate fechaDeMuestraParaEsteTipo(Muestra muestra);
}
