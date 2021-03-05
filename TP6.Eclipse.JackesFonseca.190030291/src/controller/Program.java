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
 * Solicita e armazena dados informados pelo usu�rio al�m do controle e verifica��o de informa��es por meio de valida��es
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
												+ "Tipo de dado n�o compat�vel com o campo!\n"
												+ "O programa precisa ser reiniciado...", "Aten��o", 0);
		}
		
	}
	
	/**
	 * Valida a op��o informada pelo usu�rio no menu da UI
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
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
		
		default : JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Aten��o", 2);
			break;
		}
		
		}while(op != 16);
	}
	

	/**
	 * Realiza a instancia��o de objetos
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
	 * Apresenta ao usu�rio o livro de receitas em forma de String
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
	 */
	public static void exibirLivro() throws ParseException {
		// TODO Auto-generated method stub
		String listarLivro = "";
		String listarReceitas = "";
		String listar = "";

		if(listaLivros != null)
		{
			listarLivro = listarLivro + "T�tulo: " + livros.getTitulo() + "\n"
									  + "Isbn: " + livros.getIsbn() + "\n"
									  + "Editor: " + livros.getEditor() + "\n"
									  + "\n";
		}
		
		
		for(int i = 0; i < receitas.length; i++)
		{
			if(receitas[i] != null)
			{
				listarReceitas = listarReceitas + "Nome: " + receitas[i].getNome() + "\n"
												+ "C�digo: " + receitas[i].getCodigo() + "\n"
												+ "Descri��o: " + receitas[i].getDescricao() + "\n"
												+ "N�mero de por��es: " + receitas[i].getNumPorcoes() + "\n"
												+ "Data de cria��o: " + sdf.format(receitas[i].getDataDeCriacao()) + "\n"
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
	 * Apresenta ao usu�rio a rela��o de receitas dos Chefs em forma de String
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
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
			listarReceitasChef = "N�o existem receitas cadastradas para os Chefs!";
		}
		
		JOptionPane.showMessageDialog(null, listarReceitasChef);
	}

	/**
	 * Apresenta ao usu�rio as categorias cadastradas em forma de String
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
	 * Apresenta ao usu�rio os ingredientes cadastrados em forma de String
	 */
	public static void consultaIngrediente() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < ingredientes.length; i++)
		{
			
			if(ingredientes[i] != null)
			{
				listar = listar + "Nome: " + ingredientes[i].getName() + "\n"
								+ "Descri��o: " + ingredientes[i].getDescricao() + "\n"
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
	 * Apresenta ao usu�rio a rela��o de Editores cadastrados em forma de String
	 */
	public static void consultaEditor() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < editores.length; i++)
		{
			
			if(editores[i] != null)
			{
				listar = listar + "Matr�cula: " + editores[i].getMatricula() + "\n"
								+ "Nome: " + editores[i].getNome() + "\n"
								+ "Sexo: " + editores[i].getSexo() + "\n"
								+ "Sal�rio: R$" + editores[i].getSalario() + "\n"
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
	 * Apresenta ao usu�rio a rela��o de Degustadores cadastrados em forma de String
	 */
	public static void consultaDegustador() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < degustadores.length; i++)
		{
			
			if(degustadores[i] != null)
			{
				listar = listar + "Matr�cula: " + degustadores[i].getMatricula() + "\n"
								+ "Nome: " + degustadores[i].getNome() + "\n"
								+ "Sexo: " + degustadores[i].getSexo() + "\n"
								+ "Sal�rio: R$" + degustadores[i].getSalario() + "\n"
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
	 * Apresenta ao usu�rio a rela��o de Cozinheiros cadastrados em forma de String
	 */
	public static void consultaCozinheiro() {
		// TODO Auto-generated method stub
		String listar = "";
		
		for(int i = 0; i < cozinheiros.length; i++)
		{
			
			if(cozinheiros[i] != null)
			{
				listar = listar + "Matr�cula: " + cozinheiros[i].getMatricula() + "\n"
								+ "Nome: " + cozinheiros[i].getNome() + "\n"
								+ "Sexo: " + cozinheiros[i].getSexo() + "\n"
								+ "Sal�rio: R$" + cozinheiros[i].getSalario() + "\n"
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
	 * Faz a leitura dos dados e a instancia��o de um objeto do tipo Livro. Para tal, � realizada uma verifica��o:
	 * (1) Existencia de ao menos um Editor cadastrado
	 */
	public static void cadastroLivro() {
		// TODO Auto-generated method stub
		if(listaLivros == null) {
			if(listaEditor[0] != null) {
				String titulo = JOptionPane.showInputDialog("Informe o titulo");
				titulo = titulo.toUpperCase();
				int isbn = Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo ISBN"));
				
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
				JOptionPane.showMessageDialog(null, "N�o existem dados suficientes para avaliar um livro!\n"
						+ "Verifique se existe ao menos um editor cadastrado..\n", "Aten��o", 2);
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null, "J� existe um livro cadastrado!", "Aten��o", 2);
		}
		
	}
	
	/**
	 * Apresenta ao usu�rio a rela��o de recitas avaliadas em forma de String
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
								+ "Data da degusta��o: " + sdf.format(avaliaReceitas[i].getDataDeDegustacao()) + "\n"
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
	 * Faz a leitura dos dados e a instancia��o de um objeto do tipo AvaliaReceita. Para tal, s�o realizada tr�s verifica��es:
	 * (1) Posi��o dispon�vel no array avaliaReceitas
	 * (2) Existencia de ao menos uma Receita cadastrada
	 * (3) Exist�ncia de ao menos um Degustador cadastrado
	 * @throws HeadlessException lan�amento de exce��o do tipo HeadlessException
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
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
					dataDeDegustacao = sdf.parse(JOptionPane.showInputDialog("Informe a data de degusta��o"));
				}catch(ParseException e)
				{
					JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
							+ "Tipo de dado n�o compat�vel com o campo!\n"
							+ "O programa precisa ser reiniciado...", "Aten��o", 0);
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
				JOptionPane.showMessageDialog(null, "N�o existem dados suficientes para avaliar uma receita!\n"
						+ "Verifique se existe ao menos um degustador e uma receita cadastrada..\n", "Aten��o", 2);
			}
		}	
	}

	/**
	 * Verifica se existem posi��es dispon�veis no array avaliaReceitas
	 * @return o �ndice, caso tenham posi��es dispon�veis ou ent�o -1 caso contr�rio
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
	 * Faz a leitura dos dados e a instancia��o de um objeto do tipo Receita e Ingrediente. Para tal, s�o realizada quatro verifica��es:
	 * (1) Posi��o dispon�vel no array receitas
	 * (2) Existencia de ao menos uma Categoria cadastrada
	 * (3) Exist�ncia de ao menos um Cozinheiro cadastrado
	 * (4) Posi��o dispon�vel no array ingredientes
	 * @throws HeadlessException lan�amento de exce��o do tipo HeadlessException
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
	 */
	public static void cadastroReceita() throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
		int indice = pesquisarPosicaoReceita();

		if(indice >= 0) {
			int codigo;
			
			if(listaCategorias[0] != null && listaCozinheiros[0] != null )
			{
				do {
					codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da receita"));
					if(verificarCodigo(codigo))
					{
						JOptionPane.showMessageDialog(null, "C�digo j� existente!", "Aten��o", 2);
					}
				}while(verificarCodigo(codigo));
				
				String nome = JOptionPane.showInputDialog("Informe o nome da receita");
				nome = nome.toUpperCase();
				String descricao = JOptionPane.showInputDialog("Informe a descri��o da receita");
				descricao = descricao.toUpperCase();
				int numPorcoes = Integer.parseInt(JOptionPane.showInputDialog("Informe o n�mero de por��es da receita"));
				
				Date dataDeCriacao = null;
				try {
					dataDeCriacao = sdf.parse(JOptionPane.showInputDialog("Informe a data de cria��o da receita"));
				}catch(ParseException e)
				{
					JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
							+ "Tipo de dado n�o compat�vel com o campo!\n"
							+ "O programa precisa ser reiniciado...", "Aten��o", 0);
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
						String descricaoIngrediente = JOptionPane.showInputDialog("Informe a descri��o do ingrediente");
						descricaoIngrediente = descricaoIngrediente.toUpperCase();
						int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade do ingrediente"));
						String medida = JOptionPane.showInputDialog("Informe a medida do ingrediente (ex. colher de ch�, ml, kg, unidade)");
						medida = medida.toUpperCase();
						
						Date dataDeVencimento = null;
						try {
							dataDeVencimento = sdf.parse(JOptionPane.showInputDialog("Informe a data de validade do ingrediente"));
						}catch(ParseException e)
						{
							JOptionPane.showMessageDialog(null, "ERRO FATAL\n\n" 
									+ "Tipo de dado n�o compat�vel com o campo!\n"
									+ "O programa precisa ser reiniciado...", "Aten��o", 0);
							System.exit(0);
						}
						
						ingredientes[indiceIngrediente] = new Ingredientes(nomeIngrediente, descricaoIngrediente, quantidade, medida, dataDeVencimento);
						receitas[indice].adicionarIngedienteReceita(ingredientes[indiceIngrediente].getName());
					}
					listaIngredientes[indiceIngrediente] = ingredientes[indiceIngrediente].getName();
					
					op = Integer.parseInt(JOptionPane.showInputDialog("Deseja acrescentar mais um ingrediente?\n"
																		+ "1 - Sim\n"
																		+ "0 - N�o\n"));
				}while(op == 1);
				
			}
			
			else {
				JOptionPane.showMessageDialog(null, "N�o existem dados suficientes para cadastrar uma receita!\n"
													+ "Verifique se existe ao menos um cozinheiro e uma categoria cadastrada..\n", "Aten��o", 2);
			}
		}
		
	}

	/**
	 * Verifica se o c�digo da receita informado pelo usu�rio j� existe
	 * @param codigo um inteiro que cont�m o codigo a ser validado
	 * @return verdadeiro ou falso, indicando se o c�digo pe v�lido
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
	 * Verifica se existem posi��es dispon�veis no array receitas
	 * @return o �ndice, caso tenham posi��es dispon�veis ou ent�o -1 caso contr�rio
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
	 * Verifica se existem posi��es dispon�veis no array ingredientes
	 * @return o �ndice, caso tenham posi��es dispon�veis ou ent�o -1 caso contr�rio
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
	 * Faz a leitura dos dados e a instancia��o de um objeto do tipo Categoria. Para tal, � realizada uma verifica��o:
	 * (1) Posi��o dispon�vel no array categorias
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
	 * Verifica se existem posi��es dispon�veis no array categorias
	 * @return o �ndice, caso tenham posi��es dispon�veis ou ent�o -1 caso contr�rio
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
	 * Faz a leitura dos dados e a instancia��o de um objeto do tipo Editor. Para tal, � realizado uma verifica��o:
	 * (1) Posi��o dispon�vel no array editores
	 * @throws HeadlessException lan�amento de exce��o do tipo HeadlessException
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
	 */
	public static void cadastroEditor() throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
		int indice = pesquisarPosicaoEditor();
		
		if(indice >= 0) {
			int matricula;
			do {
				matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matr�cula"));
				if(verificarMatricula(matricula))
				{
					JOptionPane.showMessageDialog(null, "Matr�cula j� existente!", "Aten��o", 2);
				}
			}while(verificarMatricula(matricula));
			
			String nome = JOptionPane.showInputDialog("Informe o nome");
			nome = nome.toUpperCase();
			
			String sexo;
			do {
				sexo = JOptionPane.showInputDialog("Informe o g�nero");
				if(!validaGenero(sexo))
				{
					JOptionPane.showMessageDialog(null, "G�nero inv�lido!\n"
														+ "\n masculino ou feminino", "Aten��o", 2);
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
						+ "Tipo de dado n�o compat�vel com o campo!\n"
						+ "O programa precisa ser reiniciado...", "Aten��o", 0);
				System.exit(0);
			}
			
			editores[indice] = new Editor(nome, sexo, rg, matricula, salario, dataDeIngresso);
			listaMatriculas.add(matricula);
		}
		
		listaEditor[indice] = editores[indice].getNome();
	}

	/**
	 * Verifica se existem posi��es dispon�veis no array editores
	 * @return o �ndice, caso tenham posi��es dispon�veis ou ent�o -1 caso contr�rio
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
	 * Faz a leitura dos dados e a instancia��o de um objeto do tipo Degustador. Para tal, � realizado uma verifica��o:
	 * (1) Posi��o dispon�vel no array degustadores
	 * @throws HeadlessException lan�amento de exce��o do tipo HeadlessException
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
	 */
	public static void cadastroDegustador() throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
		int indice = pesquisarPosicaoDegustador();
		
		if(indice >= 0) {
			int matricula;
			do {
				matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matr�cula"));
				if(verificarMatricula(matricula))
				{
					JOptionPane.showMessageDialog(null, "Matr�cula j� existente!", "Aten��o", 2);
				}
			}while(verificarMatricula(matricula));
			
			String nome = JOptionPane.showInputDialog("Informe o nome");
			nome = nome.toUpperCase();
			
			String sexo;
			do {
				sexo = JOptionPane.showInputDialog("Informe o g�nero");
				if(!validaGenero(sexo))
				{
					JOptionPane.showMessageDialog(null, "G�nero inv�lido!\n"
														+ "\n masculino ou feminino", "Aten��o", 2);
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
						+ "Tipo de dado n�o compat�vel com o campo!\n"
						+ "O programa precisa ser reiniciado...", "Aten��o", 0);
				System.exit(0);
			}
			
			degustadores[indice] = new Degustador(nome, sexo, rg, matricula, salario, dataDeIngresso);
			listaMatriculas.add(matricula);
		}
		
		listaDegustador[indice] = degustadores[indice].getNome();
	}

	/**
	 * Verifica se existem posi��es dispon�veis no array degustadores
	 * @return o �ndice, caso tenham posi��es dispon�veis ou ent�o -1 caso contr�rio
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
	 * Faz a leitura dos dados e a instancia��o de um objeto do tipo Cozinheiro. Para tal, � realizado uma verifica��o:
	 * (1) Posi��o dispon�vel no array cozinheiros
	 * @throws HeadlessException lan�amento de exce��o do tipo HeadlessException
	 * @throws ParseException lan�amento de exce��o do tipo ParseException
	 */
	public static void cadastroCozinheiro() throws HeadlessException, ParseException {
		int indice = pesquisarPosicaoCozinheiro();
		
		if(indice >= 0) {
			int matricula;
			do {
				matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matr�cula"));
				if(verificarMatricula(matricula))
				{
					JOptionPane.showMessageDialog(null, "Matr�cula j� existente!", "Aten��o", 2);
				}
			}while(verificarMatricula(matricula));
				
			String nome = JOptionPane.showInputDialog("Informe o nome");
			nome = nome.toUpperCase();
			
			String sexo;
			do {
				sexo = JOptionPane.showInputDialog("Informe o g�nero");
				if(!validaGenero(sexo))
				{
					JOptionPane.showMessageDialog(null, "G�nero inv�lido!\n"
														+ "\n masculino ou feminino", "Aten��o", 2);
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
						+ "Tipo de dado n�o compat�vel com o campo!\n"
						+ "O programa precisa ser reiniciado...", "Aten��o", 0);
				System.exit(0);
			}
			
			int cozinheiroChef= Integer.parseInt(JOptionPane.showInputDialog("Cozinheiro chef\n"
					+ "1 - Sim\n"
					+ "0 - N�o\n"));
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
	 * Verifica se o g�nero fornecido est� no formado v�lido
	 * @param sexo uma String que cont�m o g�nero a ser verificado
	 * @return verdadeiro ou falso, se o g�nero � ou n�o v�lido
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
	 * @param matricula um inteiro que cont�m uma matr�cula a ser verificada
	 * @return verdadeiro ou falso, se a matr�cula � v�lida ou n�o
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
	 * Verifica se existem posi��es dispon�veis no array cozinheiros
	 * @return o �ndice, caso tenham posi��es dispon�veis ou ent�o -1 caso contr�rio
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
