
import java.util.ArrayList;
import java.util.Arrays;

public class Jogador {

    private int posicaoTabuleiro;
    private String nome;
    private int posicaoVetorJogadores;
    private Tabuleiro tabuleiro;
    private ArrayList<Local> propriedades;
    private ArrayList<Nota> notas;
    private boolean preso;
    private int dinheiro;
    private boolean saidaLivre;
    private Banco banco;

    public Jogador(String nome) {
        propriedades = new ArrayList<Local>();
        notas = new ArrayList<Nota>();
        notas.add(new Nota(1, 0));
        notas.add(new Nota(5, 0));
        notas.add(new Nota(10, 0));
        notas.add(new Nota(50, 0));
        notas.add(new Nota(100, 0));
        notas.add(new Nota(500, 0));
        posicaoTabuleiro = 0;
        preso = false;
        saidaLivre = false;
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public int getPosicaoTabuleiro() {
        return posicaoTabuleiro;
    }

    public void setPosicaoTabuleiro(int posicaoTabuleiro) {
        this.posicaoTabuleiro = posicaoTabuleiro;
    }

    public int getPosicaoVetorJogadores() {
        return posicaoVetorJogadores;
    }

    public void setPosicaoVetorJogadores(int posicaoVetorJogadores) {
        this.posicaoVetorJogadores = posicaoVetorJogadores;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public ArrayList<Local> getPropriedades() {
        return propriedades;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public boolean getPreso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }

    public void setSaidaLivre(boolean saidaLivre) {
        this.saidaLivre = saidaLivre;
    }

    public boolean getSaidaLivre() {
        return saidaLivre;
    }

    public int getSaldo() {
        int saldo = 0;
        for (int i = 0; i < notas.size(); i++) {
            saldo += notas.get(i).getValor() * notas.get(i).getQuantidade();
        }
        return saldo;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    /*
    valor positivo o Jogador B transfere para A
    valor Negativo o Jogador A transfere para B
     */
    public void pagaJogador(Jogador A, Jogador B, int valor) {
        if (valor > 0) {
            A.setDinheiro(A.getDinheiro() + valor);
            B.setDinheiro(B.getDinheiro() - valor);
        } else {
            B.setDinheiro(B.getDinheiro() - valor);
            A.setDinheiro(A.getDinheiro() + valor);
        }
    }

    /*
    valor positivo o Jogador A transfere para o Banco
    valor Negativo o Banco transfere para o Jogador A
     */
    public void pagaBanco(Banco banco, Jogador A, int valor, ArrayList<Jogador> jogadores) {
        int i;
        if (valor > 0) {
            banco.setFundos(banco.getFundos() + valor);
            A.setDinheiro(A.getDinheiro() - valor);
        } else if (banco.getFundos() >= -valor) {
            banco.setFundos(banco.getFundos() + valor);
            A.setDinheiro(A.getDinheiro() - valor);
        }
    }

    public Jogador jogadorBonado(ArrayList<Jogador> jogadores) {
        int max = 0;
        int jog = 0;
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getDinheiro() > max) {
                jog = i;
                max = jogadores.get(i).getDinheiro();
            }

        }
        return jogadores.get(jog);

    }

    public void transferePropriedade(Jogador A, Jogador B, Propriedade propriedade) {
        B.getPropriedades().add(propriedade);
        A.getPropriedades().remove(propriedade);
        propriedade.setProprietario(B.getPosicaoVetorJogadores());

    }

    public void comprar(Banco banco, Propriedade propriedade, Jogador jogador, ArrayList<Jogador> jogadores) {
        banco.getPropriedades().remove(propriedade);
        propriedades.add(propriedade);
        propriedade.setProprietario(getPosicaoVetorJogadores());
        pagaBanco(banco, jogador, propriedade.getPreco(), jogadores);
    }
    //Metodo para vender uma propriedade 

    public void vender(Banco banco, Propriedade propriedade, Jogador jogador) {
        banco.getPropriedades().add(propriedade);
        propriedades.remove(propriedade);
        propriedade.setProprietario(-1);
    }

    public void jogar(Banco banco, ArrayList<Jogador> jogadores, Tabuleiro tabuleiro) {
        int magenta = 0, azulClaro = 0, roxo = 0, vermelho = 0, amarelo = 0, verde = 0, azulMarinho = 0;//contadores de terrenos do jogador com cores iguais
        if (propriedades.contains(tabuleiro.getLocal(posicaoTabuleiro))) {
            for (int i = 0; i < jogadores.get(posicaoVetorJogadores).getPropriedades().size(); i++) {
                //If de verificacao se a propriedade e do tipo terreno
                if (jogadores.get(posicaoVetorJogadores).getPropriedades().get(i) instanceof Terreno) {

                    /*
                Quando encotra 3 terrenos magenta inicia a verificacao das casas para construcao
                     */
                    if (((Terreno) jogadores.get(posicaoVetorJogadores).getPropriedades().get(i)).getCor() == "Magenta") {
                        magenta++;//incremento do contador magenta

                    } else if (((Terreno) jogadores.get(posicaoVetorJogadores).getPropriedades().get(i)).getCor() == "Azul Claro") {
                        azulClaro++;

                    } else if (((Terreno) jogadores.get(posicaoVetorJogadores).getPropriedades().get(i)).getCor() == "Roxo") {
                        roxo++;

                    } else if (((Terreno) jogadores.get(posicaoVetorJogadores).getPropriedades().get(i)).getCor() == "Vermelho") {
                        vermelho++;

                    } else if (((Terreno) jogadores.get(posicaoVetorJogadores).getPropriedades().get(i)).getCor() == "Amarelo") {
                        amarelo++;

                    } else if (((Terreno) jogadores.get(posicaoVetorJogadores).getPropriedades().get(i)).getCor() == "Verde") {
                        verde++;

                    } else {
                        azulMarinho++;

                    }
                    if ((tabuleiro.getLocal(posicaoTabuleiro)) instanceof Terreno) {
                        if ((magenta == 3 && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor() == "Magenta"))
                                || (azulClaro == 3 && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor() == "Azul Claro"))
                                || (roxo == 3 && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor() == "Roxo"))
                                || (vermelho == 3 && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor() == "Vermelho"))
                                || (amarelo == 3 && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor() == "Amarelo"))
                                || (verde == 3 && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor() == "Verde"))
                                || (azulMarinho == 3 && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor() == "Azul Marinho"))) {

                            if (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getNumeroDeCasas() >= 0
                                    && ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getNumeroDeCasas() < 4
                                    && ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).isTemHotel() == false) {
                                if (podeComprarCasa(((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor(), tabuleiro, jogadores.get(posicaoVetorJogadores))) {

                                    if (jogadores.get(posicaoVetorJogadores).getDinheiro() > ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getComprarCasa()) {
                                        ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).setNumeroDeCasas(
                                                ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getNumeroDeCasas() + 1);
                                        banco.setCasas(banco.getCasas() - 1);
                                        pagaBanco(banco, jogadores.get(posicaoVetorJogadores), ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getComprarCasa(), jogadores);

                                        break;
                                    } else {
                                        break;
                                    }
                                }
                            } else if (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getNumeroDeCasas() == 4
                                    && (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro()))).isTemHotel() == false) {
                                if (podeComprarHotel(((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getCor(), tabuleiro, jogadores.get(posicaoVetorJogadores))) {
                                    if (jogadores.get(posicaoVetorJogadores).getDinheiro() > (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro()))).getComprarHotel()) {
                                        ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).setNumeroDeCasas(((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getNumeroDeCasas() - 4);
                                        ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).setTemHotel(true);
                                        banco.setHoteis(banco.getHoteis() - 1);
                                        banco.setCasas(banco.getCasas() + 4);
                                        pagaBanco(banco, jogadores.get(posicaoVetorJogadores), ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getComprarHotel(), jogadores);
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                            } else if (((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).getNumeroDeCasas() == 0
                                    && ((Terreno) tabuleiro.getLocal(jogadores.get(posicaoVetorJogadores).getPosicaoTabuleiro())).isTemHotel() == true) {

                            }
                        }
                    }//condicoes de Terreno da posicao no tabuleiro 
                }//If de instanceof Terreno da propriedade do jogador
            }//for 
        } else if (jogadores.get(posicaoVetorJogadores).getDinheiro() >= 800) {
            comprar(banco, (Propriedade) tabuleiro.getLocal(posicaoTabuleiro), jogadores.get(posicaoVetorJogadores), jogadores);
            System.out.println("O jogador comprou " + jogadores.get(posicaoVetorJogadores).getNome() + tabuleiro.getLocal(posicaoTabuleiro).getNome());
        }
    }

    public boolean podeComprarCasa(String cor, Tabuleiro tabuleiro, Jogador jogador) {
        int indice = 0;
        int[] vetorCasas = {0, 0};
        for (int i = 0; i < jogador.getPropriedades().size(); i++) {
            if ((jogador.getPropriedades().get(i)) instanceof Terreno) {
                if ((((Terreno) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getNome()) != (((Terreno) jogador.getPropriedades().get(i)).getNome())
                        && ((((Terreno) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getCor()) == cor)
                        && ((Terreno) jogador.getPropriedades().get(i)).getCor() == cor) {
                    vetorCasas[indice] = ((Terreno) jogador.getPropriedades().get(i)).getNumeroDeCasas();
                    indice++;

                }
            }
        }

        if ((((Terreno) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getNumeroDeCasas() <= vetorCasas[0]) && (((Terreno) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getNumeroDeCasas() <= vetorCasas[1])) {
            return true;

        } else {
            return false;
        }
    }

    public boolean podeComprarHotel(String cor, Tabuleiro tabuleiro, Jogador jogador) {
        int indice = 0;
        int[] vetorCasas = {0, 0};
        int[] vetorHotel = {0, 0};
        for (int i = 0; i < jogador.getPropriedades().size(); i++) {
            if ((jogador.getPropriedades().get(i)) instanceof Terreno) {
                if ((((Terreno) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getNome()) != (((Terreno) jogador.getPropriedades().get(i)).getNome())
                        && ((((Terreno) tabuleiro.getLocal(jogador.getPosicaoTabuleiro())).getCor()) == cor)
                        && ((Terreno) jogador.getPropriedades().get(i)).getCor() == cor) {
                    vetorCasas[indice] = ((Terreno) jogador.getPropriedades().get(i)).getNumeroDeCasas();
                    if (((Terreno) jogador.getPropriedades().get(i)).isTemHotel()) {
                        vetorHotel[indice] = 1;
                    } else {
                        vetorHotel[indice] = 0;
                    }
                    indice++;
                }
            }
        }
        if (((vetorCasas[0] == 4) || (vetorHotel[0] == 1)) && ((vetorCasas[0] == 4) || (vetorHotel[0] == 1))) {
            return true;

        } else {
            return false;
        }
    }

    /*
    Transferencia de notas do banco para o jogador
     */
    public void transferir(Banco banco, Jogador jogA, int valorDaNota, int quantidadeDeNotas) {
        for (int i = 0; i < 6; i++) {
            if (banco.getNotas().get(i).getValor() == valorDaNota) {
                if (banco.getNotas().get(i).getQuantidade() >= quantidadeDeNotas) {
                    jogA.getNotas().get(i).aumentar(quantidadeDeNotas);
                    banco.getNotas().get(i).aumentar(-quantidadeDeNotas);
                    break;
                } else {
                    System.out.println("Quantidade Insuficiente");

                    break;
                }
            }
        }
    }

    /*
    Transferencia de notas do banco para o jogador
     */
    public void transferir(Banco banco, Jogador jogA, int valor) {
        int saldo = valor;
        if (saldo > 0) {
            if ((int) saldo / 500 >= 1) {
                jogA.transferir(banco, jogA, 500, (int) saldo / 500);
                saldo -= 500 * ((int) saldo / 500);
            } else if ((int) saldo / 100 >= 1) {
                jogA.transferir(banco, jogA, 100, (int) saldo / 100);
                saldo -= 100 * ((int) saldo / 100);
            } else if ((int) saldo / 50 >= 1) {
                jogA.transferir(banco, jogA, 50, (int) saldo / 50);
                saldo -= 50 * ((int) saldo / 50);
            } else if ((int) saldo / 10 >= 1) {
                jogA.transferir(banco, jogA, 10, (int) saldo / 10);
                saldo -= 10 * ((int) saldo / 10);
            } else if ((int) saldo / 5 >= 1) {
                jogA.transferir(banco, jogA, 5, (int) saldo / 5);
                saldo -= 5 * ((int) saldo / 5);
            } else if (saldo >= 1) {
                jogA.transferir(banco, jogA, 1, saldo);
                saldo -= saldo;
            }
        } else {
            if (((int) -saldo / 500) >= 1) {
                jogA.transferir(banco, jogA, 500, (int) saldo / 500);
                saldo += 500 * ((int) -saldo / 500);
            }
            if (((int) -saldo / 100) >= 1) {
                jogA.transferir(banco, jogA, 100, (int) saldo / 100);
                saldo += 100 * ((int) -saldo / 100);
            } else if (((int) -saldo) / 50 >= 1) {
                jogA.transferir(banco, jogA, 50, (int) saldo / 50);
                saldo += 50 * ((int) saldo / 50);
            } else if (((int) -saldo) / 10 >= 1) {
                jogA.transferir(banco, jogA, 10, (int) saldo / 10);
                saldo += 10 * ((int) saldo / 10);
            } else if (((int) -saldo) / 5 >= 1) {
                jogA.transferir(banco, jogA, 5, (int) saldo / 5);
                saldo += 5 * ((int) saldo / 5);
            } else if ((-saldo) >= 1) {
                jogA.transferir(banco, jogA, 1, saldo);
            }
        }

    }

    public void transferir(Jogador jogA, Jogador jogB, int valor) {
        int saldo = valor;
        if (saldo > 0) {
            if ((int) saldo / 500 >= 1) {
                jogA.transferir(jogA, jogB, 500, (int) saldo / 500);
                saldo -= 500 * ((int) saldo / 500);
            } else if ((int) saldo / 100 >= 1) {
                jogA.transferir(jogA, jogB, 100, (int) saldo / 100);
                saldo -= 100 * ((int) saldo / 100);
            } else if ((int) saldo / 50 >= 1) {
                jogA.transferir(jogA, jogB, 50, (int) saldo / 50);
                saldo -= 50 * ((int) saldo / 50);
            } else if ((int) saldo / 10 >= 1) {
                jogA.transferir(jogA, jogB, 10, (int) saldo / 10);
                saldo -= 10 * ((int) saldo / 10);
            } else if ((int) saldo / 5 >= 1) {
                jogA.transferir(jogA, jogB, 5, (int) saldo / 5);
                saldo -= 5 * ((int) saldo / 5);
            } else if (saldo >= 1) {
                jogA.transferir(jogA, jogB, 1, saldo);
                saldo -= saldo;
            }
        } else {
            if (((int) -saldo / 500) >= 1) {
                jogA.transferir(jogA, jogB, 500, (int) saldo / 500);
                saldo += 500 * ((int) -saldo / 500);
            }
            if (((int) -saldo / 100) >= 1) {
                jogA.transferir(jogA, jogB, 100, (int) saldo / 100);
                saldo += 100 * ((int) -saldo / 100);
            } else if (((int) -saldo) / 50 >= 1) {
                jogA.transferir(jogA, jogB, 50, (int) saldo / 50);
                saldo += 50 * ((int) saldo / 50);
            } else if (((int) -saldo) / 10 >= 1) {
                jogA.transferir(jogA, jogB, 10, (int) saldo / 10);
                saldo += 10 * ((int) saldo / 10);
            } else if (((int) -saldo) / 5 >= 1) {
                jogA.transferir(jogA, jogB, 5, (int) saldo / 5);
                saldo += 5 * ((int) saldo / 5);
            } else if ((-saldo) >= 1) {
                jogA.transferir(jogA, jogB, 1, saldo);
            }
        }

    }

    /*
    Transferencia de notas do jogador A para o JOgador B 
     */
    public void transferir(Jogador jogA, Jogador jogB, int valorDaNota, int quantidadeDeNotas) {
        for (int i = 0; i < 6; i++) {
            if (jogA.getNotas().get(i).getValor() == valorDaNota) {
                if (jogA.getNotas().get(i).getQuantidade() >= quantidadeDeNotas) {
                    jogA.getNotas().get(i).aumentar(-quantidadeDeNotas);
                    jogB.getNotas().get(i).aumentar(quantidadeDeNotas);
                    break;
                } else {
                    System.out.println("Quantidade insuficiente");
                    break;
                }
            }
        }
    }

    public void trocarNotas(Jogador player, int valorTroca, Banco banco) {

        int qtdeNotas = valorTroca / 10;

        player.getNotas().get(valorTroca).diminuir(valorTroca);
        banco.getNotas().get(valorTroca).aumentar(valorTroca);

        player.getNotas().get(valorTroca).aumentar(qtdeNotas);
        banco.getNotas().get(valorTroca).diminuir(qtdeNotas);

    }

    public String toString() {
        String out = "";
        out += " " + getNome() + " *\n";
        out += "Dinheiro Inicial: " + getSaldo() + "\n";
        out += "Dinheiro: " + getDinheiro() + "\n";
        out += "* Propriedades *\n";
        if (propriedades.size() == 0) {
            out += "Este jogador nao possui propriedades\n";
        } else {
            for (int i = 0; i < propriedades.size(); i++) {
                out += "\t * " + propriedades.get(i).getNome() + "\n";
            }
        }
        return out;
    }

}
