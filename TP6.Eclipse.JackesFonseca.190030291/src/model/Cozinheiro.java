package model;

import java.util.Date;

/**
 * Subclasse da Classe Funcionario, cria um obejto para Cozinheiro
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class Cozinheiro extends Funcionarios
{
	private boolean cozinheiroChef;
	private String restaurantesAnteriores;
	
	/**
	 * Construtor Cozinheiro
	 * @param nome Nome do cozinheiro
	 * @param sexo G�nero do cozinheiro
	 * @param rg RG do cozinheiro
	 * @param matricula Matr�cula do cozinheiro
	 * @param salario Sal�rio do cozinheiro
	 * @param dataDeIngresso Data de ingresso do cozinheiro
	 * @param cozinheiroChef Nome fantasia
	 * @param restaurantesAnteriores Lista de restaurantes anteriores do cozinheiro chef
	 */
	public Cozinheiro(String nome, String sexo, int rg, int matricula, double salario, Date dataDeIngresso, 
			boolean cozinheiroChef, String restaurantesAnteriores) {
		super(nome, sexo, rg, matricula, salario, dataDeIngresso);
		this.cozinheiroChef = cozinheiroChef;
		this.restaurantesAnteriores = restaurantesAnteriores;
	}
	
	/**
	 * Construtor Cozinheiro sem o par�metro restaurantesAnteriores
	 * @param nome do cozinheiro
	 * @param sexo do cozinheiro
	 * @param rg do cozinheiro
	 * @param matricula do cozinheiro
	 * @param salario do cozinheiro
	 * @param dataDeIngresso data de ingresso do cozinheiro
	 * @param cozinheiroChef nome fantasia
	 */
	public Cozinheiro(String nome, String sexo, int rg, int matricula, double salario, Date dataDeIngresso, boolean cozinheiroChef) {
		super(nome, sexo, rg, matricula, salario, dataDeIngresso);
		this.cozinheiroChef = cozinheiroChef;
	}

	public void setCozinheiroChef(boolean cozinheiroChef) {
		this.cozinheiroChef = cozinheiroChef;
	}

	public void setRestaurantesAnteriores(String restaurantesAnteriores) {
		this.restaurantesAnteriores = restaurantesAnteriores;
	}
	
	/**
	 * Verifica se � cozinheiro chef
	 * @return "Sim" caso seja um cozinheiro chef e "N�o" caso nao seja um cozinheiro chef
	 */
	public String retornaNomeFantasia()
	{
		if(cozinheiroChef)
		{
			return "SIM";
		}else{
			return "N�O";
		}
	}

	/**
	 * Retorna a lista de restaurantes anteriores
	 * @return a lista informado pelo usu�rio para quando o atributo restaurantesAnteriores seja diferente de null e a mensagem "N�o se aplica" caso contr�rio
	 */
	public String retornaRestaurantesAnteriores() {
		
		if(restaurantesAnteriores == null)
		{
			return "N�O SE APLICA";
		}else {
			return restaurantesAnteriores;
		}
	}
}
