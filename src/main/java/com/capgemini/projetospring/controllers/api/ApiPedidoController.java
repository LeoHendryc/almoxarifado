package com.capgemini.projetospring.controllers.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.projetospring.dto.ClientePedidosDTO;
import com.capgemini.projetospring.dto.PedidoDTO;
import com.capgemini.projetospring.models.Pedido;
import com.capgemini.projetospring.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class ApiPedidoController {
	
	private PedidoService pedidoService;
	
//	Sempre que for usar Json usa RequestMapping
	@PostMapping("/")
	public Pedido incluirPedido(@RequestBody Map<String, String> dados) {
		try {
			return pedidoService.incluirPedido(dados);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
//	Action para incluir um pedido usando DTO
	@PostMapping("/incluir")
	public Pedido incluirPedido(@RequestBody PedidoDTO pedido) {
		try {
			return pedidoService.incluirPedido(pedido);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping(path = {})
	public List<ClientePedidosDTO> listarPedidos(
			@PathVariable(name= "cpf", required = false) String cpf) {
		try {
			if(cpf != null) {
				return pedidoService.listarPedidos(cpf);
			} else {
				return pedidoService.listarPedidos();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}

}
