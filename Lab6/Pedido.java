

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Paulo
 */
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class Pedido implements Calculavel, Comparable<Pedido> {

    private int numero;
    ArrayList<Item> itens;
    private Cliente comprador;
    private String vendedor;
    private Data data;

    public Pedido(int numero, Cliente comprador, String vendedor, Data data) {
        this.numero = numero;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.data = data;
        this.itens = new ArrayList<Item>();

    }

    public int getNumero() {
        return numero;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public Data getData() {
        return data;
    }

    public void adicionaItem(Item item) {
        if (item.getProduto().baixarEstoque(1)) {
            itens.add(item);
        }
    }

    public boolean removeItem(int k) {
        if (itens.size() <= k) {
            return false;
        }

        Item removido = itens.remove(k - 1);
        removido.getProduto().aumentarEstoque(removido.getItens());
        return true;

    }

    /**
     *
     * @return
     */
    @Override
    public double calcularCusto() {
        double total = 0;
        for (int i = 0; i < itens.size(); i++) {
            total += itens.get(i).calcularCusto();
        }

        return total;
    }
    /**
     *
     * @param outro
     * @return
     */
    @Override
    public int compareTo(Pedido outro) {
        if (this.calcularCusto() < outro.calcularCusto()) {
            return -1;
        }
        if (this.calcularCusto() > outro.calcularCusto()) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        String out = " ";
        out += "Pedido numero=" + numero + "\n";
        out += "itens:\n";
        for (int i = 0; i < this.itens.size(); i++) {
            Item selecionado = this.itens.get(i);
            out += selecionado + "\n";
        }
        out += "comprador=" + comprador + "\n";
        out += "vendedor=" + vendedor + "\n";
        out += data + "\n";
        return out;
    }

    

}
