
import java.util.ArrayList;

public class Banco {

    private int casas = 32;
    private int hoteis = 12;
    private ArrayList<Propriedade> propriedades;
    private ArrayList<Nota> notas;
    private int fundos;

    public Banco() {
        notas = new ArrayList<Nota>();
        notas.add(new Nota(1, 56));
        notas.add(new Nota(5, 70));
        notas.add(new Nota(10, 70));
        notas.add(new Nota(50, 70));
        notas.add(new Nota(100, 56));
        notas.add(new Nota(500, 58));
        propriedades = new ArrayList<Propriedade>();
       

        propriedades.add(new Terreno("Leblon", 100, "Magenta", -1));
        propriedades.add(new Terreno("Av. Presidente Vargas", 60, "Magenta", -1));
        propriedades.add(new Terreno("Av. Nossa S. de Copacabana", 60, "Magenta", -1));
        propriedades.add(new Negocio("Companhia Ferroviaria", 200, 0, 0, -1));
        propriedades.add(new Terreno("Av. Brigadeiro Faria Lima", 240, "Azul Claro", -1));
        propriedades.add(new Negocio("Companhia de Viacao", 200, 0, 0, -1));
        propriedades.add(new Terreno("Av. Reboucas", 220, "Azul Claro", -1));
        propriedades.add(new Terreno("Av. 9 de Julho", 220, "Azul Claro", -1));
        propriedades.add(new Terreno("Av. Europa", 200, "Roxo", -1));
        propriedades.add(new Terreno("Rua Augusta", 180, "Roxo", -1));
        propriedades.add(new Terreno("Av. Pacaembu", 180, "Roxo", -1));
        propriedades.add(new Negocio("Companhia de Taxi", 150, 0, 0, -1));
        propriedades.add(new Negocio("Companhia de Moto Taxi", 150, 0, 0, -1));
        propriedades.add(new Terreno("Morumbi", 400, "Vermelho", -1));
        propriedades.add(new Terreno("Flamengo", 120, "Vermelho", -1));
        propriedades.add(new Terreno("Botafogo", 100, "Vermelho", -1));
        propriedades.add(new Negocio("Companhia de Navegacao", 150, 0, 0, -1));
        propriedades.add(new Terreno("Av. Brasil", 160, "Amarelo", -1));
        propriedades.add(new Terreno("Av. Paulista", 140, "Amarelo", -1));
        propriedades.add(new Terreno("Jardim Europa", 140, "Amarelo", -1));
        propriedades.add(new Terreno("Copacabana", 260, "Verde", -1));
        propriedades.add(new Negocio("Companhia de Aviacao", 200, 0, 0, -1));
        propriedades.add(new Terreno("Av. Vieira Souto", 320, "Verde", -1));
        propriedades.add(new Terreno("Av. Atlantica", 300, "Verde", -1));
        propriedades.add(new Negocio("Companhia de Taxi Aereo", 200, 0, 0, -1));
        propriedades.add(new Terreno("Itaim Bibi", 300, "Azul Marinho", -1));
        propriedades.add(new Terreno("Jardim Paulista", 280, "Azul Marinho", -1));
        propriedades.add(new Terreno("Brooklin", 260, "Azul Marinho", -1));
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public int getHoteis() {
        return hoteis;
    }

    public void setHoteis(int hoteis) {
        this.hoteis = hoteis;
    }

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public int saldo() {
        int saldo = 0;
        for (int i = 0; i < notas.size(); i++) {
            saldo += notas.get(i).getValor() * notas.get(i).getQuantidade();
        }
        return saldo;
    }

    public int getFundos() {
        return fundos;
    }

    public void setFundos(int fundos) {
        this.fundos = fundos;
    }
    

    public String toString() {
        String out = "";
        out += "Saldo do banco: " + saldo() + "\n";
        out += "Fundo: " + getFundos() + "\n";
        return out;
    }

}
