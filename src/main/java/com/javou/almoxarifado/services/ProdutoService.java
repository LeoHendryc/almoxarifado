package com.javou.almoxarifado.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
	public Produto incluir(Produto produto) {
		try {
			Produto p = produtoRepository.getReferenceById(produto.getId());
			return null;
		} catch (EntityNotFoundException e) {
			return produtoRepository.save(produto);
		}
	}
	
}
