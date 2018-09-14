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
public class VendaVista extends Venda {

    private double desconto;

    public VendaVista(Data data, double desconto) {
        super(data);
        this.desconto = desconto;
    }

    public double getTotal() {
        return (1-desconto) * pedido.calculaTotal();
    }

    @Override
    public String toString() {
        String out = " ";
        out += "Desconto= " + desconto + "\n";
        out += "Venda a vista \n" + super.toString() + "\n";
        out += "Total da venda a vista: " + getTotal() + "\n";
        out += "\n";
        return out;
    }

}
