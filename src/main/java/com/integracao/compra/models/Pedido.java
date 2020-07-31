package com.integracao.compra.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Classe do Pedido que entra na API e será tratado e armazenado para então ter seus dados 
 * transformados e enviados para o Web Service de destino.
 */
@Entity
@Table(name="pedido")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String numero;
	
	@OneToOne(cascade={CascadeType.PERSIST})
	private Parceiro representante;
	
	@OneToOne(cascade={CascadeType.PERSIST})
	private Parceiro cliente;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="pedido_id")
	private List<Item> itens;
	
	private String data;
	private String hora;
	private float valorFrete;
	private float valorDesconto;
	
	public Pedido() {
		
	}
	
	public Pedido(Long id, String numero, Parceiro representante, Parceiro cliente, List<Item> itens, String data,
			String hora, float valorFrete, float valorDesconto) {
		super();
		this.id = id;
		this.numero = numero;
		this.representante = representante;
		this.cliente = cliente;
		this.itens = itens;
		this.data = data;
		this.hora = hora;
		this.valorFrete = valorFrete;
		this.valorDesconto = valorDesconto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public float getValorFrete() {
		return valorFrete;
	}
	
	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}
	
	public float getValorDesconto() {
		return valorDesconto;
	}
	
	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
	public Parceiro getRepresentante() {
		return representante;
	}
	
	public void setRepresentante(Parceiro representante) {
		this.representante = representante;
	}
	
	public Parceiro getCliente() {
		return cliente;
	}
	
	public void setCliente(Parceiro cliente) {
		this.cliente = cliente;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	/**
	 * Método que calcula e retorna o valor total do pedido.
	 * @return float
	 */
	
	public float getValorTotal() {
		float valorTotal = 0;
		List<Item> produtos = this.getItens();
		for (Item produto : produtos) {
			valorTotal += produto.getValorTotal();
		}
		valorTotal -= this.getValorDesconto();
		valorTotal += this.getValorFrete();
		return valorTotal;
	}
	
	/**
	 * Método para retornar a quantidade de itens do Produto.
	 * @return int
	 */
	public int quantidadeItens() {
		return this.getItens().size();
	}
	
}
