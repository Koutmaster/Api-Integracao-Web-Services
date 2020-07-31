package com.integracao.compra.models;

import java.io.Serializable;

/**
 * Classe dos produtos pertencentes ao pedido a ser enviado ao Web Service de destino.
 */
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private float precoUnitario;
	private float quantidade;
	private String sku;
	private float valorTotal;
	
	
	public Produto(float precoUnitario, float quantidade, String sku, float valorTotal) {
		super();
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.sku = sku;
		this.valorTotal = valorTotal;
	}

	public Produto() {
		
	}
	
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
