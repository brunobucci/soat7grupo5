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

import com.br.fiap.postech.soat7grupo5.application.usecases.produto.BuscarProdutosAtivosInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.BuscarProdutosPorTipoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.CriarProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.DeletarProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.produto.EditarProdutoInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Produtos", description = "Recursos relacionados aos produtos.")
@RequestMapping(path="produtos", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	
	private final CriarProdutoInteractor criarProdutoInteractor;
	private final BuscarProdutosAtivosInteractor buscarProdutosAtivosInteractor;
	private final BuscarProdutosPorTipoInteractor buscarProdutosPorTipoInteractor;
	private final DeletarProdutoInteractor deletarProdutoInteractor;
	private final EditarProdutoInteractor editarProdutoInteractor;
	
	private final ProdutoDTOMapper produtoDTOMapper;
	
    public ProdutoController(CriarProdutoInteractor criarProdutoInteractor, BuscarProdutosAtivosInteractor buscarProdutosAtivosInteractor, BuscarProdutosPorTipoInteractor buscarProdutosPorTipoInteractor, DeletarProdutoInteractor deletarProdutoInteractor, EditarProdutoInteractor editarProdutoInteractor, ProdutoDTOMapper produtoDTOMapper) {
        this.criarProdutoInteractor = criarProdutoInteractor;
        this.buscarProdutosAtivosInteractor = buscarProdutosAtivosInteractor;
        this.buscarProdutosPorTipoInteractor = buscarProdutosPorTipoInteractor;
        this.deletarProdutoInteractor = deletarProdutoInteractor;
        this.editarProdutoInteractor = editarProdutoInteractor;
        
        this.produtoDTOMapper = produtoDTOMapper;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro do produto.")
    ProdutoResponse criarProduto(@RequestBody ProdutoRequest request) {
    	Produto produtoBusinessObj = produtoDTOMapper.toProduto(request);
    	Produto produto = criarProdutoInteractor.criarProduto(produtoBusinessObj);
    	return produtoDTOMapper.toResponse(produto);
    }

    @PutMapping
    @Operation(summary = "Realiza a edição do produto.")
    ProdutoResponse editarProduto(@RequestBody ProdutoRequest request) {
    	Produto produtoBusinessObj = produtoDTOMapper.toProduto(request);
    	Produto produto = editarProdutoInteractor.editarProduto(produtoBusinessObj);
    	return produtoDTOMapper.toResponse(produto);
    }
    
    @DeleteMapping(path="/{idProduto}")
    @Operation(summary = "Realiza a remoção do produto.")
    void deletarProduto(@PathVariable int idProduto) {
    	deletarProdutoInteractor.deletarProduto(idProduto);
    }

    @GetMapping(path="/tipo/{idTipo}")
    @Operation(summary = "Busca os produtos cadastrados por tipo.")
    List<ProdutoResponse> buscarProdutosPorTipo(@Parameter(description = "ID do tipo de produto (1: Lanche, 2: Acompanhamento, 3: Bebida, 4: Sobremesa).", example = "1") @PathVariable int idTipo) {
    	List<Produto> produtos = buscarProdutosPorTipoInteractor.buscarProdutosPorTipo(idTipo);
    	return produtoDTOMapper.toResponseList(produtos);
    }
	
    
    @GetMapping
    @Operation(summary = "Busca todos os produtos cadastrados e ativos.")
    List<ProdutoResponse> buscarProdutosAtivos() {
    	List<Produto> produtos = buscarProdutosAtivosInteractor.buscarProdutosAtivos();
    	return produtoDTOMapper.toResponseList(produtos);
    }
    
}
