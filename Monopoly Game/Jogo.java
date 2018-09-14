
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jogo {

    public static void main(String[] args) throws Exception {
        ArrayList<Partida> partidas = new ArrayList<Partida>();
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        int j;

        System.out.print("Digite o numero de jogadores: ");
        j = Integer.parseInt(in.readLine());
        while (true) {
            if (j < 2 || j > 7) {
                System.out.println("Entre com um numero de jogadores validos: ");
                j = Integer.parseInt(in.readLine());
            } else {
                break;
            }
        }
        if (j >= 2 && j < 7) {
            partidas.add(new Partida(j));
        }
    }
}
