package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.CD;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.Vinil;
import projeto_final_bloco_01.util.Cores;
import projeto_final_bloco_01.util.InputUtils;

public class Menu {

	public static void main(String[] args) {
		
		ProdutoController produto = new ProdutoController();
		
		// Criação de Produtos teste
		
		produto.criarProduto(new CD(produto.gerarNumero(), "Rare", 39.90f, 20, "Álbum de estúdio da Selena Gomez lançado em 2020.", 13));
		produto.criarProduto(new CD(produto.gerarNumero(), "Chromatica", 42.90f, 15, "O sexto álbum de estúdio da Lady Gaga com batidas eletrônicas marcantes.", 16));
		produto.criarProduto(new Vinil(produto.gerarNumero(), "Revival (Vinil)", 99.90f, 10, "Edição especial em vinil rosa translúcido.", 7));
		produto.criarProduto(new Vinil(produto.gerarNumero(), "The Fame Monster (Vinil)", 119.90f, 6, "Vinil duplo com encarte exclusivo e poster da turnê.", 7));

		
		int opcao = -1, quantidadeFaixas, tamanhoVinil, quantidadeEmEstoque, id, tipo;
		String nome, descricao;
		float preco;
		
		
		Scanner leia = new Scanner(System.in);
		
		while(true) {
			System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +
					           "┌─────────────────────────────────────────┐");
	        System.out.println("│             MENU PRINCIPAL              │");
	        System.out.println("├─────────────────────────────────────────┤"+ Cores.TEXT_RESET);
	        System.out.println(Cores.ANSI_LILAC_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_PETROLEUM +
	        		           "│                                         │");
	        System.out.println("│ 1 - Cadastrar um produto                │");
	        System.out.println("│ 2 - Atualizar um produto                │");
	        System.out.println("│ 3 - Consultar produto                   │");
	        System.out.println("│ 4 - Deletar um produto                  │");
	        System.out.println("│ 5 - Listar todos os produtos            │");
	        System.out.println("│ 6 - Listar todos os produtos (Resumido) │");
	        System.out.println("│                                         │");
	        System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +
	        		           "│                                         │");
	        System.out.println("│ 0 - Sair                                │");
	        System.out.println("└─────────────────────────────────────────┘" + Cores.TEXT_RESET);
	        
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
		            nome = leia.nextLine();
		            System.out.print(" Descrição do produto: ");
		            descricao = leia.nextLine();
		            preco = InputUtils.lerFloat(" Preço: ");
		            quantidadeEmEstoque = InputUtils.lerInt(" Quantidade em Estoque: ");
		            
		            do {
		            	tipo = InputUtils.lerInt(" Tipo de produto a cadastrar (1 - CD | 2 - Vinil): ");
		            	
		            	if(tipo == 1) {
		            		quantidadeFaixas = InputUtils.lerInt(" Quantidade de Faixas: ");
	            			produto.criarProduto(new CD(produto.gerarNumero(), nome, preco, quantidadeEmEstoque, descricao, quantidadeFaixas));
	            			break;
		            			
		            	} else if (tipo == 2) {
		            		tamanhoVinil = InputUtils.lerInt(" Tamanho do Vinil (em polegadas): ");
	            			produto.criarProduto(new Vinil(produto.gerarNumero(), nome, preco, quantidadeEmEstoque, descricao, tamanhoVinil));
	            			break;
		            			
		            	} else { 
		            		System.err.println("Inválido. Tente novamente.");
		            	}
		            	
		            } while(true);
		            
		        }
		        
		        case 2 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│      ATUALIZAR PRODUTO       │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            id = InputUtils.lerInt(" Digite o ID do produto: ");
		            
		            Optional <Produto> buscaProduto = produto.buscarNaCollection(id);
		            
		            if(buscaProduto.isPresent()) {
		            	System.out.print(" Nome do produto: ");
			            leia.skip("\\R");
			            nome = leia.nextLine();
			            System.out.print(" Descrição do produto: ");
			            descricao = leia.nextLine();
			            preco = InputUtils.lerFloat(" Preço: ");
			            quantidadeEmEstoque = InputUtils.lerInt(" Quantidade em Estoque: ");
			            
			            if(buscaProduto.get() instanceof CD cd) {
			            	quantidadeFaixas = InputUtils.lerInt(" Quantidade de Faixas: ");
	            			produto.atualizarProduto(new CD(cd.getId(), nome, preco, quantidadeEmEstoque, descricao, quantidadeFaixas));
			            
			            } else if (buscaProduto.get() instanceof Vinil vinil) {
			            	tamanhoVinil = InputUtils.lerInt(" Tamanho do Vinil (em polegadas): ");
	            			produto.atualizarProduto(new Vinil(vinil.getId(), nome, preco, quantidadeEmEstoque, descricao, tamanhoVinil));
			            	
			            }
		            } else {
		            	System.err.println(" Nenhum resultado de produto cadastrado para o ID " + id + ".");
		            }
		            
		        	keyPress();
		        }
		        
		        case 3 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│      CONSULTAR PRODUTO       │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            id = InputUtils.lerInt(" Digite o ID do produto: ");
		        	produto.consultarProdutoPorId(id);
		        	keyPress();
		        }
		        
		        case 4 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│       DELETAR PRODUTO        │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            boolean retornoFuncao = true;
		            do {
		            	id = InputUtils.lerInt(" Digite o ID do produto: ");
			            retornoFuncao = produto.deletarProduto(id);		           
		            } while(retornoFuncao);
		            
		            keyPress();
		        }
		        
		        case 5 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +"\n┌──────────────────────────────┐");
		            System.out.println("│     PRODUTOS CADASTRADOS     │");
		            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
		            produto.listarTodosProdutos();
		            keyPress();
		        }
		        
		        case 6 -> {
		        	System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD +
		        			         "\n┌─────────────────────────────────────────┐");
		            System.out.println("│     RESUMO DOS PRODUTOS CADASTRADOS     │");
		            System.out.println("└─────────────────────────────────────────┘" + Cores.TEXT_RESET);
		            produto.listarTodosProdutos(true);
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
