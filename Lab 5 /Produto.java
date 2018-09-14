package lab5;

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
    private final int id;
    private double valor;
    private int estoque;
    private int estoqueMinimo;
    private Fornecedor fornecedor;
    private static int quantidade = 0;

    /**
     * @param descricao
     * @param valor
     * @param fornecedor
     */
    public Produto(String descricao, double valor, Fornecedor fornecedor) {

        this.descricao = descricao;
        this.valor = valor;
        this.id = quantidade += 1;
        foto = "foto" + id;
        this.fornecedor = fornecedor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public int getEstoque() {
        return estoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    /**
     * @return the quantidade
     */
    public static int getQuantidade() {
        return quantidade;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setFornedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public boolean checarEstoqueMinimo() {
        if (this.estoque > this.estoqueMinimo) {
            return true;
        } else {
            return false;
        }

    }

    public boolean baixarEstoque(int n) {
        if ((estoque - n) >= estoqueMinimo) {
            estoque -= n;
            return true;
        } else {
            return false;
        }

    }

    public void aumentarEstoque(int k) {
        estoque += k;
    }

    public String toString() {
        String out = " ";
        out += "Fornecedor: " + fornecedor.getRazaoSocial() + "\n";
        out += "Descricao: " + getDescricao() + "\n";
        out += "Foto: " + getFoto() + "\n";
        out += "Id: " + getId() + "\n";
        out += "Valor: " + getValor() + "\n";
        out += "Quantidade: " + getQuantidade() + "\n";
        return out;
    }
}
