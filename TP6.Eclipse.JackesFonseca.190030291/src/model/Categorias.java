package model;

/**
 * Cria um objeto para Categorias
 * @author Jackes Tiago
 * @version 1.0 (Nov 2020)
 */
public class Categorias 
{
	private String tipos;

	/**
	 * Construtor Categorias
	 * @param tipos Tipo de categoria
	 */
	public Categorias(String tipos){
		this.tipos = tipos;
		
	}

	public String getTipo() {
		return tipos;
	}

	public void setTipos(String tipos) {
		this.tipos = tipos;
	}
	
}
