package com.javou.almoxarifado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
//	Lista os Produtos
	public ModelAndView listar() {
		try {
			List<Produto> produtos = produtoRepository.findAll();
			return new ModelAndView("produtos/listarProdutos", "produtos_produtos", produtos);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	@PostMapping("/novo")
	public String incluir(Produto produto, Model model) {
		try {
			produtoRepository.save(produto);
			return "redirect:/produto/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
		
	}

}
