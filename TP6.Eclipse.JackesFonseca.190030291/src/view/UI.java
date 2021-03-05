package view;

import javax.swing.JOptionPane;

/**
 * Gera o menu iniciar possibilitando a interação com o usuário de forma dinâmica
 * @author Jackes Fonseca
 * @version 1.0 (Nov 2020)
 */
public class UI 
{
	/**
	 * Exibe as opções disponíveis e armazena o valor informado
	 * @return Opção informada pelo usuário
	 */
	public int root()
	{
		int op;
		
		op = Integer.parseInt(JOptionPane.showInputDialog("SISTEMA DE RECEITAS\n"
											+ "\n"
											+ "1 - Cadastrar Cozinheiro\n"
											+ "2 - Cadastrar Degustador\n"
											+ "3 - Cadastrar Editor\n"
											+ "4 - Cadastrar Categoria\n"
											+ "5 - Cadastrar Receita\n"
											+ "6 - Avaliar Receita\n"
											+ "7 - Consultar Receita Avaliada\n"
											+ "8 - Cadastrar Livro\n"
											+ "9 - Consultar Cozinheiro\n"
											+ "10 - Consultar Degustador\n"
											+ "11 - Consultar Editor\n"
											+ "12 - Consultar Ingediente\n"
											+ "13 - Consultar Categoria\n"
											+ "14 - Exibir Receitas Chef\n"
											+ "15 - Exibir Livro \n"
											+ "16 - Sair\n"));
		return op;
	}
}
