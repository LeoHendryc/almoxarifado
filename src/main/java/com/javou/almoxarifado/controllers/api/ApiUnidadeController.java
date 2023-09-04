package com.javou.almoxarifado.controllers.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.javou.almoxarifado.models.Unidade;
import com.javou.almoxarifado.services.UnidadeService;



@RestController
@RequestMapping("/api/unidades")
public class ApiUnidadeController {
	
	//@Autowired
	private UnidadeService unidadeService;
	
	public ApiUnidadeController(UnidadeService unidadeService) {
		this.unidadeService = unidadeService;
	}
	
	@CrossOrigin
	@GetMapping("/")
	public List<Unidade> listarUnidades() {
		return unidadeService.listarUnidades();
	}
	
	@PostMapping("/")	
	public ResponseEntity<Object> incluirUnidade(@RequestBody Unidade unidade) {
		try {
			return new ResponseEntity<Object>(unidadeService.incluir(unidade), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
		
	}
}
