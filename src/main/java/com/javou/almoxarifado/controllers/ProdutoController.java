package com.javou.almoxarifado.controllers;

import java.util.List;

import org.springframework.beans.AbstractNestablePropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javou.almoxarifado.dto.ProdutoUnidadeDTO;
import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
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
			return "redirect:/produtos/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
//	ALTERAR PRODUTO
//	@GetMapping("/alterar/{id}")
//	public ModelAndView alterar(@PathVariable("id") String id) {
//		try {
//			Produto produto = produtoRepository.getReferenceById(id);
//			return new ModelAndView("produtos/alterarProduto", "produto", produto);
//		} catch (Exception e) {
//			return new ModelAndView("erro", "msg_erro", e.toString());
//		}
//	}
	
//	@GetMapping("/alterar")
//	public String alterar(Produto produto, Model model) {
//		try {
//			produtoRepository.save(produto);
//			return "redirect:/produtos/lista";
//		} catch (Exception e) {
//			model.addAttribute("msg_erro", e.toString());
//			return "erro";
//		}
//	}
	
	
//	REMOVER PRODUTO
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") String id) {
		try {
			Produto produto = produtoRepository.getReferenceById(id);
			return new ModelAndView("produtos/removerProduto", "produto", produto);
		} catch (Exception e) {
			return new ModelAndView("erro","msg_erro", e.toString());
		}
	}
	
	@PostMapping("/remover")
	public String remover(@RequestParam("id") String id, Model model) {
		try {
			produtoRepository.deleteById(id);
			return "redirect:/produtos/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
//	DTO
	
	@GetMapping("/todos")
	public ModelAndView listarTodosProdutos() {
		try {
			List<ProdutoUnidadeDTO> todosProdutos = produtoRepository.getProdutoUnidadeDTO();
			return new ModelAndView("produtos/listaTodosProdutos", "todos_produtos", todosProdutos);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	

}
