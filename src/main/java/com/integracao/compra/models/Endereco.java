package com.integracao.compra.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe de endereço dos parceiros relacionados aos pedidos.
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String numero;
	private String rua;
	private String cep;
	private String cidade;
	private String uf;
	private String pais;
	private String bairro;
	private String complemento;
	private String latitude;
	private String longitude;
	private String codigoIbge;
	
	public Endereco() {
		
	}
	
	public Endereco(Long id, String numero, String rua, String cep, String cidade, String uf, String pais,
			String bairro, String complemento, String latitude, String longitude, String codigoIbge) {
		super();
		this.id = id;
		this.numero = numero;
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.bairro = bairro;
		this.complemento = complemento;
		this.latitude = latitude;
		this.longitude = longitude;
		this.codigoIbge = codigoIbge;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getCodigoIbge() {
		return codigoIbge;
	}
	
	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	
	
}
