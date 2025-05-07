package projeto_final_bloco_01.model;

import projeto_final_bloco_01.util.Cores;

public class Vinil extends Produto {
	
	private int tamanhoVinil;
	
	// Método Construtor
	public Vinil(int id, String nome, float preco, int quantidadeEmEstoque, String descricao, int tamanhoVinil) {
		super(id, nome, preco, quantidadeEmEstoque, descricao);
		this.tamanhoVinil = tamanhoVinil;
	}

	public int getTamanhoVinil() {
		return tamanhoVinil;
	}

	public void setTamanhoVinil(int tamanhoVinil) {
		this.tamanhoVinil = tamanhoVinil;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(Cores.ANSI_LILAC_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_PETROLEUM + " TAMANHO DO VINIL: " + this.tamanhoVinil);
		System.out.println("─────────────────────────────────────" + Cores.TEXT_RESET);
	}
	

}
