package projeto_final_bloco_01.model;

import projeto_final_bloco_01.util.Cores;

public class CD extends Produto {

	private int quantidadeFaixas;
	
	// Método Construtor
	public CD(int id, String nome, float preco, int quantidadeEmEstoque, String descricao, int quantidadeFaixas) {
		super(id, nome, preco, quantidadeEmEstoque, descricao);
		this.quantidadeFaixas = quantidadeFaixas;
	}

	// Getters and Setters
	public int getQuantidadeFaixas() {
		return quantidadeFaixas;
	}

	public void setQuantidadeFaixas(int quantidadeFaixas) {
		this.quantidadeFaixas = quantidadeFaixas;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(" QUANTIDADE DE FAIXAS: " + this.quantidadeFaixas);
		System.out.println(Cores.ANSI_LILAC_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_PETROLEUM + "────────────────────────────────" + Cores.TEXT_RESET);
	}
	
	public void visualizar(boolean resumido) {
		if(resumido) {
		super.visualizar(true);
		System.out.println(" TIPO DO PRODUTO: CD");
		System.out.println(Cores.ANSI_LILAC_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_PETROLEUM + "───────────────────────────────────────────" + Cores.TEXT_RESET);
		} else {
			visualizar();
		}
	}

}
