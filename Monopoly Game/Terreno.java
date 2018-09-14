public class Terreno extends Propriedade {
	private final String cor;
	private int aluguel;
	private int numeroDeCasas;
	private boolean temHotel = false;
	private int comprarCasa;
	private int comprarHotel;
	
	public Terreno (String nome, int preco, String cor, int proprietario) {
		super(nome, preco, preco/2, proprietario);
		this.cor = cor;
		aluguel = preco/10;
		comprarCasa = preco;
		comprarHotel = preco;
		
	}

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    public void setNumeroDeCasas(int numeroDeCasas) {
        this.numeroDeCasas = numeroDeCasas;
    }

    public void setTemHotel(boolean temHotel) {
        this.temHotel = temHotel;
    }

    public void setComprarCasa(int comprarCasa) {
        this.comprarCasa = comprarCasa;
    }

    public void setComprarHotel(int comprarHotel) {
        this.comprarHotel = comprarHotel;
    }
	
	public int custoTotal() {
		if(numeroDeCasas == 0 && temHotel == false) return aluguel;
		else if (numeroDeCasas != 0) return (super.getPreco()*numeroDeCasas);
		else return (comprarHotel*6);
	}

    public String getCor() {
        return cor;
    }

    public int getAluguel() {
        return aluguel;
    }

    public int getNumeroDeCasas() {
        return numeroDeCasas;
    }

    public boolean isTemHotel() {
        return temHotel;
    }

    public int getComprarCasa() {
        return comprarCasa;
    }

    public int getComprarHotel() {
        return comprarHotel;
    }
	
	public String toString () {
		String out = "";
		out += super.toString();
		out += "Quantidade de casas: " + numeroDeCasas + "\n" + "Quantidade de hoteis: " + ((temHotel) ? "1" : "0" + "\n");
		return out;
	}
}