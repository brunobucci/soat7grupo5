package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.produto;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5.application.usecases.ProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Produtos", description = "Recursos relacionados aos produtos.")
@RequestMapping(path="produtos", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	
	private final ProdutoInteractor produtoInteractor; 
	private final ProdutoDTOMapper produtoDTOMapper;
	
    public ProdutoController(ProdutoInteractor produtoInteractor, ProdutoDTOMapper produtoDTOMapper) {
        this.produtoInteractor = produtoInteractor;
        this.produtoDTOMapper = produtoDTOMapper;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro do produto.")
    ProdutoResponse criarProduto(@RequestBody ProdutoRequest request) {
    	Produto produtoBusinessObj = produtoDTOMapper.toProduto(request);
    	Produto produto = produtoInteractor.criarProduto(produtoBusinessObj);
    	return produtoDTOMapper.toResponse(produto);
    }

    @PutMapping
    @Operation(summary = "Realiza a edição do produto.")
    ProdutoResponse editarProduto(@RequestBody ProdutoRequest request) {
    	Produto produtoBusinessObj = produtoDTOMapper.toProduto(request);
    	Produto produto = produtoInteractor.editarProduto(produtoBusinessObj);
    	return produtoDTOMapper.toResponse(produto);
    }
    
    @DeleteMapping(path="/{idProduto}")
    @Operation(summary = "Realiza a remoção do produto.")
    void deletarProduto(@PathVariable int idProduto) {
    	produtoInteractor.deletarProduto(idProduto);
    }

    @GetMapping(path="/tipo/{idTipo}")
    @Operation(summary = "Busca os produtos cadastrados por tipo.")
    List<ProdutoResponse> buscarProdutosPorTipo(@Parameter(description = "ID do tipo de produto (1: Lanche, 2: Acompanhamento, 3: Bebida, 4: Sobremesa).", example = "1") @PathVariable int idTipo) {
    	List<Produto> produtos = produtoInteractor.buscarProdutosPorTipo(idTipo);
    	return produtoDTOMapper.toResponseList(produtos);
    }
	
    
    @GetMapping
    @Operation(summary = "Busca todos os produtos cadastrados e ativos.")
    List<ProdutoResponse> buscarProdutosAtivos() {
    	List<Produto> produtos = produtoInteractor.buscarProdutosAtivos();
    	return produtoDTOMapper.toResponseList(produtos);
    }
    
}
