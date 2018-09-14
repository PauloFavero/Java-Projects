


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
import java.util.Collection;

public abstract class Venda implements Calculavel, Comparable<Venda> {

    private Data data;
    protected ArrayList<Pedido> pedidos;

    public Venda(Data data) {

        pedidos = new ArrayList<Pedido>();
        this.data = data;
    }

    public void adicionaPedido(Pedido i) {
        pedidos.add(i);
    }

    /**
     *
     * @param outro
     * @return
     */
    @Override
     public int compareTo(Venda outro) {
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
        String out = "";

        out += "Venda na data " + data;
        out += "\nPedidos:\n";
        for (int i = 0; i < pedidos.size(); i++) {
            out += "  * " + pedidos.get(i) + "\n";
        }
        return out;
    }

}
