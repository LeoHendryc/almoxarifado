package com.javou.almoxarifado.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipo {
	
	@Id
	private int id;
	
	private String descricao;
	
	

	
//	Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
