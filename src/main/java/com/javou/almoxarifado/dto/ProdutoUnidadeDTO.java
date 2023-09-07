package com.javou.almoxarifado.dto;

import com.javou.almoxarifado.models.Unidade;

public class ProdutoUnidadeDTO {
	
	private String idProduto;
	private String nome;
	private String siglaUnidade;
	
	
	public ProdutoUnidadeDTO() {
	}

	public ProdutoUnidadeDTO(String idProduto, String nome, String siglaUnidade) {
		this.setIdProduto(idProduto);
		this.setNome(nome);
		this.setSiglaUnidade(siglaUnidade);
//		this.idProduto = idProduto;
//		this.nome = nome;
//		this.siglaUnidade = siglaUnidade;
	}




//	public ProdutoUnidadeDTO(String id, String nome2, Unidade unidade) {
//		this.setIdProduto(id);
//		this.setNome(nome2);
//		this.setSiglaUnidade(getSiglaUnidade());
//	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSiglaUnidade() {
		return siglaUnidade;
	}


	public void setSiglaUnidade(String siglaUnidade) {
		this.siglaUnidade = siglaUnidade;
	}

	
	
}
