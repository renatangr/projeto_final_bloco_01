package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;
import projeto_final_bloco_01.util.Cores;

public class ProdutoController implements ProdutoRepository {
	
	private ArrayList<Produto> produtosCadastrados = new ArrayList<Produto>();
	int id = 0;
	
	@Override
	public void criarProduto(Produto produto) {
		produtosCadastrados.add(produto);
		System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\n Produto " + produto.getNome() + " cadastrado com sucesso! \n" + Cores.TEXT_RESET);
		
	}

	@Override
	public void listarTodosProdutos() {
		for(var produto : produtosCadastrados) {
			produto.visualizar();
		}
		
	}

	@Override
	public void consultarProdutoPorId(int id) {
		Optional <Produto> produto = buscarNaCollection(id);
		
		if (produto.isPresent()) {
			System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD + "\n┌──────────────────────────────┐");
			System.out.println("│      PRODUTO CADASTRADO      │");
			System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
			produto.get().visualizar();
		} else {
			System.err.println(" Nenhum resultado obtido pela busca para o ID " + id + ".");
		}
	}

	@Override
	public void atualizarProduto(Produto produto) {
		Optional <Produto> buscaProduto = buscarNaCollection(produto.getId());
		
		if (buscaProduto.isPresent()) {
			produtosCadastrados.set(produtosCadastrados.indexOf(buscaProduto.get()), produto);
			System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\n O produto "+ produto.getNome() + " foi atualizado com sucesso!" + Cores.TEXT_RESET);
		} else {
			System.err.println(" Nenhum resultado de produto cadastrado para o ID " + produto.getId() + ".");
		}
		
	}

	@Override
	public boolean deletarProduto(int id) {
		
		var produto = buscarNaCollection(id);
		Scanner leia = new Scanner(System.in);
		String resposta;
		
		if(produto.isPresent()) {
			System.out.println(Cores.ANSI_LILAC_BACKGROUND + Cores.TEXT_BLUE_PETROLEUM_BOLD + "\n┌──────────────────────────────┐");
            System.out.println("│      PRODUTO CADASTRADO      │");
            System.out.println("└──────────────────────────────┘" + Cores.TEXT_RESET);
			produto.get().visualizar();
			
			do {
				System.out.print(Cores.ANSI_RED_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\n Confirma a exclusão do produto? (S/N) " + Cores.TEXT_RESET);
				resposta = leia.nextLine();
								
				if(resposta.equalsIgnoreCase("S")) {
					produtosCadastrados.remove(produto.get());
					System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\n O produto foi excluído com sucesso." + Cores.TEXT_RESET);
					return false;
				} else if (resposta.equalsIgnoreCase("N")) {
					System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\n Operação cancelada." + Cores.TEXT_RESET);
					return false;					
				} else {
					System.err.println("Inválido. Tente novamente.");
					return true;
				}
			} while(true);
			
		} else {
			
			System.err.println(" Não foi obtido nenhum resultado para o ID pesquisado.");
			
			while (true) {
				System.out.print(" Deseja tentar novamente? (S/N): ");
				resposta = leia.nextLine();
	            if (resposta.equalsIgnoreCase("S")) {
	                return true;
	            } else if (resposta.equalsIgnoreCase("N")) {
	                return false;
	            } else {
	                System.err.println(" Inválido. Digite S para sim ou N para não.");
	            }
			}
		}
	}
	
	// Métodos Auxiliares
		public int gerarNumero() {
			return ++ id;
		}

		public Optional<Produto> buscarNaCollection(int id) {
			for(var produto : produtosCadastrados) {
				if(produto.getId() == id) {
					return Optional.of(produto);
				}
			}
			
			return Optional.empty();
		}

}
