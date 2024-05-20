package com.br.fiap.postech.soat7grupo5.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import com.br.fiap.postech.soat7grupo5.domain.Produto;
import com.br.fiap.postech.soat7grupo5.domain.dtos.ProdutoDTO;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.ProdutoServicePort;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.ProdutoRepositoryPort;

public class ProdutoServiceImp implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public ProdutoServiceImp(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepository.buscarTodos();
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
    }
    
    @Override
	public List<ProdutoDTO> buscarProdutosAtivos() {
		List<Produto> produtos = this.produtoRepository.buscarTodosAtivos();
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
	}

    @Override
	public List<ProdutoDTO> buscarProdutosPorTipo(int idTipo) {
    	List<Produto> produtos = this.produtoRepository.buscarTodosPorTipo(idTipo);
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
	}

	@Override
	public void salvarProduto(ProdutoDTO produtoDTO) {
		Produto produto = new Produto(produtoDTO);
		this.produtoRepository.salvar(produto);
	}

	@Override
	public void deletarProdutos(int idProduto) {
		this.produtoRepository.deletar(idProduto);
	}

}