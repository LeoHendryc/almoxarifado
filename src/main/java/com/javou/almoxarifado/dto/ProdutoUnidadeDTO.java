package com.javou.almoxarifado.dto;

public class ProdutoUnidadeDTO {
	
	private int idProduto;
	private String nome;
	private int unidadeId;
	private String siglaUnidade;
	
	
//	CONSTRUTORES
	public ProdutoUnidadeDTO() {
	}

	public ProdutoUnidadeDTO(int idProduto, String nome, int unidadeId, String siglaUnidade) {
		this.setIdProduto(idProduto);
		this.setNome(nome);
		this.setUnidadeId(unidadeId);
		this.setSiglaUnidade(siglaUnidade);
	}


//	GETTERS and SETTERS
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
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
	
	public int getUnidadeId() {
		return unidadeId;
	}

	public void setUnidadeId(int unidadeId) {
		this.unidadeId = unidadeId;
	}

	
	
}
