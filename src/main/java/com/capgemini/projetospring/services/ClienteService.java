package com.capgemini.projetospring.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.projetospring.dto.ClienteDTO;
import com.capgemini.projetospring.models.Cliente;
import com.capgemini.projetospring.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public List<ClienteDTO> listarClientesDTO() {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		
		clienteRepository.findAll().forEach(c ->
		clientes.add(new ClienteDTO(c.getCpf(), c.getNome(), c.getTelefone(), c.getEmail())));
		
		return clientes;
	}
	
	public ClienteDTO buscarCliente(String cpf) {
		Cliente cliente = clienteRepository.getReferenceById(cpf);
		return new ClienteDTO(
				cliente.getCpf(),
				cliente.getNome(),
				cliente.getTelefone(),
				cliente.getEmail());
	}
	
	@SuppressWarnings("unused")
	public Cliente incluir(Cliente cliente) {
		try {
//			O metodo getReferenceById lança uma exceção caso o id informado
//			como parâmetro corresponda a uma entidade inexistente
			Cliente c = clienteRepository.getReferenceById(cliente.getCpf());
			return null;
		} catch (EntityNotFoundException e) {
//			throw e;
			return clienteRepository.save(cliente);
		}
	}
	
	
	public Cliente alterar(Cliente cliente, String cpf) {
		Cliente c = clienteRepository.getReferenceById(cpf);
		if(c ==null) {
			throw new EntityNotFoundException("O cliente a ser alterado não existe");
		}
		cliente.setCpf(cpf);
		return clienteRepository.save(cliente);
	}
	
//	void pq nao tem retorno - Foi alterado par String
	public String remover(String cpf) {
		try {
			clienteRepository.deleteById(cpf);
			return String.format("Cliente %s removido com sucesso!", cpf);
		} catch (Exception e) {
			return e.toString();
		}
	}
	
}
