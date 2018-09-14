

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paulo
 */

/*
Questão 1:

O item não pode alterar o valor do código no fornecedor. Por causa de que o 
item apenas está associado ao produto e este associado ao fornedor. Nenhum dois dois tem uma relação
de herança.

Questão 2:

sim, porque um produto perecivel herda todas as propriedades e métodos de produto
e o item tem uma associação com o produto. O perecivel é um produto.

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestaPedido
{
    public static void main(String[] argv) throws Exception 
	{
	InputStreamReader reader;
        reader = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(reader);
        
        System.out.print("Entre com o fornecedor desejado: ");
        String nome=in.readLine();
        System.out.print("Entre com o telefone do fornecedor: ");
        String telefone=in.readLine();
        System.out.print("Entre com o código do fornecedor: ");
        int codigo=Integer.parseInt(in.readLine());
        Fornecedor Apple =new Fornecedor(nome,telefone,codigo );  
       
        Produto macbook = new Produto("Macbook",10000,Apple);
        macbook.setEstoque(10);
        macbook.setEstoqueMinimo(5);
        Perecivel bateria = new Perecivel(15,4,2016,"bateria", 500,Apple);
        bateria.setEstoque(10);
        bateria.setEstoqueMinimo(5);
        Item baterias =new Item(1,10,bateria);
        Item computadores= new Item(2,20,macbook);
     
   
       
        
        if(macbook.checarEstoqueMinimo())
       {
           System.out.print("Tem quantidade de estoque mínima de produto "+"\n");
       }
       
       else {
           System.out.print("Não Tem quantidade de estoque mínima "+"\n");
       }

            if(bateria.checarEstoqueMinimo())
       {
       System.out.print("Tem quantidade de estoque mínima do Produto Perecivel "+"\n");
       }
        
       else {
           System.out.print("Não Tem quantidade de estoque mínima "+"\n");
       }
            
       Cliente paulo=new Cliente("Paulo","147601","Unicamp");
       
       Data hoje = new Data(5,10,2016);
       
       Pedido primeiroPedido = new Pedido(1,paulo,"Casas Bahia", hoje);
       
       primeiroPedido.adicionaItem(baterias);
       primeiroPedido.adicionaItem(computadores);
   
       System.out.print(primeiroPedido);
       primeiroPedido.removeItem(1);
       System.out.print("\n");
       
       System.out.print(primeiroPedido);
        }

     
	
}
	
