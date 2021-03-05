package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Cria um objeto para Receitas
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class Receitas 
{
	private String nome;
	private int codigo;
	private String descricao;
	private int numPorcoes;
	private Date dataDeCriacao;
	private String cozinheiro;
	private String categoria;
	private List<String> ingredientes = new ArrayList<String>();
	
	/**
	 * Construtor Receitas
	 * @param nome Nome da receita
	 * @param codigo Código da receita
	 * @param descricao Descrição da receita
	 * @param numPorcoes Número de porções da receita
	 * @param dataDeCriacao Data de criação da receita
	 * @param cozinheiro Cozinheiro da receita
	 * @param categoria Categoria da receita
	 */
	public Receitas(String nome, int codigo, String descricao, int numPorcoes, Date dataDeCriacao,
			String cozinheiro, String categoria) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.descricao = descricao;
		this.numPorcoes = numPorcoes;
		this.dataDeCriacao = dataDeCriacao;
		this.cozinheiro = cozinheiro;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumPorcoes() {
		return numPorcoes;
	}

	public void setNumPorcoes(int numPorcoes) {
		this.numPorcoes = numPorcoes;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public String getCozinheiro() {
		return cozinheiro;
	}

	public void setCozinheiro(String cozinheiro) {
		this.cozinheiro = cozinheiro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Concatena todos os ingredientes da receita em uma String
	 * @return String que contém todos os ingredientes da receita
	 */
	public String exibirIngredientesReceita() {
		String listarIngredientes = "";
		
		for(String ing : ingredientes)
		{
			listarIngredientes = listarIngredientes + ing + ", ";
		}
		return listarIngredientes;
	}
	
	/**
	 * Adiciona um novo ingrediente à receita
	 * @param ingrediente a ser adicionado na receita
	 */
	public void adicionarIngedienteReceita(String ingrediente)
	{
		ingredientes.add(ingrediente);
	}

}
