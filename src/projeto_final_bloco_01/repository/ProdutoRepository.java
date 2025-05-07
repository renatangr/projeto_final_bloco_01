package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface ProdutoRepository {
	
	/* CRUD
	 * 
	 * CREATE
	 * READ
	 * UPDATE
	 * DELETE
	 * 
	 * */ 
	
	public void criarProduto(Produto produto);
	public void listarTodosProdutos();
	public void listarTodosProdutos(boolean resumido);
	public void consultarProdutoPorId(int id);
	public void atualizarProduto(Produto produto);
	public boolean deletarProduto(int id);
}
