package com.br.fiap.postech.soat7grupo5.domain.ports.repositories;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.Produto;

public interface ProdutoRepositoryPort {
	void salvar(Produto produto);
	void deletar(int idProduto);
    List<Produto> buscarTodos();
    List<Produto> buscarTodosAtivos();
    List<Produto> buscarTodosPorTipo(int idTipo);
}
