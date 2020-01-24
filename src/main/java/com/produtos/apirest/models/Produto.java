package com.produtos.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
public class Produto  implements Serializable{

	// Atributo gerado pelo Serializable
	private static final long serialVersionUID = 1L;
	
	// Atributos da classe Produto
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Gera os Id no banco de dados automaticamente
	private long id;
	
	private String nome;
	
	private BigDecimal quatidade;
	
	private BigDecimal valor;

	// Métodos Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getQuatidade() {
		return quatidade;
	}

	public void setQuatidade(BigDecimal quatidade) {
		this.quatidade = quatidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
