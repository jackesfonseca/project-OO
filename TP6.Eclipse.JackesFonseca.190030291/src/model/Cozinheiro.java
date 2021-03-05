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
	 * @param sexo Gênero do cozinheiro
	 * @param rg RG do cozinheiro
	 * @param matricula Matrícula do cozinheiro
	 * @param salario Salário do cozinheiro
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
	 * Construtor Cozinheiro sem o parâmetro restaurantesAnteriores
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
	 * Verifica se é cozinheiro chef
	 * @return "Sim" caso seja um cozinheiro chef e "Não" caso nao seja um cozinheiro chef
	 */
	public String retornaNomeFantasia()
	{
		if(cozinheiroChef)
		{
			return "SIM";
		}else{
			return "NÃO";
		}
	}

	/**
	 * Retorna a lista de restaurantes anteriores
	 * @return a lista informado pelo usuário para quando o atributo restaurantesAnteriores seja diferente de null e a mensagem "Não se aplica" caso contrário
	 */
	public String retornaRestaurantesAnteriores() {
		
		if(restaurantesAnteriores == null)
		{
			return "NÃO SE APLICA";
		}else {
			return restaurantesAnteriores;
		}
	}
}
