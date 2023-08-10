package com.javou.almoxarifado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javou.almoxarifado.models.Entrada;
import com.javou.almoxarifado.repository.EntradaRepository;

@Controller
public class EntradaController {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
//	Lista as entradas
	@GetMapping("/lista")
	public ModelAndView listar() {
		try {
			List<Entrada> entradas = entradaRepository.findAll();
			return new ModelAndView("entradas/listarEntradas", "listagem_entrada", entradas);			
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
		
	}

}
