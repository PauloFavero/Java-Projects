
public abstract class Propriedade extends Local {

    private final int preco;
    private final int hipoteca;
    private int proprietario; // Proprietario = -1 se for o banco. Caso contratio ser� a posi��o no vetor de jogadores do jogador proprietario

    public Propriedade(String nome, int preco, int hipoteca, int proprietario) {
        super(nome);
        this.preco = preco;
        this.hipoteca = hipoteca;
        this.proprietario = proprietario;
    }

    public int getPreco() {
        return preco;
    }

    public int getHipoteca() {
        return hipoteca;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public abstract int custoTotal();

    @Override
    public String toString() {
        String out = "";
        out += super.toString();
        out += "Proprietario: " + ((proprietario == -1) ? "Banco" : "Jogador " + proprietario) + "\n";
        return out;
    }

}
