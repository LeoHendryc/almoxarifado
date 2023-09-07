package com.javou.almoxarifado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javou.almoxarifado.dto.ProdutoUnidadeDTO;
import com.javou.almoxarifado.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	
	@Query("SELECT new com.javou.almoxarifado.dto.ProdutoUnidadeDTO("
			+ "p.id, p.nome, u.sigla) FROM Produto p INNER JOIN p.unidade u")
	List<ProdutoUnidadeDTO> getProdutoUnidadeDTO();

}
