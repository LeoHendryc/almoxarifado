package com.javou.almoxarifado.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javou.almoxarifado.dto.EntradaDTO;
import com.javou.almoxarifado.dto.EntradaProdutoDTO;
import com.javou.almoxarifado.models.Entrada;
import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.EntradaRepository;
import com.javou.almoxarifado.repository.ProdutoRepository;

@Service
public class EntradaService {
	
	@Autowired
	private EntradaRepository entradaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Entrada> listarEntradas() {
		return entradaRepository.findAll();
	}
	
	
// INCLUIR ENTRADA
	@SuppressWarnings("unused")
	public Entrada incluirEntrada(Entrada entrada) {
		try {
			Entrada e = entradaRepository.getReferenceById(entrada.getId());
			return null;
		} catch (Exception e) {
			return entradaRepository.save(entrada);
		}
	}
	
//	DTO
	public List<EntradaProdutoDTO> listarEntradasDTO() {
		return entradaRepository.getEntradaProdutoDTO() ;
	}
	
	public Entrada incluirEntradaDTO(EntradaDTO dados) throws ParseException {
		// obtendo o produto
		Produto p = produtoRepository.getReferenceById(dados.getProdutoId());
		
		// obtendo o objeto Date com base na data fornecida
		Date dataEntrada = new SimpleDateFormat("yyyy-MM-dd").parse(dados.getData());
		
		// criando o objeto Entrada
		Entrada entrada = new Entrada();
		entrada.setProduto(p); ;
		entrada.setDataEntrada(dataEntrada);
		entrada.setQuantidade(dados.getQuantidade());
		
		entradaRepository.save(entrada);
		
		return entrada;		
	}
}