package controller;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.AvaliaReceita;
import model.Categorias;
import model.Cozinheiro;
import model.Degustador;
import model.Editor;
import model.Ingredientes;
import model.Livros;
import model.Receitas;
import view.UI;

/**
 * Solicita e armazena dados informados pelo usuário além do controle e verificação de informações por meio de validações
 * @author Jackes Fonseca
 * @version 1.0 (Nov 2020)
 */
public class Program 
{
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	static UI ui = new UI();
	
	static Cozinheiro[] cozinheiros;
	static Degustador[] degustadores;
	static Editor[] editores;
	static Categorias[] categorias;
	static Ingredientes[] ingredientes;
	static Livros livros;
	static Receitas[] receitas;
	static AvaliaReceita[] avaliaReceitas;
	static String[] listaCozinheiros = new String[100];
	static String[] listaCozinheirosChef = new String[100];
	static String[] listaEditor = new String[100];
	static String[] listaDegustador = new String[100];
	static String[] listaIngredientes = new String[200];
	static String[] listaCategorias = new String[100];
	static String[] listaReceitas = new String[100];
	static String[] listaReceitasChef = new String[100];
	static String listaLivros;
	static List<Integer> listaMatriculas = new ArrayList<>();
	
	static String cozinheiro;
	static String editor;
	static String degustador;
	static String categoria;
	static String receita;
	
	public static void main(String[] args) throws ParseException 
	{	
		
		try {
			menu();
		
		}catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
												+ "Tipo de dado não compatível com o campo!\n"
												+ "O programa precisa ser reiniciado...", "Atenção", 0);
		}
		
	}
	
	/**
	 * Valida a opção informada pelo usuário no menu da UI
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	private static void menu() throws ParseException
	{
		inicializar();
		int op;
		do
		{
			op = ui.root();
		
		switch(op)
		{
		case 1: cadastroCozinheiro();
			break;
		case 2: cadastroDegustador();
			break;
		case 3: cadastroEditor();
			break;
		case 4: cadastroCategoria();
			break;
		case 5: cadastroReceita();
			break;
		case 6: avaliarReceita();
			break;
		case 7: consultarReceitaAvaliada();
			break;
		case 8: cadastroLivro();
			break;
		case 9: consultaCozinheiro();
			break;
		case 10: consultaDegustador();
			break;
		case 11: consultaEditor();
			break;
		case 12: consultaIngrediente();
			break;
		case 13: consultaCategoria();
			break;
		case 14: exibirReceitaChef();
			break;
		case 15: exibirLivro();
			break;
		case 16: 
			break;	
		
		default : JOptionPane.showMessageDialog(null, "Opção inválida!", "Atenção", 2);
			break;
		}
		
		}while(op != 16);
	}
	

	/**
	 * Realiza a instanciação de objetos
	 */
	private static void inicializar() {
		cozinheiros = new Cozinheiro[100];
		degustadores = new Degustador[100];
		editores = new Editor[100];
		categorias = new Categorias[100];
		ingredientes = new Ingredientes[200];
		receitas = new Receitas[100];
		avaliaReceitas = new AvaliaReceita[100];
	}

	/**
	 * Apresenta ao usuário o livro de receitas em forma de String
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	public static void exibirLivro() throws ParseException {
		// TODO Auto-generated method stub
		String listarLivro = "";
		String listarReceitas = "";
		String listar = "";

		if(listaLivros != null)
		{
			listarLivro = listarLivro + "Título: " + livros.getTitulo() + "\n"
									  + "Isbn: " + livros.getIsbn() + "\n"
									  + "Editor: " + livros.getEditor() + "\n"
									  + "\n";
		}
		
		
		for(int i = 0; i < receitas.length; i++)
		{
			if(receitas[i] != null)
			{
				listarReceitas = listarReceitas + "Nome: " + receitas[i].getNome() + "\n"
												+ "Código: " + receitas[i].getCodigo() + "\n"
												+ "Descrição: " + receitas[i].getDescricao() + "\n"
												+ "Número de porções: " + receitas[i].getNumPorcoes() + "\n"
												+ "Data de criação: " + sdf.format(receitas[i].getDataDeCriacao()) + "\n"
												+ "Cozinheiro: "  + receitas[i].getCozinheiro() + "\n"
												+ "Categoria: " + receitas[i].getCategoria() + "\n"
												+ "Ingredientes: " + receitas[i].exibirIngredientesReceita() + "\n"
												+ "\n";
			}	
			
		}
		
		if(listarReceitas == "")
		{

			listarReceitas = "Nenhuma receita foi cadastrada!";
	
		}
		
		listar = listarLivro + "\n"
				+ listarReceitas + "\n";
		
		JOptionPane.showMessageDialog(null, listar, "Livro de Receitas", 1);
	}
	
	/**
	 * Apresenta ao usuário a relação de receitas dos Chefs em forma de String
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	public static void exibirReceitaChef() throws ParseException {
		// TODO Auto-generated method stub
		String listarReceitasChef = "";
		
		for(int i=0; i<listaCozinheirosChef.length; i++)
		{
			if(listaCozinheirosChef[i] != null)
			{
				for(int j=0; j<receitas.length; j++)
				{
					if(receitas[j] != null)
					{
						if(listaCozinheirosChef[i].equals(receitas[j].getCozinheiro()))
						{
							listarReceitasChef = listarReceitasChef + "Cozinheiro Chef: " + listaCozinheirosChef[i] + "\n"
												+ "Receita: " + receitas[j].getNome() + "\n"
												+ "\n";
						}
					}
				}
			}
		}
		
		if(listarReceitasChef == "")
		{
			listarReceitasChef = "Não existem receitas cadastradas para os Chefs!";
		}
		
		JOptionPane.showMessageDialog(null, listarReceitasChef);
	}

	/**
	 * Apresenta ao usuário as categorias cadastradas em forma de String
	 */
	public static void consultaCategoria() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < categorias.length; i++)
		{
			
			if(categorias[i] != null)
			{
				listar = listar + "Categoria: " + categorias[i].getTipo() + "\n";
			}
		}
		
		if(listar == "")
		{

			listar = "Nenhuma categoria foi cadastrada!";
	
		}
		
		JOptionPane.showMessageDialog(null, listar);
	}

	/**
	 * Apresenta ao usuário os ingredientes cadastrados em forma de String
	 */
	public static void consultaIngrediente() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < ingredientes.length; i++)
		{
			
			if(ingredientes[i] != null)
			{
				listar = listar + "Nome: " + ingredientes[i].getName() + "\n"
								+ "Descrição: " + ingredientes[i].getDescricao() + "\n"
								+ "Quantidade: " + ingredientes[i].getQuantidade() + "\n"
								+ "Medida: " + ingredientes[i].getMedida() + "\n"
								+ "Data de vencimento: " + sdf.format(ingredientes[i].getDataDeVencimento()) + "\n"
								+ "\n";
			}

		}
		
		if(listar == "")
		{
			listar = "Nenhum ingrediente foi cadastrado!";
		}
		
		JOptionPane.showMessageDialog(null, listar);
		
	}

	/**
	 * Apresenta ao usuário a relação de Editores cadastrados em forma de String
	 */
	public static void consultaEditor() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < editores.length; i++)
		{
			
			if(editores[i] != null)
			{
				listar = listar + "Matrícula: " + editores[i].getMatricula() + "\n"
								+ "Nome: " + editores[i].getNome() + "\n"
								+ "Sexo: " + editores[i].getSexo() + "\n"
								+ "Salário: R$" + editores[i].getSalario() + "\n"
								+ "Data de Ingresso: " + sdf.format(editores[i].getDataDeIngresso()) + "\n"
								+ "\n";
			}
		}
		
		if(listar == "")
		{
			listar = "Nenhum editor foi cadastrado!";
		}
		
		JOptionPane.showMessageDialog(null, listar);
		
	}

	/**
	 * Apresenta ao usuário a relação de Degustadores cadastrados em forma de String
	 */
	public static void consultaDegustador() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < degustadores.length; i++)
		{
			
			if(degustadores[i] != null)
			{
				listar = listar + "Matrícula: " + degustadores[i].getMatricula() + "\n"
								+ "Nome: " + degustadores[i].getNome() + "\n"
								+ "Sexo: " + degustadores[i].getSexo() + "\n"
								+ "Salário: R$" + degustadores[i].getSalario() + "\n"
								+ "Data de Ingresso: " + sdf.format(degustadores[i].getDataDeIngresso()) + "\n"
								+ "\n";
			}
		}
		
		if(listar == "")
		{
			listar = "Nenhum degustador foi cadastrado!";
		}
		
		JOptionPane.showMessageDialog(null, listar);
	}

	/**
	 * Apresenta ao usuário a relação de Cozinheiros cadastrados em forma de String
	 */
	public static void consultaCozinheiro() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < cozinheiros.length; i++)
		{
			
			if(cozinheiros[i] != null)
			{
				listar = listar + "Matrícula: " + cozinheiros[i].getMatricula() + "\n"
								+ "Nome: " + cozinheiros[i].getNome() + "\n"
								+ "Sexo: " + cozinheiros[i].getSexo() + "\n"
								+ "Salário: R$" + cozinheiros[i].getSalario() + "\n"
								+ "Data de Ingresso: " + sdf.format(cozinheiros[i].getDataDeIngresso()) + "\n"
								+ "Cozinheiro chef: " + cozinheiros[i].retornaNomeFantasia() + "\n"
								+ "Restaurantes anteriores: " + cozinheiros[i].retornaRestaurantesAnteriores() + "\n"
								+ "\n";
			}
		}
		
		if(listar == "")
		{
			listar = "Nenhum cozinheiro foi cadastrado!";
		}
		
		JOptionPane.showMessageDialog(null, listar);
	}

	/**
	 * Faz a leitura dos dados e a instanciação de um objeto do tipo Livro. Para tal, é realizada uma verificação:
	 * (1) Existencia de ao menos um Editor cadastrado
	 */
	public static void cadastroLivro() {
		// TODO Auto-generated method stub
		if(listaLivros == null) {
			if(listaEditor[0] != null) {
				String titulo = JOptionPane.showInputDialog("Informe o titulo");
				titulo = titulo.toUpperCase();
				int isbn = Integer.parseInt(JOptionPane.showInputDialog("Informe o código ISBN"));
				
				JList<String> jlistaEditores = new JList<String>(listaEditor);
				
				jlistaEditores.addListSelectionListener(new ListSelectionListener() {
		
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						int index = jlistaEditores.getSelectedIndex();
						String editorSelecionado = listaEditor[index];
						editor = editorSelecionado;
					}
						
				});
				
				JOptionPane.showMessageDialog(null, new JScrollPane(jlistaEditores), "Editores", 1);
				
				livros = new Livros(titulo, isbn, editor);
				listaLivros = livros.getTitulo();
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Não existem dados suficientes para avaliar um livro!\n"
						+ "Verifique se existe ao menos um editor cadastrado..\n", "Atenção", 2);
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Já existe um livro cadastrado!", "Atenção", 2);
		}
		
	}
	
	/**
	 * Apresenta ao usuário a relação de recitas avaliadas em forma de String
	 */
	public static void consultarReceitaAvaliada() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < avaliaReceitas.length; i++)
		{	
			if(avaliaReceitas[i] != null)
			{
				listar = listar + "Receita: " + avaliaReceitas[i].getReceita() + "\n"
								+ "Degustador: " + avaliaReceitas[i].getDegustador() + "\n"
								+ "Data da degustação: " + sdf.format(avaliaReceitas[i].getDataDeDegustacao()) + "\n"
								+ "Nota: " + avaliaReceitas[i].getNota() + "\n"
 								+ "\n";
			}
		}
		
		if(listar == "")
		{
			listar = "Nenhuma receita foi avaliada!";
		}
		
		JOptionPane.showMessageDialog(null, listar);
		
	}

	/**
	 * Faz a leitura dos dados e a instanciação de um objeto do tipo AvaliaReceita. Para tal, são realizada três verificações:
	 * (1) Posição disponível no array avaliaReceitas
	 * (2) Existencia de ao menos uma Receita cadastrada
	 * (3) Existência de ao menos um Degustador cadastrado
	 * @throws HeadlessException lançamento de exceção do tipo HeadlessException
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	public static void avaliarReceita() throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
		int indice = pesquisaPosicaoAvaliarReceita();
		
		if(indice >= 0) {
			if(listaReceitas[0] != null && listaDegustador[0] != null) {
				JList<String> jlistaReceitas = new JList<String>(listaReceitas);
				
				jlistaReceitas.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						int index = jlistaReceitas.getSelectedIndex();
						String receitaSelecionada = listaReceitas[index];
						receita = receitaSelecionada;
					}
				});
				
				JOptionPane.showMessageDialog(null,  new JScrollPane(jlistaReceitas), "Receitas", 1);
				
				Date dataDeDegustacao = null;
				try {
					dataDeDegustacao = sdf.parse(JOptionPane.showInputDialog("Informe a data de degustação"));
				}catch(ParseException e)
				{
					JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
							+ "Tipo de dado não compatível com o campo!\n"
							+ "O programa precisa ser reiniciado...", "Atenção", 0);
					System.exit(0);
				}
				
				JList<String> jlistaDegustador = new JList<String>(listaDegustador);
				
				jlistaDegustador.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						int index = jlistaDegustador.getSelectedIndex();
						String degustadorSelecionado = listaDegustador[index];
						degustador = degustadorSelecionado;
					}
				});
				
				JOptionPane.showMessageDialog(null,  new JScrollPane(jlistaDegustador), "Degustador", 1);
				
				double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota"));
				
				avaliaReceitas[indice] = new AvaliaReceita(receita, dataDeDegustacao, nota, degustador);
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Não existem dados suficientes para avaliar uma receita!\n"
						+ "Verifique se existe ao menos um degustador e uma receita cadastrada..\n", "Atenção", 2);
			}
		}	
	}

	/**
	 * Verifica se existem posições disponíveis no array avaliaReceitas
	 * @return o índice, caso tenham posições disponíveis ou então -1 caso contrário
	 */
	public static int pesquisaPosicaoAvaliarReceita() {
		// TODO Auto-generated method stub
		for(int i = 0; i < avaliaReceitas.length; i++)
		{
			if(avaliaReceitas[i] == null)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Faz a leitura dos dados e a instanciação de um objeto do tipo Receita e Ingrediente. Para tal, são realizada quatro verificações:
	 * (1) Posição disponível no array receitas
	 * (2) Existencia de ao menos uma Categoria cadastrada
	 * (3) Existência de ao menos um Cozinheiro cadastrado
	 * (4) Posição disponível no array ingredientes
	 * @throws HeadlessException lançamento de exceção do tipo HeadlessException
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	public static void cadastroReceita() throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
		int indice = pesquisarPosicaoReceita();

		if(indice >= 0) {
			int codigo;
			
			if(listaCategorias[0] != null && listaCozinheiros[0] != null )
			{
				do {
					codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da receita"));
					if(verificarCodigo(codigo))
					{
						JOptionPane.showMessageDialog(null, "Código já existente!", "Atenção", 2);
					}
				}while(verificarCodigo(codigo));
				
				String nome = JOptionPane.showInputDialog("Informe o nome da receita");
				nome = nome.toUpperCase();
				String descricao = JOptionPane.showInputDialog("Informe a descrição da receita");
				descricao = descricao.toUpperCase();
				int numPorcoes = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de porções da receita"));
				
				Date dataDeCriacao = null;
				try {
					dataDeCriacao = sdf.parse(JOptionPane.showInputDialog("Informe a data de criação da receita"));
				}catch(ParseException e)
				{
					JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
							+ "Tipo de dado não compatível com o campo!\n"
							+ "O programa precisa ser reiniciado...", "Atenção", 0);
					System.exit(0);
				}
				
				JList<String> jlistaCozinheiros = new JList<String>(listaCozinheiros);
				
				jlistaCozinheiros.addListSelectionListener(new ListSelectionListener() {
		
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						int index = jlistaCozinheiros.getSelectedIndex();
						String cozinheiroSelecionado = listaCozinheiros[index];
						cozinheiro = cozinheiroSelecionado;
					}
						
				});
			
				JOptionPane.showMessageDialog(null, new JScrollPane(jlistaCozinheiros), "Cozinheiros", 1);
			
				JList<String> jlistaCategorias = new JList<String>(listaCategorias);
				jlistaCategorias.addListSelectionListener(new ListSelectionListener() {
		
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						int index = jlistaCategorias.getSelectedIndex();
						String categoriaSelecionada = listaCategorias[index];
						categoria = categoriaSelecionada;
					}
					
				});
				
				JOptionPane.showMessageDialog(null, new JScrollPane(jlistaCategorias), "Categorias", 1);
				
				receitas[indice] = new Receitas(nome, codigo, descricao, numPorcoes, dataDeCriacao, cozinheiro, categoria);
				listaReceitas[indice] = receitas[indice].getNome();
				
				int op = 1;
			
				do {
					
					int indiceIngrediente = pesquisarPosicaoIngrediente();
					
					if(indiceIngrediente >= 0)
					{
						String nomeIngrediente = JOptionPane.showInputDialog("Informe o nome do ingrediente");
						nomeIngrediente = nomeIngrediente.toUpperCase();
						String descricaoIngrediente = JOptionPane.showInputDialog("Informe a descrição do ingrediente");
						descricaoIngrediente = descricaoIngrediente.toUpperCase();
						int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade do ingrediente"));
						String medida = JOptionPane.showInputDialog("Informe a medida do ingrediente (ex. colher de chá, ml, kg, unidade)");
						medida = medida.toUpperCase();
						
						Date dataDeVencimento = null;
						try {
							dataDeVencimento = sdf.parse(JOptionPane.showInputDialog("Informe a data de validade do ingrediente"));
						}catch(ParseException e)
						{
							JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
									+ "Tipo de dado não compatível com o campo!\n"
									+ "O programa precisa ser reiniciado...", "Atenção", 0);
							System.exit(0);
						}
						
						ingredientes[indiceIngrediente] = new Ingredientes(nomeIngrediente, descricaoIngrediente, quantidade, medida, dataDeVencimento);
						receitas[indice].adicionarIngedienteReceita(ingredientes[indiceIngrediente].getName());
					}
					listaIngredientes[indiceIngrediente] = ingredientes[indiceIngrediente].getName();
					
					op = Integer.parseInt(JOptionPane.showInputDialog("Deseja acrescentar mais um ingrediente?\n"
																		+ "1 - Sim\n"
																		+ "0 - Não\n"));
				}while(op == 1);
				
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Não existem dados suficientes para cadastrar uma receita!\n"
													+ "Verifique se existe ao menos um cozinheiro e uma categoria cadastrada..\n", "Atenção", 2);
			}
		}
		
	}

	/**
	 * Verifica se o código da receita informado pelo usuário já existe
	 * @param codigo um inteiro que contém o codigo a ser validado
	 * @return verdadeiro ou falso, indicando se o código pe válido
	 */
	public static boolean verificarCodigo(int codigo) {
		// TODO Auto-generated method stub
		for(int i = 0; i < receitas.length; i++)
		{
			if(receitas[i] != null && receitas[i].getCodigo() == codigo)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Verifica se existem posições disponíveis no array receitas
	 * @return o índice, caso tenham posições disponíveis ou então -1 caso contrário
	 */
	public static int pesquisarPosicaoReceita() {
		// TODO Auto-generated method stub
		for(int i = 0; i < receitas.length; i++)
		{
			if(receitas[i] == null)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Verifica se existem posições disponíveis no array ingredientes
	 * @return o índice, caso tenham posições disponíveis ou então -1 caso contrário
	 */
	public static int pesquisarPosicaoIngrediente() {
		// TODO Auto-generated method stub
		for(int i = 0; i < ingredientes.length; i++)
		{
			if(ingredientes[i] == null)
			{
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Faz a leitura dos dados e a instanciação de um objeto do tipo Categoria. Para tal, é realizada uma verificação:
	 * (1) Posição disponível no array categorias
	 */
	public static void cadastroCategoria() {
		// TODO Auto-generated method stub
		int indice = pesquisarPosicaoCategoria();
		
		if(indice >= 0) {
			String tipo = JOptionPane.showInputDialog("Informe o tipo");
			tipo = tipo.toUpperCase();
			categorias[indice] = new Categorias(tipo);
		}else{
			JOptionPane.showMessageDialog(null, "Lista cheia");
		}
		
		listaCategorias[indice] = categorias[indice].getTipo();
	}

	/**
	 * Verifica se existem posições disponíveis no array categorias
	 * @return o índice, caso tenham posições disponíveis ou então -1 caso contrário
	 */
	public static int pesquisarPosicaoCategoria() {
		// TODO Auto-generated method stub
		for(int i = 0; i < categorias.length; i++)
		{
			if(categorias[i] == null)
			{
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Faz a leitura dos dados e a instanciação de um objeto do tipo Editor. Para tal, é realizado uma verificação:
	 * (1) Posição disponível no array editores
	 * @throws HeadlessException lançamento de exceção do tipo HeadlessException
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	public static void cadastroEditor() throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
		int indice = pesquisarPosicaoEditor();
		
		if(indice >= 0) {
			int matricula;
			do {
				matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matrícula"));
				if(verificarMatricula(matricula))
				{
					JOptionPane.showMessageDialog(null, "Matrícula já existente!", "Atenção", 2);
				}
			}while(verificarMatricula(matricula));
			
			String nome = JOptionPane.showInputDialog("Informe o nome");
			nome = nome.toUpperCase();
			
			String sexo;
			do {
				sexo = JOptionPane.showInputDialog("Informe o gênero");
				if(!validaGenero(sexo))
				{
					JOptionPane.showMessageDialog(null, "Gênero inválido!\n"
														+ "\n masculino ou feminino", "Atenção", 2);
				}
			}while(!validaGenero(sexo));
			
			sexo = sexo.toUpperCase();
			int rg = Integer.parseInt(JOptionPane.showInputDialog("Informe o rg"));
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Informe o salario"));
			
			Date dataDeIngresso = null;
			try {
				dataDeIngresso = sdf.parse(JOptionPane.showInputDialog("Data de Ingresso"));
			}catch(ParseException e)
			{
				JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
						+ "Tipo de dado não compatível com o campo!\n"
						+ "O programa precisa ser reiniciado...", "Atenção", 0);
				System.exit(0);
			}
			
			editores[indice] = new Editor(nome, sexo, rg, matricula, salario, dataDeIngresso);
			listaMatriculas.add(matricula);
		}
		
		listaEditor[indice] = editores[indice].getNome();
	}

	/**
	 * Verifica se existem posições disponíveis no array editores
	 * @return o índice, caso tenham posições disponíveis ou então -1 caso contrário
	 */
	public static int pesquisarPosicaoEditor() {
		// TODO Auto-generated method stub
		for(int i = 0; i < editores.length; i++)
		{
			if(editores[i] == null)
			{
				return i;
			}
		}
		
		return -1;
	}

	
	/**
	 * Faz a leitura dos dados e a instanciação de um objeto do tipo Degustador. Para tal, é realizado uma verificação:
	 * (1) Posição disponível no array degustadores
	 * @throws HeadlessException lançamento de exceção do tipo HeadlessException
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	public static void cadastroDegustador() throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
		int indice = pesquisarPosicaoDegustador();
		
		if(indice >= 0) {
			int matricula;
			do {
				matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matrícula"));
				if(verificarMatricula(matricula))
				{
					JOptionPane.showMessageDialog(null, "Matrícula já existente!", "Atenção", 2);
				}
			}while(verificarMatricula(matricula));
			
			String nome = JOptionPane.showInputDialog("Informe o nome");
			nome = nome.toUpperCase();
			
			String sexo;
			do {
				sexo = JOptionPane.showInputDialog("Informe o gênero");
				if(!validaGenero(sexo))
				{
					JOptionPane.showMessageDialog(null, "Gênero inválido!\n"
														+ "\n masculino ou feminino", "Atenção", 2);
				}
			}while(!validaGenero(sexo));
			
			sexo = sexo.toUpperCase();
			int rg = Integer.parseInt(JOptionPane.showInputDialog("Informe o rg"));
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Informe o salario"));
			Date dataDeIngresso = null;
			try {
				dataDeIngresso = sdf.parse(JOptionPane.showInputDialog("Data de Ingresso"));
			}catch(ParseException e)
			{
				JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
						+ "Tipo de dado não compatível com o campo!\n"
						+ "O programa precisa ser reiniciado...", "Atenção", 0);
				System.exit(0);
			}
			
			degustadores[indice] = new Degustador(nome, sexo, rg, matricula, salario, dataDeIngresso);
			listaMatriculas.add(matricula);
		}
		
		listaDegustador[indice] = degustadores[indice].getNome();
	}

	/**
	 * Verifica se existem posições disponíveis no array degustadores
	 * @return o índice, caso tenham posições disponíveis ou então -1 caso contrário
	 */
	public static int pesquisarPosicaoDegustador() {
		// TODO Auto-generated method stub
		for(int i = 0; i < degustadores.length; i++)
		{
			if(degustadores[i] == null)
			{
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Faz a leitura dos dados e a instanciação de um objeto do tipo Cozinheiro. Para tal, é realizado uma verificação:
	 * (1) Posição disponível no array cozinheiros
	 * @throws HeadlessException lançamento de exceção do tipo HeadlessException
	 * @throws ParseException lançamento de exceção do tipo ParseException
	 */
	public static void cadastroCozinheiro() throws HeadlessException, ParseException {
		int indice = pesquisarPosicaoCozinheiro();
		
		if(indice >= 0) {
			int matricula;
			do {
				matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matrícula"));
				if(verificarMatricula(matricula))
				{
					JOptionPane.showMessageDialog(null, "Matrícula já existente!", "Atenção", 2);
				}
			}while(verificarMatricula(matricula));
				
			String nome = JOptionPane.showInputDialog("Informe o nome");
			nome = nome.toUpperCase();
			
			String sexo;
			do {
				sexo = JOptionPane.showInputDialog("Informe o gênero");
				if(!validaGenero(sexo))
				{
					JOptionPane.showMessageDialog(null, "Gênero inválido!\n"
														+ "\n masculino ou feminino", "Atenção", 2);
				}
			}while(!validaGenero(sexo));
			sexo = sexo.toUpperCase();
			
			int rg = Integer.parseInt(JOptionPane.showInputDialog("Informe o rg"));			
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Informe o salario"));
			Date dataDeIngresso = null;
			try {
				dataDeIngresso = sdf.parse(JOptionPane.showInputDialog("Data de Ingresso"));
			}catch(ParseException e)
			{
				JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
						+ "Tipo de dado não compatível com o campo!\n"
						+ "O programa precisa ser reiniciado...", "Atenção", 0);
				System.exit(0);
			}
			
			int cozinheiroChef= Integer.parseInt(JOptionPane.showInputDialog("Cozinheiro chef\n"
					+ "1 - Sim\n"
					+ "0 - Não\n"));
			boolean isChef;
			
			if(cozinheiroChef == 1)
			{
				isChef = true;
			}
			else
			{
				isChef = false;
			}
			
			if(isChef)
			{
				String restaurantesAnteriores = JOptionPane.showInputDialog("Informe a lista de restaurantes");
				cozinheiros[indice] = new Cozinheiro(nome, sexo, rg, matricula, salario, dataDeIngresso, isChef, restaurantesAnteriores);
				listaCozinheirosChef[indice] = cozinheiros[indice].getNome();
				listaMatriculas.add(matricula);
			}
			else {
			cozinheiros[indice] = new Cozinheiro(nome, sexo, rg, matricula, salario, dataDeIngresso, isChef);
			listaMatriculas.add(matricula);
			}
		}
		listaCozinheiros[indice] = cozinheiros[indice].getNome();
	}

	/**
	 * Verifica se o gênero fornecido está no formado válido
	 * @param sexo uma String que contém o gênero a ser verificado
	 * @return verdadeiro ou falso, se o gênero é ou não válido
	 */
	public static boolean validaGenero(String sexo)
	{
		sexo = sexo.toUpperCase();
		if(sexo.equals("MASCULINO") || sexo.equals("FEMININO"))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param matricula um inteiro que contém uma matrícula a ser verificada
	 * @return verdadeiro ou falso, se a matrícula é válida ou não
	 */
	private static boolean verificarMatricula(int matricula) {
		// TODO Auto-generated method stub
		for(Integer mat : listaMatriculas) {
			if(mat == matricula)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Verifica se existem posições disponíveis no array cozinheiros
	 * @return o índice, caso tenham posições disponíveis ou então -1 caso contrário
	 */
	public static int pesquisarPosicaoCozinheiro() {
		// TODO Auto-generated method stub
		for(int i = 0; i < cozinheiros.length; i++)
		{
			if(cozinheiros[i] == null)
			{
				return i;
			}
		}
		
		return -1;
	}

}
