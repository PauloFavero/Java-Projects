/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paulo
 */
public class VendaPrazo extends Venda {

    private double juros;

    public VendaPrazo(Data data, double juros) {
        super(data);
        this.juros = juros;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

   
    /**
     *
     * @return
     */
    @Override
    public double calcularCusto() {
        double total = 0.0;
        for (int i = 0; i < pedidos.size(); ++i) {
            total += (double) (pedidos.get(i)).calcularCusto();
        }
        return (total * (100 + juros)) / 100;
    }

    @Override
    public String toString() {
        String out = " ";
        out += "Juros=" + juros + "\n";
        out += "Venda a prazo=" + super.toString() + "\n";
        out += "Total da venda a prazo: " + calcularCusto() + "\n";
        out += "\n";
        return out;
    }

}
