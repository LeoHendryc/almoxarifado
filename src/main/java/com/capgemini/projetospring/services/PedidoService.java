package com.capgemini.projetospring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.ClientePedidosDTO;
import com.capgemini.projetospring.dto.PedidoDTO;
import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.models.Pedido;
import com.capgemini.projetospring.repository.ClienteRepository;
import com.capgemini.projetospring.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	private ClienteRepository clienteRepository;
	
	public Pedido incluirPedido(Map<String, String> dados) throws ParseException {
//		Obtendo os dados através da coleção Map:
		String cpf = dados.get("cpf");
		String npedido = dados.get("pedido");
		String data = dados.get("data");
		
//		obtendo cliente com base no cpf
		Cliente c = clienteRepository.getReferenceById(cpf);
		
//		obtendo o objeto Date com a base na data fornecida
		Date dataPedido = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		
//		Criando o objeto Pedido
		Pedido pedido = new Pedido();
		pedido.setCliente(c);
		pedido.setData(dataPedido);
		pedido.setNumeroPedido(npedido);
		
		pedidoRepository.save(pedido);
		
		return pedido;
	}
	
	public Pedido incluirPedido(PedidoDTO dados) throws ParseException {
		
//		obtendo cliente com base no cpf
		Cliente c = clienteRepository.getReferenceById(dados.getCpf());
		
//		obtendo o objeto Date com a base na data fornecida
		Date dataPedido = new SimpleDateFormat("yyyy-MM-dd").parse(dados.getData());
		
//		Criando o objeto Pedido
		Pedido pedido = new Pedido();
		pedido.setCliente(c);
		pedido.setData(dataPedido);
		pedido.setNumeroPedido(dados.getPedido());
		
		pedidoRepository.save(pedido);
		
		return pedido;
	}
	
//	Listar os Pedidos
	public List<ClientePedidosDTO> listarPedidos() {
		return pedidoRepository.getClientePedidosDTO();
	}

	public List<ClientePedidosDTO> listarPedidos(String cpf) {
		return pedidoRepository.getClientePedidosDTOByCpf(cpf);
	}

}



