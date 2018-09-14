public class Perecivel extends Produto
{
	
public int validade [];
public int diaAtual=21;
public int mesAtual=9;
public int anoAtual=2016;
/**
 * @param descricao
 * @param foto
 * @param id
 * @param valor
 * @param validade
 */
public Perecivel(int dia, int mes, int ano, String descricao, double valor) {
	
	super(descricao,valor);
	validade = new int[3];
	this.validade[0] = dia;
	this.validade[1] = mes;
	this.validade[2] = ano;
	
}
public boolean estaVencido() {
	if (diaAtual>validade[0] & mesAtual>validade[1] &anoAtual> validade[2])
		return true;
	else 
		return false;
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