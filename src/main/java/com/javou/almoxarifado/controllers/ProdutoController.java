package com.javou.almoxarifado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
//	LISTAR PRODUTOS
	@GetMapping("/lista")
	public ModelAndView listar() {
		try {
			List<Produto> produtos = produtoRepository.findAll();
			return new ModelAndView("produtos/listarProdutos", "listagem_produtos", produtos);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
//	CADASTRAR PRODUTOS
	@GetMapping("/novo")
	public ModelAndView incluir() {
		try {
			return new ModelAndView("produtos/novoProduto");
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}	
	}
	
	@PostMapping("/novo")
	public String incluir(Produto produto, Model model) {
		try {
			produtoRepository.save(produto);
			System.out.println(produto);
			return "redirect:/produto/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
	
//	@GetMapping("/novo")
//	public ModelAndView incluir() {
//		try {
//			List<Produto> produtos = produtoRepository.findAll();
//			return new ModelAndView("produtos/cadastrarProduto", "lista_produtos", produtos);
//		} catch (Exception e) {
//			return new ModelAndView("erro", "msg_erro", e.toString());
//		}	
//	}
	
//	public String incluir(@RequestParam("id") int id, Produto produto, Model model) {
//		try {
//			Produto produto1 = produtoRepository.getReferenceById(id);
//			produto1.setNome("");
//			System.out.println("id: "+id+ " produto: " + produto);
//			return "redirect:/produto/novo";
//		} catch (Exception e) {
//			model.addAttribute("msg_erro", e.toString());
//		}
//		return null;
//		
//	}

}
