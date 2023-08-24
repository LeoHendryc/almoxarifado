package com.javou.almoxarifado.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "tipoId")
	private int tipoId;
	
//	@Column(name = "tipo_id")
//	private int tipo_id;
//	
	
	

	
	
//	Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}

//	public int getTipo_id() {
//		return tipo_id;
//	}
//
//	public void setTipo_id(int tipo_id) {
//		this.tipo_id = tipo_id;
//	}


	

		
	

}
