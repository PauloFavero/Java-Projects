package lab5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Paulo
 */
//import static Produto.getQuantidade;
public class Fornecedor {

    private String razaoSocial;
    private String telefone;
    private int codigo;

    public Fornecedor(String razaoSocial, String telefone, int codigo) {
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {

        String out = "";
        out += "Fornecedor: " + getRazaoSocial() + "\n";
        out += "Telefone: " + getTelefone() + "\n";
        out += "Código: " + getCodigo();
        return out;

    }

}
