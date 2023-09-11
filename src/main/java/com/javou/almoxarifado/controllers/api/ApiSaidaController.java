package com.javou.almoxarifado.controllers.api;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javou.almoxarifado.dto.SaidaDTO;
import com.javou.almoxarifado.dto.SaidaProdutoDTO;
import com.javou.almoxarifado.models.Saida;
import com.javou.almoxarifado.services.SaidaService;

@RestController
@RequestMapping("/api/saidas")
public class ApiSaidaController {


	private SaidaService saidaService;

	public ApiSaidaController(SaidaService saidaService) {
		this.saidaService = saidaService;
	}
	
	@CrossOrigin
	@GetMapping("/")
	public List<Saida> listarSaidas() {
		return saidaService.listarSaidas();
	}
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<Object> incluirSaida(@RequestBody Saida saida) {
		try {
			return new ResponseEntity<Object>(saidaService.incluirSaida(saida), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
	}
	
	// LISTAR ENTRADAS DTO API
	@CrossOrigin
	@GetMapping("/dto")
	public List<SaidaProdutoDTO> listarSaidasDTO() {
		try {
			return saidaService.listarSaidasDTO();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// INCLUIR ENTRADA DTO API
	@CrossOrigin
	@PostMapping("/dto")
	public Saida incluirSaidaDTO(@RequestBody SaidaDTO saida) {
		try {
			return saidaService.incluirSaidaDTO(saida);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
