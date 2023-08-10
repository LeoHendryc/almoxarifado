package com.capgemini.projetospring.controllers;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes") // Seta o inicio das rotas, dessa forma nao precisa colocar /clientes/novo e / lista
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
//	Autowired - Injeção de dependência

	@GetMapping("/novo") // Igual a action do form
	public ModelAndView incluir() {
		try {
			return new ModelAndView("clientes/novoCliente");
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}

	@PostMapping("/novo") // Apontando para o action do form
	public String incluir(Cliente cliente, Model model) {
		try {
			clienteRepository.save(cliente);
			// System.out.println(cliente); // Teste para ver no console os dados
			// preenchidos no form
			// return "redirect:/clientes/novo"; //Redireciona para rota (URL)
			return "redirect:/clientes/lista"; // Redireciona para rota (URL)

		} catch (Exception e) {
//			return new ModelAndView("erro", "msg_erro", e.toString());
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}

//	LISTAGEM DOS CLIENTES
	@GetMapping("/lista")
	public ModelAndView listar() {
		try {
			List<Cliente> clientes = clienteRepository.findAll();
			return new ModelAndView("clientes/listaClientes", "listagem_clientes", clientes);

		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}

//	ALTERANDO DADOS DO CLIENTE
	@GetMapping("/alterar/{doc}")
	public ModelAndView alterar(@PathVariable("doc") String cpf) {
		try {
			Cliente cliente = clienteRepository.getReferenceById(cpf);
//	 Classe Cliente var = clienteRepository(bd).metodoBuscaPorId(Id buscado)
			return new ModelAndView("clientes/alterarCliente", "cliente", cliente);

		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	@PostMapping("/alterar") // Apontando para o action do form
	public String alterar(Cliente cliente, Model model) {
		try {
			clienteRepository.save(cliente);
			// System.out.println(cliente); // Teste para ver no console os dados
			// preenchidos no form
			// return "redirect:/clientes/novo"; //Redireciona para rota (URL)
			return "redirect:/clientes/lista"; // Redireciona para rota (URL)

		} catch (Exception e) {
//			return new ModelAndView("erro", "msg_erro", e.toString());
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
	@GetMapping("/remover/{doc}")
	public ModelAndView remover(@PathVariable("doc") String cpf) {
		try {
			Cliente cliente = clienteRepository.getReferenceById(cpf);
//	 Classe Cliente var = clienteRepository(bd).metodoBuscaPorId(Id buscado)
			return new ModelAndView("clientes/removerCliente", "cliente", cliente);

		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
		
	}
	//@RequestParam nao é doc é o nome no form que é cpf
	@PostMapping("/remover")
	public String remover(@RequestParam("cpf") String cpf, Model model) { 
		try {
			clienteRepository.deleteById(cpf);
			return "redirect:/clientes/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}

}
