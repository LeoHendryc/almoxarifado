package com.javou.almoxarifado.dto;

public class EstoqueDTO {
	
	private int idProduto;
	private String nome;
	private String siglaUnidade;
	private int quantidade;
	
	
	public EstoqueDTO() {}
	
	
	public EstoqueDTO(int idProduto, String nome, String siglaUnidade, int quantidade) {
		this.setIdProduto(idProduto);
		this.setNome(nome);
		this.setSiglaUnidade(siglaUnidade);
		this.setQuantidade(quantidade);
	}
	

	// ---------------------------
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
}
