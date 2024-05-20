package com.br.fiap.postech.soat7grupo5.adapters.controllers;

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

import com.br.fiap.postech.soat7grupo5.domain.dtos.ProdutoDTO;
import com.br.fiap.postech.soat7grupo5.domain.ports.interfaces.ProdutoServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Produtos", description = "Recursos relacionados aos produtos.")
@RequestMapping(path="produtos", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    @Operation(summary = "Realiza o cadastro do produto.")
    void salvarProdutos(@RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.salvarProduto(produtoDTO);
    }

    @PutMapping
    @Operation(summary = "Realiza a edição do produto.")
    void editarProdutos(@RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.salvarProduto(produtoDTO);
    }
    
    @DeleteMapping(path="/{idProduto}")
    @Operation(summary = "Realiza desativação do produto.")
    void deletarProdutos(@Parameter(description = "ID do produto.", example = "1") @PathVariable int idProduto) {
        produtoServicePort.deletarProdutos(idProduto);
    }
    
    @GetMapping
    @Operation(summary = "Retorna lista com todos os produtos ativos cadastrados.")
    //,description = "Endpoint de retorno para todos os produtos cadastrados.")
    List<ProdutoDTO> buscarProdutosAtivos() {
        return produtoServicePort.buscarProdutosAtivos();
    }
    
    @GetMapping(path="/tipo/{idTipo}")
    @Operation(summary = "Retorna lista com todos os produtos cadastrados por tipo.")
    //,description = "Endpoint de retorno para todos os produtos cadastrados.")
    List<ProdutoDTO> buscarProdutosPorTipo(@Parameter(description = "ID do tipo de produto (1: Lanche, 2: Acompanhamento, 3: Bebida, 4: Sobremesa).", example = "1") @PathVariable int idTipo) {
        return produtoServicePort.buscarProdutosPorTipo(idTipo);
    }

//    @PutMapping(value = "/{sku}")
//    void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDTO estoqueDTO) throws NotFoundException {
//        produtoServicePort.atualizarEstoque(sku, estoqueDTO);
//    }
}