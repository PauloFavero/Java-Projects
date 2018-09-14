
import java.util.ArrayList;
import java.util.Random;

public class Rodada {

    private ArrayList<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private Banco banco;
    private int dado1, dado2, dadosIguais;
    private boolean encerrou = false;
    private Random randomNumbers;

    public Rodada(ArrayList<Jogador> jogadores, Banco banco, Tabuleiro tabuleiro) {
        this.jogadores = jogadores;
        this.banco = banco;
        this.tabuleiro = tabuleiro;
    }

    /*
        Printa tabuleiro atual
        Printa saldo do banco atual
        printa situacao do jogadores
    
        Executa a rodada para cada jogador
     */
    public void executarRodada() {

        System.out.print(tabuleiro);

        System.out.println(banco);

        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println(jogadores.get(i));
        }

        for (int i = 0; i < jogadores.size(); i++) {
            dadosIguais = 0;
            executarJogada(jogadores.get(i));
            if (encerrou == true) {
                System.out.println("Campeao" + "***" + jogadores + " ***");
                return;
            }
        }
    }

    /*
    Rodada para cada jogador da posicao i do vetor
     */
    public void executarJogada(Jogador jogador) {
        System.out.println("\n*** Turno do " + jogador.getNome() + " ***");
        //Rola os dados para o turno do jogador
        randomNumbers = new Random();
        dado1 = 1 + randomNumbers.nextInt(6);
        dado2 = 1 + randomNumbers.nextInt(6);
        jogador.setTabuleiro(tabuleiro);
        if (dado1 == dado2) {
            dadosIguais++;
        }/*
        Se o jogador estiver preso e cair dados igauis ele sai se nao continua preso
         */
        if (jogador.getPreso()) {
            if (dado1 == dado2) {
                jogador.setPreso(false);
                System.out.println("O Jogador " + jogador.getNome()+ " saiu da prisao");
            } else {
                System.out.println("O Jogador " + jogador.getNome()+ " continua preso");
                return;
            }
            /*
            O jogador que jogar 3 vezes dados iguais vai para a prisao
             */
        } else if (dadosIguais == 3) {
            System.out.println("O Jogador " + jogador.getNome() + " jogou dados iguais pela terceira vez e foi para prisao");
            tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getJogadores().remove(jogador);
            jogador.setPosicaoTabuleiro(10);//posicao da cadeia
            jogador.setPreso(true);
            tabuleiro.getLocal(10).getJogadores().add(jogador);
            return;
        }
        /*
        Se o jogador nao estiver preso:
         */
        if (!jogador.getPreso()) {
            tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getJogadores().remove(jogador);//Retira o jogador de onde ele esta
            jogador.setPosicaoTabuleiro(jogador.getPosicaoTabuleiro() + dado1 + dado2); // Move o jogador para a nova posicao de acordo com o valor dos dados
            if (jogador.getPosicaoTabuleiro() > 39) {
                jogador.setPosicaoTabuleiro(jogador.getPosicaoTabuleiro() - 39);//Volta o jogador para o inicio mais o valor adicional do dado
                jogador.pagaBanco(banco, jogador, -200, jogadores);//Transfere 100 por ele ter passado pelo inicio
                System.out.println("O Jogador " + jogador.getNome()+ " passou pelo ponto de partida e recebeu 200 reais");
            }
            tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getJogadores().add(jogador);
            System.out.println("O Jogador " + jogador.getNome() + " andou " + (dado1 + dado2) + " posicoes e esta no local " + tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getNome());
            /*
            If de acao para o local UTILIDADE
             */
            if (tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getClass().getName() == "Utilidade") {
                if (((Utilidade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getValor() == 200) { // Lucros e Dividendos
                    jogador.pagaBanco(banco, jogador, -50, jogadores);
                    System.out.println("Lucros e dividendos: o Jogador " + jogador.getNome()+ " recebe 50 reais do banco");
                    return;
                } else if (((Utilidade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getValor() == -200) { // Imposto de Renda
                    if (jogador.getDinheiro() > 500) {
                        jogador.pagaBanco(banco, jogador, 500, jogadores);
                    } else if (hipoteca(banco, jogador, tabuleiro, 500)) {
                    } else {
                        System.out.println("Imposto de renda: o Jogador " + jogador.getNome()+ " paga 500 reais ao banco");
                    }
                    return;
                }
                /*
            If de acao para o local SORTE OU REVES
                 */
            } else if (tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getClass().getName() == "SorteReves") {
                Carta carta = ((SorteReves) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getCartas().get(randomNumbers.nextInt(30));//Escolhe  uma carta aleatoria do vetor cartas
                if (carta.getValor() == 0) {
                    /*
                    Caso seja a carta da prisao o jogador sera tranferido para la 
                     */
                    if (carta.getPrisao() == true) {
                        tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getJogadores().remove(jogador);
                        jogador.setPosicaoTabuleiro(10);
                        tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getJogadores().add(jogador);
                        jogador.setPreso(true);
                        System.out.println("Sorte ou reves: " + carta.getDescricao());
                        System.out.println("O Jogador " + jogador.getNome()+ " esta preso");
                        return;
                    } else {// Saida da prisao
                        jogador.setSaidaLivre(true);
                        System.out.println("O jogador ganhou a carta Saida Livre da Prisao");
                        return;
                    }
                } /*
                Caso a carta nao seja de saida livre ou de prisao sera verificado se 
                o jogador deve receber ou pagar uma certa quantia
                 */ else {
                    System.out.println("Sorte ou reves: " + carta.getDescricao());
                    if ((carta.getValor() > 0)) {
                        System.out.println("Receba: " + (carta.getValor()) + " reais");
                        jogador.pagaBanco(banco, jogador, -carta.getValor(), jogadores);
                    } else {
                        if (jogador.getDinheiro() > -carta.getValor()) {
                            jogador.pagaBanco(banco, jogador, -carta.getValor(), jogadores);
                            System.out.println("Pague: " + -carta.getValor() + " reais");
                        } else if (hipoteca(banco, jogador, tabuleiro, carta.getValor())) {
                        } else {

                        }
                        return;
                    }
                }

            }//Fim do IF SORTE ou REVES
            else if (tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getClass().getName() == "PontoDePassagem") {
                if (jogador.getPosicaoTabuleiro() == 30) { // se eh va para prisao
                    System.out.println("O Jogador " + jogador.getNome()+ " parou na posicao " + tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getNome() + " e esta preso");
                    tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getJogadores().remove(jogador);
                    jogador.setPosicaoTabuleiro(10);//posicao da cadeia
                    jogador.setPreso(true);
                    tabuleiro.getLocal(10).getJogadores().add(jogador);
                    return;
                }
            } /*
             Se o jogador cair em um local no qual  outro jogador é proprietário
             ele transfere dinheiro para esse jogador
             */ else if (((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario() != (-1)
                    && ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario() != jogador.getPosicaoVetorJogadores()) {
                if (((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())) instanceof Terreno) {
                    if (jogador.getDinheiro() > ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal()) {
                        jogador.pagaJogador(jogador,
                                jogadores.get(((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario()),
                                -((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal());
                        System.out.println("O Jogador "+jogador.getNome()+ " paga "+((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal()+ 
                                " ao Jogador "+ jogadores.get(((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario()));
                    } else if (hipoteca(banco, jogador, tabuleiro, ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal())) {
                    } else {
                        System.out.println("Terreno: O Jogador " + jogador.getNome()+ " paga "
                                + ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal() + " ao Jogador "
                                + jogadores.get(((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario()));
                    }
                    return;

                } else if (((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())) instanceof Negocio) {
                    if (jogador.getDinheiro() > ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal() * (dado1 + dado2)) {
                        jogador.pagaJogador(jogador,
                                jogadores.get(((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario()),
                                -((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal() * (dado1 + dado2));
                        System.out.println("Negocio: O Jogador " + jogador.getNome()+ " paga "
                                + ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal() + " ao Jogador "
                                + jogadores.get(((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario()));
                    } else if (hipoteca(banco, jogador, tabuleiro, ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal())) {
                    } else {
                        System.out.println("Negocio: o Jogador " + jogador.getNome()+ " paga "
                                + ((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).custoTotal() * (dado1 + dado2) + " ao Jogador "
                                + jogadores.get(((Propriedade) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getProprietario()));
                    }
                    return;

                }

            }/*
            Se o o jogador para em uma propriedade que eh dele ou do banco, eh chamado o metodo jogar para o jogador efetuar sua estrategia
             */ else {
                jogador.jogar(banco, jogadores, tabuleiro);
            }
        }

        if (dado1 == dado2) {
            executarJogada(jogador);
        }
    }

    public boolean hipoteca(Banco banco, Jogador jogador, Tabuleiro tabuleiro, int divida) {
        int i = 0;
        while ((divida >= jogador.getDinheiro()) && (i < jogador.getPropriedades().size()) && (i >= 0)) {

            if (jogador.getPropriedades().get(i) instanceof Terreno) {
                if (((Terreno) jogador.getPropriedades().get(i)).getNumeroDeCasas() > 0) {
                    ((Terreno) jogador.getPropriedades().get(i)).setNumeroDeCasas(((Terreno) jogador.getPropriedades().get(i)).getNumeroDeCasas() - 1);
                    jogador.pagaBanco(banco, jogador, -(((Terreno) jogador.getPropriedades().get(i)).getComprarCasa() / 2), jogadores);
                    System.out.println("O Jogador "+jogador.getNome()+" vendeu uma Casa ao Banco no valor de "+(((Terreno) jogador.getPropriedades().get(i)).getComprarCasa() / 2));
                    i--;
                } else if (((Terreno) jogador.getPropriedades().get(i)).isTemHotel()) {
                    ((Terreno) jogador.getPropriedades().get(i)).setTemHotel(false);
                    jogador.pagaBanco(banco, jogador, -((Terreno) jogador.getPropriedades().get(i)).getComprarHotel()*3, jogadores);
                    System.out.println("O Jogador "+jogador.getNome()+" vendeu um Hotel ao Banco "+ ((Terreno) jogador.getPropriedades().get(i)).getComprarHotel()*3);
                    i--;
                } else {
                       if(banco.getFundos()>=(((Terreno) jogador.getPropriedades().get(i)).getComprarCasa()/ 2)){
                  System.out.println("O Jogador "+jogador.getNome()+" vendeu para o banco o Terreno "+((Terreno) jogador.getPropriedades().get(i)).getNome() +" por " +((Terreno) jogador.getPropriedades().get(i)).getComprarCasa()/ 2);
                  
                  jogador.pagaBanco(banco, jogador, -((Terreno) jogador.getPropriedades().get(i)).getComprarCasa()/2, jogadores);   
                  jogador.vender(banco, ((Terreno) jogador.getPropriedades().get(i)), jogador);
                          
                  i--;
                                 }
                       else {
                            System.out.println("O Jogador "+jogador.getNome()+" vendeu  para o Jogador "+jogador.jogadorBonado(jogadores).getNome()+" o Terreno "+
                            ((Terreno) jogador.getPropriedades().get(i)).getNome() +
                                  " por " +((Terreno) jogador.getPropriedades().get(i)).getComprarCasa()/ 2);
                    jogador.pagaJogador(jogador, jogador.jogadorBonado(jogadores), divida);
                    jogador.transferePropriedade(jogador, jogador.jogadorBonado(jogadores), ((Terreno) jogador.getPropriedades().get(i)));
                   
                    i--;
                } 
                }
            } //Terreno
            else if (jogador.getPropriedades().get(i) instanceof Negocio) {
System.out.println("O Jogador "+jogador.getNome()+" vendeu para o banco o Negocio "+((Negocio) jogador.getPropriedades().get(i)).getNome() +" por " +((Negocio) jogador.getPropriedades().get(i)).getPreco()/ 2);
                  
                jogador.pagaBanco(banco, jogador, -((Negocio) jogador.getPropriedades().get(i)).getPreco(), jogadores);
                jogador.vender(banco, ((Negocio) jogador.getPropriedades().get(i)), jogador);
                

                i--;
            }
            
            i++;
        }

        if ((jogador.getDinheiro() - divida) < 0) {
            int pos = jogador.getPosicaoVetorJogadores();
            System.out.println("O Jogador " + jogador.getNome() + " faliu.");
            tabuleiro.getLocal(jogador.getPosicaoTabuleiro()).getJogadores().remove(jogador);
            jogadores.remove(jogador.getPosicaoVetorJogadores());
            for (int k = 0; k < jogadores.size(); k++) {
                if (jogadores.get(k).getPosicaoVetorJogadores() > pos) {
                    jogadores.get(k).setPosicaoVetorJogadores(jogadores.get(k).getPosicaoVetorJogadores() - 1);
                }

            }
            tabuleiro.updateProprietarios(pos);

            System.out.println("O jogador " + jogador.getNome() + " foi removido da partida");
            if (!(jogadores.size() > 1)) {
                encerrou = true;
            }

            return true;
        } else {
            return false;

        }
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public int getDado1() {
        return dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public boolean getEncerrou() {
        return encerrou;
    }
}
