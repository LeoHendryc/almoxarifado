package com.javou.almoxarifado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javou.almoxarifado.repository.UnidadeRepository;
import com.javou.almoxarifado.models.Unidade;

@Service
public class UnidadeService {

	@Autowired 
	private UnidadeRepository unidadeRepository;
	
	public List<Unidade> listarUnidades() {
		return unidadeRepository.findAll();
	}
	
	public Unidade incluir(Unidade unidade) {
		return unidadeRepository.save(unidade);	
	}
	
}
