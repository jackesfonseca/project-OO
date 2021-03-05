package controller.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import controller.Program;

/**
 * Realização de testes unitários para a classe Program
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
class ProgramTest {
	/**
	 * verifica se o método validaGenero tem o retorno esperado de acordo com os seguintes casos
	 * (1) masculino ou feminino deve retornar true
	 * (2) qualquer outro caso deve retornar false
	 */
	@Test
	void testValidaGenero() {
		assertTrue(Program.validaGenero("masculino"));
		assertFalse(Program.validaGenero("masc"));
		assertTrue(Program.validaGenero("feminino"));
		assertFalse(Program.validaGenero("fem"));
	}
	
}
