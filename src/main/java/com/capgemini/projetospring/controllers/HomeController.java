package com.capgemini.projetospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//  Não é chamado de método dentro do controller e sim de Action
//	Pq tem como finalidade distribuir requisições
	
	@GetMapping("/") // GetMapping = Rota
	public String iniciar() { 
		return "index";
	}
	
	@GetMapping("/conteudo")
	public String mostrar(Model model) {
		
		double numero = Math.random();
		
		model.addAttribute("mensagem", "AddAtibute com SpringBoot");
		model.addAttribute("numero", "Numero gerado: " + numero);
		return "conteudo";
	}

}