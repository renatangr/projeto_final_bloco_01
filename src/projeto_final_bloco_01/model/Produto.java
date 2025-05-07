package projeto_final_bloco_01.model;

import java.text.NumberFormat;

import projeto_final_bloco_01.util.Cores;

public abstract class Produto {
	
	private int id;
	private String nome;
	private float preco;
	private int quantidadeEmEstoque;
	private String descricao;
	
	
	// Método Construtor 
	public Produto(int id, String nome, float preco, int quantidadeEmEstoque, String descricao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.descricao = descricao;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// Método visualizar
		public void visualizar() {
			NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
			
			System.out.println(Cores.ANSI_LILAC_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_PETROLEUM + " ID: " + this.id);
			System.out.println(" NOME: " + this.nome);
			System.out.println(" DESCRIÇÃO: " + this.descricao);
			System.out.println(" PREÇO: " + nfMoeda.format(this.preco));
			System.out.println(" QUANTIDADE EM ESTOQUE: " + this.quantidadeEmEstoque + Cores.TEXT_RESET);

		}
	
}
