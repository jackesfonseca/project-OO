package model;

import java.util.Date;

/**
 * Cria um obejto para Ingredientes
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class Ingredientes 
{
	private String nome;
	private String Descricao;
	private int quantidade;
	private String medida;//Ex.: Colher de chá, ml, etc...
	private Date dataDeVencimento;
	
	/**
	 * Construtor Ingredientes
	 * @param nome Nome do ingrediente
	 * @param descricao Descrição do ingrediente
	 * @param quantidade Quantidade do ingrediente
	 * @param medida Medida do ingrediente
	 * @param dataDeVencimento Data de vencimento do ingrediente
	 */
	public Ingredientes(String nome, String descricao, int quantidade, String medida, Date dataDeVencimento) {
		super();
		this.nome = nome;
		Descricao = descricao;
		this.quantidade = quantidade;
		this.medida = medida;
		this.dataDeVencimento = dataDeVencimento;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public Date getDataDeVencimento() {
		return dataDeVencimento;
	}
	
}
