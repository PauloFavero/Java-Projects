/**
 * 
 */

/**
 * @author 147601
 *
 */
public class Produto {
	

	private String descricao;
	private String foto;
	private int id;
	private double valor;
	private static int quantidade=0;
	
	
	/**
	 * @param descricao
	 * @param foto
	 * @param id
	 * @param valor
	 */
	public Produto(String descricao, double valor) {

		this.descricao = descricao;
		this.valor = valor;
		this.id = quantidade+=1;
		foto="foto"+id;
	}	
	/**
	 * @return the quantidade
	 */
	public static int getQuantidade() {
		return quantidade;
	}

	public String toString()
	{
		String out = " ";
		out+="Descricao: "+getDescricao()+"\n";
		out+="Foto: "+getFoto()+"\n";
		out+="Id: "+getId()+"\n";
		out+="Valor: "+getValor()+"\n";
		out+="Quantidade: "+getQuantidade()+"\n";
		return out;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}


	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}


	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

}

