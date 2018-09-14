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
public class Item {

    private int id;
    private Produto produto;
    private int itens;

    public Item(int id, int itens, Produto produto) {
        this.id = id;
        this.itens = itens;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getItens() {
        return itens;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setItens(int itens) {
        this.itens = itens;
    }

    /**
     *
     * @return
     */
    public double calculaCusto() {
        return produto.getValor() * itens;
    }

    @Override
    public String toString() {
        String out = "";
        out += produto;
        out += "Id: " + getId() + "\n";
        out += "Itens: " + getItens() + "\n";
        return out;
    }

}
