package com.javou.almoxarifado.controllers.api;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javou.almoxarifado.dto.EntradaDTO;
import com.javou.almoxarifado.dto.EntradaProdutoDTO;
import com.javou.almoxarifado.models.Entrada;
import com.javou.almoxarifado.services.EntradaService;

@RestController
@RequestMapping("/api/entradas")
public class ApiEntradaController {


	private EntradaService entradaService;

	public ApiEntradaController(EntradaService entradaService) {
		this.entradaService = entradaService;
	}
	
	@CrossOrigin
	@GetMapping("/")
	public List<Entrada> listarEntradas() {
		return entradaService.listarEntradas();
	}
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<Object> incluirEntrada(@RequestBody Entrada entrada) {
		try {
			return new ResponseEntity<Object>(entradaService.incluirEntrada(entrada), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
	}
	
	// LISTAR ENTRADAS DTO API
	@CrossOrigin
	@GetMapping("/dto")
	public List<EntradaProdutoDTO> listarEntradasDTO() {
		try {
			return entradaService.listarEntradasDTO();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// INCLUIR ENTRADA DTO API
	@CrossOrigin
	@PostMapping("/dto")
	public Entrada incluirEntradaDTO(@RequestBody EntradaDTO entrada) {
		try {
			return entradaService.incluirEntradaDTO(entrada);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
