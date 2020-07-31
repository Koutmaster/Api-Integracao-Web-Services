package com.integracao.compra.models;

import java.io.Serializable;

/**
 * Classe do endereço de Entrega.
 */
public class EnderecoEnvio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String bairro;
	private String cidade;
	private String complemento;
	private String logradouro;
	private String numero;
	private String pais;
	private String uf;
	
	
	public EnderecoEnvio(String bairro, String cidade, String complemento, String logradouro, String numero,
			String pais, String uf) {
		super();
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.pais = pais;
		this.uf = uf;
	}

	public EnderecoEnvio() {
		
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
