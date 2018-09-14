/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class TestaVenda {

    public static void main(String[] argv) throws Exception {
        InputStreamReader reader;
        reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        System.out.print("Entre com o fornecedor desejado: ");
        String nome = in.readLine();
        System.out.print("Entre com o telefone do fornecedor: ");
        String telefone = in.readLine();
        System.out.print("Entre com o código do fornecedor: ");
        int codigo = Integer.parseInt(in.readLine());
        Fornecedor Apple = new Fornecedor(nome, telefone, codigo);

        Produto macbook = new Produto("Macbook", 10000, Apple);
        macbook.setEstoque(10);
        macbook.setEstoqueMinimo(5);
        Perecivel bateria = new Perecivel(15, 4, 2016, "bateria", 500, Apple);
        bateria.setEstoque(10);
        bateria.setEstoqueMinimo(5);
        Item baterias = new Item(1, 2, bateria);
        Item computadores = new Item(2, 1, macbook);

        Cliente paulo = new Cliente("Paulo", "147601", "Unicamp");

        Data hoje = new Data(9, 11, 2016);

        Pedido primeiroPedido = new Pedido(1, paulo, "Casas Bahia", hoje);
        Pedido segundoPedido = new Pedido(2, paulo, "Lojas Americanas", hoje);
        Pedido terceiroPedido = new Pedido(3, paulo, "Lojas Americanas", hoje);

        primeiroPedido.adicionaItem(baterias);
        primeiroPedido.adicionaItem(computadores);

        segundoPedido.adicionaItem(computadores);
        segundoPedido.adicionaItem(baterias);

        terceiroPedido.adicionaItem(computadores);
        terceiroPedido.adicionaItem(baterias);

        ArrayList<Venda> v = new ArrayList<Venda>();
        VendaVista vv;
        vv = new VendaVista(hoje, 0.3);
        VendaPrazo vp;
        vp = new VendaPrazo(hoje, 1.1);

        System.out.print("Digite a opcao desejada: " + "\n" + "1->Criar uma venda" + "\n");
        System.out.print("2->Exibir Relatorio de venda" + "\n" + "3-> Sair" + "\n");

        int opcao = Integer.parseInt(in.readLine());

        while ((opcao == 1) || (opcao == 2) || (opcao == 3)) {

            switch (opcao) {
                case 1:
                    System.out.println("Para venda a vista digite 1 ou para venda a prazo digite 2");
                    int opcao2 = 0;
                    opcao2 = Integer.parseInt(in.readLine());
                    switch (opcao2) {
                        case 1:
                            vv.adicionaPedido(segundoPedido);
                            v.add(vv);
                            break;
                        case 2:
                            vp.adicionaPedido(primeiroPedido);
                            v.add(vp);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opcao Invalida");
                    }
                    break;

                case 2:

                    for (int i = 0; i < v.size(); i++) {
                        System.out.println("Venda numero " + i + " \n " + v.get(i).toString());
                    }
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida");
            }

            System.out.print("Digite a opcao desejada: " + "\n" + "1->Criar uma venda" + "\n");
            System.out.print("2->Exibir Relatorio de venda" + "\n" + "3-> Sair" + "\n");
            opcao = Integer.parseInt(in.readLine());

        }

    }

}
