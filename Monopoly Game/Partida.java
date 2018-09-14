
import java.util.ArrayList;

public class Partida {

    private ArrayList<Rodada> rodadas;
    private ArrayList<Jogador> jogadores;
    private Banco banco;
    private final int numeroDeJogadores;
    private Tabuleiro tabuleiro;

    public Partida(int numeroDeJogadores) {
        rodadas = new ArrayList<Rodada>();
        jogadores = new ArrayList<Jogador>();
        banco = new Banco(); //Cria array de notas, add notas e cria e add propiedades
        this.numeroDeJogadores = numeroDeJogadores;//seta o numero de jogadores
        tabuleiro = new Tabuleiro();//cria o array de locais

        System.out.println("\t*** Nova Partida ***");
        /*
                Adiciona os jogadores no Arraylist jogadores e pega o dinheiro
                para cada jogador do banco
         */
        for (int i = 0; i < this.numeroDeJogadores; i++) {
            jogadores.add(new Jogador("Jogador " + i));
            jogadores.get(i).transferir(banco, jogadores.get(i), 1, 8);
            jogadores.get(i).transferir(banco, jogadores.get(i), 5, 10);
            jogadores.get(i).transferir(banco, jogadores.get(i), 10, 10);
            jogadores.get(i).transferir(banco, jogadores.get(i), 50, 10);
            jogadores.get(i).transferir(banco, jogadores.get(i), 100, 8);
            jogadores.get(i).transferir(banco, jogadores.get(i), 500, 2);
            jogadores.get(i).setPosicaoVetorJogadores(i);
            jogadores.get(i).setDinheiro(jogadores.get(i).getSaldo());
            //Adiciona os jogadores na posicao inicial do tabuleiro
             banco.setFundos(banco.saldo());
            tabuleiro.getLocal(0).getJogadores().add(jogadores.get(i));
        }
        /*
        Adiciona uma rodada ao vetor rodadas com a situacao atual do tabuleiro, jogadores e do banco
        Executa a ultima rodada do vetor rodadas(Ultima rodada criada)
         */
        do {
            rodadas.add(new Rodada(jogadores, banco, tabuleiro));
            rodadas.get((rodadas.size() - 1)).executarRodada();
            if (!rodadas.get((rodadas.size() - 1)).getEncerrou()) {
                System.out.println("\n\t*** Rodada: " + rodadas.size() + " ***\n");
            }
        } //while (false);
        while (!rodadas.get((rodadas.size() - 1)).getEncerrou());

    }

    public ArrayList<Rodada> getRodadas() {
        return rodadas;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public Banco getBanco() {
        return banco;
    }

    public int getNumeroDeJogadores() {
        return numeroDeJogadores;
    }

}
