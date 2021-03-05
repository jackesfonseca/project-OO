package model;

import java.util.Date;

/**
 * Superclasse das classes Cozinheiro, Degustador e Editor 
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */

abstract public class Funcionarios 
{
	
	private String nome;
	private String sexo;
	private int rg;
	private int matricula;
	private double salario;
	private Date dataDeIngresso;
	
	/**
	 * Construtor Funcionario
	 * @param nome Nome do funcionario
	 * @param sexo Gênero do funcionario
	 * @param rg RG do funcionario
	 * @param matricula Matrícula do funcionario
	 * @param salario Salário do funcionario
	 * @param dataDeIngresso Data de ingresso do funcionario
	 */
	public Funcionarios(String nome, String sexo, int rg, int matricula, double salario, Date dataDeIngresso) {
		this.nome = nome;
		this.sexo = sexo;
		this.rg = rg;
		this.matricula = matricula;
		this.salario = salario;
		this.dataDeIngresso = dataDeIngresso;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getMatricula() {
		return matricula;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Date getDataDeIngresso() {
		return dataDeIngresso;
	}
	
}
