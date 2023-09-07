package com.javou.almoxarifado.dto;

public class ProdutoUnidadeDTO {
	
	private String idProduto;
	private String nome;
	private String siglaUnidade;
	
	
//	CONSTRUTORES
	public ProdutoUnidadeDTO() {
	}

	public ProdutoUnidadeDTO(String idProduto, String nome, String siglaUnidade) {
		this.setIdProduto(idProduto);
		this.setNome(nome);
		this.setSiglaUnidade(siglaUnidade);
	}


	//GETTERS and SETTERS
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
