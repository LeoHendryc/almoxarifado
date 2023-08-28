package com.javou.almoxarifado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javou.almoxarifado.models.Unidade;

public interface TipoRepository extends JpaRepository<Unidade, Integer>{

}
