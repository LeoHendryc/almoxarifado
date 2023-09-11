package com.javou.almoxarifado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javou.almoxarifado.dto.SaidaProdutoDTO;
import com.javou.almoxarifado.models.Saida;

public interface SaidaRepository extends JpaRepository<Saida, Integer>{

	@Query("SELECT new com.javou.almoxarifado.dto.SaidaProdutoDTO("
			+ "s.id, s.dataSaida, s.quantidade, p.id, p.nome) FROM Saida s INNER JOIN s.produto p")
	List<SaidaProdutoDTO> getSaidaProdutoDTO();
}
