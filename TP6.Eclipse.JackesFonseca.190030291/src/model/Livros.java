package model;

/**
 * Cria um objeto para Livros
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class Livros
{
	private String titulo;
	private int isbn;
	private String[] receitas = new String[100];
	private String editor;
	
	/**
	 * Construtor Livros
	 * @param titulo Título do livro
	 * @param isbn ISBN do livro
	 * @param editor Editor do livro
	 */
	public Livros(String titulo, int isbn, String editor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.editor = editor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	public String[] getReceitas()
	{
		return receitas;
	}
	
}
