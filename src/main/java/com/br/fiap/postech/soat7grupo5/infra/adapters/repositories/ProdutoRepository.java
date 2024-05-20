package com.br.fiap.postech.soat7grupo5.infra.adapters.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.br.fiap.postech.soat7grupo5.domain.Produto;
import com.br.fiap.postech.soat7grupo5.domain.ports.repositories.ProdutoRepositoryPort;
import com.br.fiap.postech.soat7grupo5.infra.adapters.entities.ProdutoEntity;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    public ProdutoRepository(ProdutoRepositoryJpa produtoRepositoryJpa) {
        this.produtoRepositoryJpa = produtoRepositoryJpa;
    }

    @Override
    public List<Produto> buscarTodos() {
        List<ProdutoEntity> produtoEntities = this.produtoRepositoryJpa.findAll();
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public List<Produto> buscarTodosAtivos() {
        List<ProdutoEntity> produtoEntities = this.produtoRepositoryJpa.findByFlAtivoOrderByIdTipoAsc(1);
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }
    
	@Override
	public List<Produto> buscarTodosPorTipo(int idTipo) {
		List<ProdutoEntity> produtoEntities = this.produtoRepositoryJpa.findByIdTipo(idTipo);
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
	}

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoEntity;
        if (produto.getIdProduto() == 0)
            produtoEntity = new ProdutoEntity(produto);
        else {
            produtoEntity = this.produtoRepositoryJpa.findById(produto.getIdProduto()).get();
            produtoEntity.atualizar(produto);
        }
        this.produtoRepositoryJpa.save(produtoEntity);
    }
    
    public void deletar(int idProduto) {
        ProdutoEntity produtoEntity = this.produtoRepositoryJpa.findById(idProduto).get();
        produtoEntity.desativar();
        this.produtoRepositoryJpa.save(produtoEntity);
    }
    
//  @Override
//  public Produto buscarPeloSku(String sku) {
//      Optional<ProdutoEntity> produtoEntity = this.produtoRepositoryJpa.findBySku(sku);
//
//      if (produtoEntity.isPresent())
//          return produtoEntity.get().toProduto();
//
//      throw new RuntimeException("Produto não existe");
//  }
}