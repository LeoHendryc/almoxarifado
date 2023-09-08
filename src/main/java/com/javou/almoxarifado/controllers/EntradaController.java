package com.javou.almoxarifado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javou.almoxarifado.models.Entrada;
import com.javou.almoxarifado.repository.EntradaRepository;

@Controller
@RequestMapping("/entrada")
public class EntradaController {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
//	LISTAR ENTRADAS
	@GetMapping("/lista")
	public ModelAndView listar() {
		try {
			List<Entrada> entradas = entradaRepository.findAll();
			return new ModelAndView("entradas/listarEntradas", "listagem_entradas", entradas);			
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
		
	}

//	CADASTRAR ENTRADAS
	@GetMapping("/novo")
	public ModelAndView incluir() {
		try {
			return new ModelAndView("entradas/novaEntrada");
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	@PostMapping("/novo")
	public String incluir(Entrada entrada, Model model) {
		try {
			entradaRepository.save(entrada);
			return "redirect:/entrada/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}

}
