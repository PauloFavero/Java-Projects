
public class Nota {

    private int valor;
    private int quantidade;

    public Nota(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void aumentar(int quantidadeDeNotas) {
        quantidade += quantidadeDeNotas;
    }

     public void diminuir(int quantidadeDeNotas) {
        quantidade -= quantidadeDeNotas;
    }
    
}
