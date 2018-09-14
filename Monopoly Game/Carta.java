
public class Carta {

    private final String nome;
    private final String descricao;
    private final int valor;
    private final boolean prisao; // Se true, va para prisao. Se false, saida livre da prisao. Valido somente para cartas com valor zero.

    public Carta(String nome, String descricao, int valor, boolean prisao) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.prisao = prisao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public boolean getPrisao() {
        return prisao;
    }
}
