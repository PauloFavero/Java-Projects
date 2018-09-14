
import java.util.ArrayList;

public class Tabuleiro {

    private ArrayList<Local> locais;

    public Tabuleiro() {
        locais = new ArrayList<Local>();

        locais.add(new PontoDePassagem("Ponto de Partida"));
        locais.add(new Terreno("Leblon", 100, "Magenta", -1));
        locais.add(new SorteReves());
        locais.add(new Terreno("Av. Presidente Vargas", 60, "Magenta", -1));
        locais.add(new Terreno("Av. Nossa S. de Copacabana", 60, "Magenta", -1));
        locais.add(new Negocio("Companhia Ferroviaria", 200, 0, 40, -1));
        locais.add(new Terreno("Av. Brigadeiro Faria Lima", 240, "Azul Claro", -1));
        locais.add(new Negocio("Companhia de Viacao", 200, 0, 40, -1));
        locais.add(new Terreno("Av. Reboucas", 220, "Azul Claro", -1));
        locais.add(new Terreno("Av. 9 de Julho", 220, "Azul Claro", -1));
        locais.add(new PontoDePassagem("Prisao"));
        locais.add(new Terreno("Av. Europa", 200, "Roxo", -1));
        locais.add(new SorteReves());
        locais.add(new Terreno("Rua Augusta", 180, "Roxo", -1));
        locais.add(new Terreno("Av. Pacaembu", 180, "Roxo", -1));
        locais.add(new Negocio("Companhia de Taxi", 150, 0, 40, -1));
        locais.add(new SorteReves());
        locais.add(new Negocio("Companhia de Moto Taxi", 150, 0, 40, -1));
        locais.add(new Utilidade("Lucros ou Dividendos", 200));
        locais.add(new Terreno("Morumbi", 400, "Vermelho", -1));
        locais.add(new PontoDePassagem("Parada Livre"));
        locais.add(new Terreno("Flamengo", 120, "Vermelho", -1));
        locais.add(new SorteReves());
        locais.add(new Terreno("Botafogo", 100, "Vermelho", -1));
        locais.add(new Utilidade("Imposto de Renda", -200));
        locais.add(new Negocio("Companhia de Navegacao", 150, 0, 40, -1));
        locais.add(new Terreno("Av. Brasil", 160, "Amarelo", -1));
        locais.add(new SorteReves());
        locais.add(new Terreno("Av. Paulista", 140, "Amarelo", -1));
        locais.add(new Terreno("Jardim Europa", 140, "Amarelo", -1));
        locais.add(new PontoDePassagem("Va para a prisao"));
        locais.add(new Terreno("Copacabana", 260, "Verde", -1));
        locais.add(new Negocio("Companhia de Aviacao", 200, 0, 40, -1));
        locais.add(new Terreno("Av. Vieira Souto", 320, "Verde", -1));
        locais.add(new Terreno("Av. Atlantica", 300, "Verde", -1));
        locais.add(new Negocio("Companhia de Taxi Aereo", 200, 0, 40, -1));
        locais.add(new Terreno("Itaim Bibi", 300, "Azul Marinho", -1));
        locais.add(new SorteReves());
        locais.add(new Terreno("Jardim Paulista", 280, "Azul Marinho", -1));
        locais.add(new Terreno("Brooklin", 260, "Azul Marinho", -1));

    }

    public Local getLocal(int i) {
        return locais.get(i);
    }

    public void updateProprietarios(int falido) {
        for (int i = 0; i < locais.size(); i++) {
            if ((locais.get(i) instanceof Terreno)) {
                if (((Terreno) locais.get(i)).getProprietario() > falido) {
                    ((Terreno) locais.get(i)).setProprietario(((Terreno) locais.get(i)).getProprietario() - 1);
                }
            } else if (locais.get(i) instanceof Negocio) {
                if (((Negocio) locais.get(i)).getProprietario() > falido) {
                    ((Negocio) locais.get(i)).setProprietario(((Negocio) locais.get(i)).getProprietario() - 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < locais.size(); i++) {
            out += "*** Local " + i + " ***\n";
            out += locais.get(i);
            for (int j = 0; j < locais.get(i).getJogadores().size(); j++) {
                out += "O jogador " + locais.get(i).getJogadores().get(j).getNome() + " esta neste local\n";
            }
            out += "\n";
        }
        return out;
    }
}
