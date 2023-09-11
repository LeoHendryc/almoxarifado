package com.javou.almoxarifado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javou.almoxarifado.dto.EstoqueDTO;
import com.javou.almoxarifado.dto.ProdutoUnidadeDTO;
import com.javou.almoxarifado.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	@Query("SELECT new com.javou.almoxarifado.dto.ProdutoUnidadeDTO("
			+ "p.id, p.nome, u.id, u.sigla) FROM Produto p INNER JOIN p.unidade u")
	List<ProdutoUnidadeDTO> getProdutoUnidadeDTO();

	@Query("SELECT new com.javou.almoxarifado.dto.EstoqueDTO("
			+ "p.id, p.nome, u.sigla, "
			+ "	CASE  WHEN (SUM(e.quantidade) - SUM(s.quantidade)) IS NULL THEN 0 "
			+ "		  ELSE (SUM(e.quantidade) - SUM(s.quantidade)) END AS quantidade) "
			+ "FROM Produto p "
			+ "LEFT JOIN p.unidade u "
			+ "LEFT JOIN p.entradas e "
			+ "LEFT JOIN p.saidas s "
			+ "GROUP BY p.id")
	List<EstoqueDTO> getEstoque();
}
