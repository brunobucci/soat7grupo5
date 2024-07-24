package com.br.fiap.postech.soat7grupo5.infrastructure.gateways;

import java.util.List;
import java.util.Optional;

import com.br.fiap.postech.soat7grupo5.application.gateways.ProdutoGateway;
import com.br.fiap.postech.soat7grupo5.domain.entity.Produto;
import com.br.fiap.postech.soat7grupo5.infrastructure.gateways.mappers.ProdutoEntityMapper;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ProdutoEntity;
import com.br.fiap.postech.soat7grupo5.infrastructure.persistence.ProdutoRepository;

public class ProdutoRepositoryGateway implements ProdutoGateway{

	private final ProdutoRepository produtoRepository;
	private final ProdutoEntityMapper produtoEntityMapper;  
	
	public ProdutoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
		this.produtoRepository = produtoRepository;
		this.produtoEntityMapper = produtoEntityMapper;
	}

	@Override
	public Produto criarProduto(Produto produtoDomainObj) {
		ProdutoEntity produtoEntity = produtoEntityMapper.toEntity(produtoDomainObj); 
		ProdutoEntity savedObj = produtoRepository.save(produtoEntity);
		return produtoEntityMapper.toDomainObj(savedObj); 
	}
	
	@Override
	public Produto editarProduto(Produto produtoDomainObj) {
		ProdutoEntity produtoEntity = produtoEntityMapper.toEntity(produtoDomainObj); 
		ProdutoEntity savedObj = produtoRepository.save(produtoEntity);
		return produtoEntityMapper.toDomainObj(savedObj);
	}
	
	@Override
	public void deletarProduto(int idProduto) {
		Optional<ProdutoEntity> savedObj = produtoRepository.findById(idProduto);
		savedObj.get().setFlAtivo(0);
		produtoRepository.save(savedObj.get());
		//produtoRepository.deleteById(idProduto);
	}
	
	@Override
	public List<Produto> buscarProdutosAtivos() {
		List<ProdutoEntity> savedObjList = (List<ProdutoEntity>) produtoRepository.findByFlAtivoOrderByIdTipoAsc(1);
		return produtoEntityMapper.toDomainObjList(savedObjList); 
	}
	
	@Override
	public List<Produto> buscarProdutosPorTipo(int tipo) {
		List<ProdutoEntity> savedObjList = (List<ProdutoEntity>) produtoRepository.findByIdTipo(tipo);
		return produtoEntityMapper.toDomainObjList(savedObjList); 
	}
	
}
