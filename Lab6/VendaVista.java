/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    @Override
    public double calcularCusto() {
        double total = 0.0;
        for (int i = 0; i < pedidos.size(); ++i) {
            total += (double) (pedidos.get(i)).calcularCusto();
        }
        return (total * (100 - desconto)) / 100;
    }
    
   

    @Override
    public String toString() {
        String out = " ";
        out += "Desconto= " + desconto + "\n";
        out += "Venda a vista \n" + super.toString() + "\n";
        out += "Total da venda a vista: " + calcularCusto() + "\n";
        out += "\n";
        return out;
    }

}
