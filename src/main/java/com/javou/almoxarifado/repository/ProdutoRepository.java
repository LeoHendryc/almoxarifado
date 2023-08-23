package com.javou.almoxarifado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javou.almoxarifado.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{

}
