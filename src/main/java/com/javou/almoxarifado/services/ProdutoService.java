package com.javou.almoxarifado.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}
	

	@SuppressWarnings("unused")
	public Produto incluir(Produto produto) {
		try {
			Produto p = produtoRepository.getReferenceById(produto.getId());
			return null;
		} catch (EntityNotFoundException e) {
			return produtoRepository.save(produto);
		}
	}
	
	public String remover(String id) {
		try {
			produtoRepository.deleteById(id);
			return String.format("Cliente %s removido com sucesso", id);
		} catch (Exception e) {
			 return e.toString();
		}
	}
}
