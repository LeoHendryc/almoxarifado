package com.javou.almoxarifado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javou.almoxarifado.dto.EntradaProdutoDTO;
import com.javou.almoxarifado.models.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
	
	@Query("SELECT new com.javou.almoxarifado.dto.EntradaProdutoDTO("
			+ "e.id, e.dataEntrada, e.quantidade, p.id, p.nome) FROM Entrada e INNER JOIN e.produto p")
	List<EntradaProdutoDTO> getEntradaProdutoDTO();
}
