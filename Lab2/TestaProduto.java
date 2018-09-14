import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestaProduto
{

	public static void main(String[] argv) throws Exception 
	{
	InputStreamReader reader = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(reader);
	

	while(true){
		System.out.print("Selecione algumas das seguintes opções:\n");
		System.out.print("1)Criar Produto\n");
		System.out.print("2)Criar Produto Perecível\n");
		System.out.print("3)Sair\n");
	int opcao=Integer.parseInt(in.readLine());
	if(opcao==1)
			{
		System.out.print("Entre com a descricao do produto:");
		String descricao=in.readLine();
		
		Produto p1 = new Produto(descricao, 100.0);
				
		
		System.out.println(p1);
				
			}
			
			else if(opcao==2)
					{
						System.out.print("Entre com a descricao do produto perecivel:");
						String descricao=in.readLine();

						System.out.println("Entre com a validade do produto perecivel:");
							System.out.print("Dia: ");
							int dia=Integer.parseInt(in.readLine());
							System.out.print("Mes: ");
							int mes=Integer.parseInt(in.readLine());
							System.out.print("Ano: ");
							int ano=Integer.parseInt(in.readLine());
							
							System.out.print("Entre com o valor do produto perecivel:");
							double valor=Double.parseDouble(in.readLine());
							
							Perecivel pp1 = new Perecivel(dia, mes, ano,descricao, valor);
							System.out.println(pp1);
							
							if(pp1.estaVencido()==true)
							{
								System.out.println("O produto está vencido");
							}
							else 
							{
								System.out.println("O produto está dentro do prazo de validade");
								
							}
							
							pp1.aplicaDesconto(10);
							System.out.println(pp1);
						
						
					}
					
					else {
						
						
						return;
						
					}
	
	}
	
	}
	}	