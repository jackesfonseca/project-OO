package model.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

import model.Cozinheiro;

/**
 * Realiza��o de testes unit�rios para a classe Cozinheiro
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */

class CozinheiroTest {
	Date data = new Date();
	Cozinheiro cozinheiroUm = new Cozinheiro("cozinheiro um", "masculino", 123, 123, 1000.00, data, false);
	Cozinheiro cozinheiroDois = new Cozinheiro("cozinheiro dois", "feminino", 123, 123, 1000.00, data, true, "restaurante 1"); 
	
	/**
	 * verifica se a fun��o tem o retorno esperado de acordo com os seguintes casos
	 * (1) cozinheiroChef true deve retornar "Sim"
	 * (2) cozinheiroChef false deve retornar "n�o"
	 */
	@Test
	public void testRetornaNomeFantasia() {
		assertEquals("N�O", cozinheiroUm.retornaNomeFantasia());
		assertEquals("SIM", cozinheiroDois.retornaNomeFantasia());
	}
	
	/**
	 * verifica se a fun��o tem o retorno esperado de acordo com o seguinte caso
	 * (1) quando cozinheiroChef for false deve ser retornado a seguinte mensagem: N�o se aplica
	 */
	@Test
	public void testRetornaRestaurantesAnteriores() {
		assertEquals("N�O SE APLICA", cozinheiroUm.retornaRestaurantesAnteriores());
	}

}
