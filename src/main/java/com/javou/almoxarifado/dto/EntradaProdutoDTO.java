package com.javou.almoxarifado.dto;

import java.util.Date;

public class EntradaProdutoDTO {
	
	private int id;
	private Date data;
	private int quantidade;
	private int produtoId;
	private String produtoNome;
	
	public EntradaProdutoDTO() {}

	public EntradaProdutoDTO(int id, Date data, int quantidade, int produtoId, String produtoNome) {
		this.setId(id);
		this.setData(data);
		this.setQuantidade(quantidade);
		this.setProdutoId(produtoId);
		this.setProdutoNome(produtoNome);
	}

	
	// ---------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}
	
	
}
