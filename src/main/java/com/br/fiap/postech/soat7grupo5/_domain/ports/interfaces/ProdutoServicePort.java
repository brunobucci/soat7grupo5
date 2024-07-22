package com.br.fiap.postech.soat7grupo5.domain.ports.interfaces;

import java.util.List;

import com.br.fiap.postech.soat7grupo5.domain.dtos.ProdutoDTO;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

	List<ProdutoDTO> buscarProdutosPorTipo(int idTipo);

	void salvarProduto(ProdutoDTO produtoDTO);

	List<ProdutoDTO> buscarProdutosAtivos();

	void deletarProdutos(int idProduto);

}