package com.javou.almoxarifado.controllers.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javou.almoxarifado.dto.EstoqueDTO;
import com.javou.almoxarifado.dto.ProdutoUnidadeDTO;
import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.ProdutoRepository;
import com.javou.almoxarifado.services.ProdutoService;



@RestController
@RequestMapping("/api/produtos")
public class ApiProdutoController {
	
	//@Autowired
	private ProdutoService produtoService;
	
	public ApiProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@CrossOrigin
	@GetMapping("/")
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}
	

	@CrossOrigin
	@PostMapping("/")	
	public ResponseEntity<Object> incluirProduto(@RequestBody Produto produto) {
		try {
			return new ResponseEntity<Object>(produtoService.incluir(produto), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
		
	}
	
	
//	INCLUIR PRODUTO DTO API
	@PostMapping("/dto")
	public Produto incluirProdutoDTO(@RequestBody ProdutoUnidadeDTO produto) {
		return produtoService.incluirProdutoDTO(produto);
			
	}
	
//	LISTAR PRODUTOS API
	@GetMapping("/dto")
	public List<ProdutoUnidadeDTO> listarProdutosDTO() {
		try {
			return produtoService.listarProdutosDTO();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
//	DELETAR PRODUTOS API
	@DeleteMapping("/{id}")
	public String deleteProduto(@PathVariable int id) {
		return produtoService.remover(id);
	}
	
//	LISTAR ESTOQUE (PRODUTOS E SUAS QUANTIDADES NO ALMOXARIFADO)
	@GetMapping("/estoque")
	public List<EstoqueDTO> listarEstoque() {
		try {
			return produtoService.listarEstoque();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
