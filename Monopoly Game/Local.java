
import java.util.ArrayList;

public abstract class Local {

    private final String nome;
    private ArrayList<Jogador> jogadores;

    public Local(String nome) {
        this.nome = nome;
        jogadores = new ArrayList<Jogador>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public String toString() {
        String out = "";
        out += "Nome: " + getNome() + "\n";
        out += "Tipo: " + getClass().getSimpleName() + "\n";
        return out;
    }
}
