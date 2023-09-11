package com.javou.almoxarifado.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javou.almoxarifado.dto.SaidaDTO;
import com.javou.almoxarifado.dto.SaidaProdutoDTO;
import com.javou.almoxarifado.models.Saida;
import com.javou.almoxarifado.models.Produto;
import com.javou.almoxarifado.repository.SaidaRepository;
import com.javou.almoxarifado.repository.ProdutoRepository;

@Service
public class SaidaService {
	
	@Autowired
	private SaidaRepository saidaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Saida> listarSaidas() {
		return saidaRepository.findAll();
	}
	
	
// INCLUIR ENTRADA
	@SuppressWarnings("unused")
	public Saida incluirSaida(Saida saida) {
		try {
			Saida e = saidaRepository.getReferenceById(saida.getId());
			return null;
		} catch (Exception e) {
			return saidaRepository.save(saida);
		}
	}
	
//	DTO
	public List<SaidaProdutoDTO> listarSaidasDTO() {
		return saidaRepository.getSaidaProdutoDTO() ;
	}
	
	public Saida incluirSaidaDTO(SaidaDTO dados) throws ParseException {
		// obtendo o produto
		Produto p = produtoRepository.getReferenceById(dados.getProdutoId());
		
		// obtendo o objeto Date com base na data fornecida
		Date dataSaida = new SimpleDateFormat("yyyy-MM-dd").parse(dados.getData());
		
		// criando o objeto Saida
		Saida saida = new Saida();
		saida.setProduto(p); ;
		saida.setDataSaida(dataSaida);
		saida.setQuantidade(dados.getQuantidade());
		
		saidaRepository.save(saida);
		
		return saida;		
	}
}