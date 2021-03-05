package model;

import java.util.Date;

/**
 * Subclasse da Classe Funcionario, Cria um obejto para Editor
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class Editor extends Funcionarios
{
	/**
	 * Construtor Editor
	 * @param nome Nome do editor
	 * @param sexo G�nero do editor
	 * @param rg RG do editor
	 * @param matricula Matr�cula do editor
	 * @param salario Sal�rio do editor
	 * @param dataDeIngresso Data de ingresso do editor
	 */
	public Editor(String nome, String sexo, int rg, int matricula, double salario, Date dataDeIngresso)
	{
		super(nome, sexo, rg, matricula, salario, dataDeIngresso);
	}
}
