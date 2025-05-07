package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		int opcao = -1;
		Scanner leia = new Scanner(System.in);
		
		while(true) {
			System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD + "┌──────────────────────────────┐");
	        System.out.println("│       MENU PRINCIPAL         │");
	        System.out.println("├──────────────────────────────┤"+ Cores.TEXT_RESET);
	        System.out.println(Cores.ANSI_LILAC_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_PETROLEUM + "│                              │");
	        System.out.println("│ 1 - Cadastrar um produto     │");
	        System.out.println("│ 2 - Atualizar um produto     │");
	        System.out.println("│ 3 - Consultar produto        │");
	        System.out.println("│ 4 - Deletar um produto       │");
	        System.out.println("│ 5 - Listar todos os produtos │");
	        System.out.println("│                              │");
	        System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD + "│                              │");
	        System.out.println("│ 0 - Sair                     │");
	        System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
	        
		        try {
		        System.out.print("\n Escolha uma opção: ");
		        opcao = leia.nextInt();
		        } catch(InputMismatchException e) {
		        	System.err.println(" Inválido. Digite apenas valores inteiros.");
		        	leia.nextLine();
		        	keyPress();
		        }
	        
	        switch(opcao) {
		        case 1 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│     CADASTRO DE PRODUTO      │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            System.out.print(" Nome do produto: ");
		            leia.skip("\\R");
		            
		            keyPress();
		        }
		        
		        case 2 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│      ATUALIZAR PRODUTO       │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            System.out.print(" Digite o ID do produto: ");
		            
		        	keyPress();
		        }
		        
		        case 3 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│      CONSULTAR PRODUTO       │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            System.out.print(" Digite o ID do produto: ");
		        			        	
		        	keyPress();
		        }
		        
		        case 4 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│       DELETAR PRODUTO        │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            
		           
		            keyPress();
		        }
		        
		        case 5 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│     PRODUTOS CADASTRADOS     │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            
		            keyPress();
		        }
		        
		        case 0 -> {
		        	System.out.println(" Saindo do sistema... Até logo!");
		        	leia.close();
		        	sobre();
		        	System.exit(0);
		        }
		        
		        default -> { System.err.println(" Inválido. Escolha novamente.");
		        keyPress();
		        }
	        } 
		}

	}

	public static void keyPress() {
		try {
			System.out.println("\n\n Pressione ENTER para continuar");
			System.in.read();
			
		} catch (IOException e) {
			System.err.println("Inválido. Pressione ENTER para continuar.");
		}
	}
	
	public static void sobre() {
		System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_WHITE_BOLD_BRIGHT + "\n*********************************************************");
		System.out.println(Cores.ANSI_LILAC_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_PETROLEUM_BOLD + " Projeto Desenvolvido por Renata Negrini                 ");
		System.out.println(" renata.negrini@gmail.com.br                             ");
		System.out.println(" github.com/renatangr                                    ");
		System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_WHITE_BOLD_BRIGHT + "*********************************************************");
	}
	
}
