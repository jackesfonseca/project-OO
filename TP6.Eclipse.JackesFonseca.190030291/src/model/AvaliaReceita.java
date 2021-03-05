package model;

import java.util.Date;

/**
 * Cria um obejto para AvaliaReceitas
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class AvaliaReceita 
{
	private String receita;
	private Date dataDeDegustacao;
	private double nota;
	private String degustador;
	
	/**
	 * Construtor AvaliaReceira
	 * @param receita Receita a ser avaliada
	 * @param dataDeDegustacao Data em que a receita foia avaliada
	 * @param nota Nota atribuida pelo debustador à receita
	 * @param degustador Degustador responsável por avaliar a receita
	 */
	public AvaliaReceita(String receita, Date dataDeDegustacao, double nota, String degustador) {
		this.receita = receita;
		this.dataDeDegustacao = dataDeDegustacao;
		this.nota = nota;
		this.degustador = degustador;
	}
	public String getReceita() {
		return receita;
	}
	public void setReceita(String receita) {
		this.receita = receita;
	}
	public Date getDataDeDegustacao() {
		return dataDeDegustacao;
	}
	public void setDataDeDegustacao(Date dataDeDegustacao) {
		this.dataDeDegustacao = dataDeDegustacao;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public String getDegustador() {
		return degustador;
	}
	
	public void setDegustador(String editor) {
		this.degustador = editor;
	}
}
