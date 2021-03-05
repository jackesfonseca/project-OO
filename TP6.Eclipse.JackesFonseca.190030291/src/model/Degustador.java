package model;

import java.util.Date;

/**
 * Subclasse da Classe Funcionario, Cria um obejto para Degustador
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class Degustador extends Funcionarios
{
	/**
	 * Construtor Degustador
	 * @param nome Nome do degustador
	 * @param sexo Gênero do degustador
	 * @param rg RG do degustador
	 * @param matricula Matrícula do degustador
	 * @param salario Salário do degustador
	 * @param dataDeIngresso Data de ingresso do degustador
	 */
	public Degustador(String nome, String sexo, int rg, int matricula, double salario, Date dataDeIngresso) {
		super(nome, sexo, rg, matricula, salario, dataDeIngresso);
	}
}
