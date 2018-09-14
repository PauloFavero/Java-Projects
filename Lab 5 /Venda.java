/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Paulo
 */
public abstract class Venda {

    private Data data;
    protected Pedido pedido;

    public Venda(Data data) {
        this.data = data;
    }

    public void adicionaPedido(Pedido pedido) {

        this.pedido = pedido;

    }

    public abstract double getTotal();

    @Override
    public String toString() {
        String out = " ";
        out += data.toString() + "\n";
        out += pedido.toString() + "\n";
        return out;
    }

}
