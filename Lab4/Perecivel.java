import java.util.Calendar;

public class Perecivel extends Produto
{
	
public int validade [];

/**
 * @param descricao
 * @param foto
 * @param id
 * @param valor
 * @param validade
 */
public Perecivel(int dia, int mes, int ano, String descricao, double valor, Fornecedor fornecedor) {
	
	super(descricao,valor,fornecedor);
	validade = new int[3];
	this.validade[0] = dia;
	this.validade[1] = mes;
	this.validade[2] = ano;
	
}
public boolean estaVencido() {
	Calendar hoje = Calendar.getInstance(); 				// Data atual do sistema
		Calendar val = Calendar.getInstance(); 	    			// Data atual do sistema
		val.set(validade[2], validade[1]-1, validade[0]);		// ano, mes (indexado a partir de 0), dia
		
		if (val.after(hoje))
			return false;
		else
			return true;
}

public void aplicaDesconto(double desconto) {

	super.setValor(super.getValor()-(desconto/100)*super.getValor());

}

public String toString()
{
	String out="";
	out += super.toString();
	out+="validade:" +validade[0]+"/"+validade[1]+"/"+validade[2]+ "\n";
	return out;
}
		
}