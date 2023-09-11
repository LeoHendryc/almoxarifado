package com.javou.almoxarifado.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javou.almoxarifado.dto.EstoqueDTO;
import com.javou.almoxarifado.dto.ProdutoUnidadeDTO;
import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.models.Unidade;
import com.javou.almoxarifado.repository.ProdutoRepository;
import com.javou.almoxarifado.repository.UnidadeRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto incluir(Produto produto) {
		return produtoRepository.save(produto);
	}
	

	public Produto incluirProdutoDTO(ProdutoUnidadeDTO dados) {
		// obtendo o cliente com base no cpf
		Unidade u = unidadeRepository.getReferenceById(dados.getUnidadeId());
		
		// criando o objeto Produto
		Produto produto = new Produto();
		produto.setUnidade(u);
		produto.setNome(dados.getNome());
		
		produtoRepository.save(produto);
		
		return produto;		
	}
	
	
	
	
//	REMOVER
	public String remover(int id) {
		try {
			produtoRepository.deleteById(id);
			return String.format("Produto código %s removido com sucesso", id);
		} catch (Exception e) {
			 return e.toString();
		}
	}
	
	
	
//	DTO
	public List<ProdutoUnidadeDTO> listarProdutosDTO() {
		return produtoRepository.getProdutoUnidadeDTO();
	}
	
	public List<EstoqueDTO> listarEstoque(){
		return produtoRepository.getEstoque();
	}
	
	
}
