package com.javou.almoxarifado.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javou.almoxarifado.dto.ProdutoUnidadeDTO;
import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}
	
	
	
	

//	@SuppressWarnings("unused")
//	public Produto incluir(Produto produto) {
//		try {
//			Produto p = produtoRepository.getReferenceById(produto.getId());
//			return null;
//		} catch (EntityNotFoundException e) {
//			return produtoRepository.save(produto);
//		}
//	}
	
// ALTERAR
//	public Produto alterar(Produto produto, String id) {
//		produto.setId(id);
//		return produtoRepository.save(produto);
//	}
	
	
//	REMOVER
	public String remover(String id) {
		try {
			produtoRepository.deleteById(id);
			return String.format("Cliente %s removido com sucesso", id);
		} catch (Exception e) {
			 return e.toString();
		}
	}
	
	
	
//	DTO
	public List<ProdutoUnidadeDTO> listarProdutosDTO() {
		return produtoRepository.getProdutoUnidadeDTO();
	}
	
	
	
//	Esse metodo seria se utilizasse MAP ao inves de DTO?
//	public List<ProdutoUnidadeDTO> listarProdutoUnidadeDTO() {
//		List<ProdutoUnidadeDTO> produtosDTO = new ArrayList<ProdutoUnidadeDTO>();
//		
//		produtoRepository.findAll().forEach(p -> produtosDTO.add(
//				new ProdutoUnidadeDTO(p.getId(), p.getNome(), p.getNome())));
//		
//		return produtosDTO;
//	}
	
	
	
	
	
}
