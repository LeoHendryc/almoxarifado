package com.capgemini.projetospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.projetospring.dto.ItensPedidoDTO;
import com.capgemini.projetospring.models.Item;

//<String, Tipo da chave primaria>
public interface ItemRepository extends JpaRepository<Item, Integer>{

	@Query("SELECT new com.capgemini.projetospring.dto.ItensPedidoDTO("
			+ "it.id, ped.numeroPedido, it.preco, it.quantidade, prod.descricao) "
			+ "FROM Pedido ped, Item it, Produto prod WHERE "
			+ "ped.id = it.pedido.id AND prod.id = it.produto.id")
	List<ItensPedidoDTO> getItensPedidoDTO();
}
