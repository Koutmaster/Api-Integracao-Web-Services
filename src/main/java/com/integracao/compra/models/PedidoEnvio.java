package com.integracao.compra.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe do pedido a ser enviado ao Web Service de destino.
 */
public class PedidoEnvio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpfCnpjCliente;
	private String cpfCnpjRepresentante;
	private EnderecoEnvio enderecoEntrega;
	private String numero;
	private List<Produto> produtos;
	private float valorDesconto;
	private float valorFrete;
	private float valorTotal;
	
	public PedidoEnvio() {
		
	}
	
	public PedidoEnvio(Pedido pedido) {
		//Criando o pedido de Envio com os dados do pedido original.
		this.setCpfCnpjCliente(pedido.getCliente().getCpfCnpj());
		this.setCpfCnpjRepresentante(pedido.getRepresentante().getCpfCnpj());
		this.setEnderecoEntrega(pedido);
		this.setNumero(pedido.getNumero());
		this.setProdutos(pedido);
		this.setValorDesconto(pedido.getValorDesconto());
		this.setValorFrete(pedido.getValorFrete());
		this.setValorTotal(pedido.getValorTotal());
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public String getCpfCnpjRepresentante() {
		return cpfCnpjRepresentante;
	}

	public void setCpfCnpjRepresentante(String cpfCnpjRepresentante) {
		this.cpfCnpjRepresentante = cpfCnpjRepresentante;
	}

	public EnderecoEnvio getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Pedido pedido) {
		//Recebe os dados de endereço do cliente
		String bairro = pedido.getCliente().getEndereco().getBairro();
		String cidade = pedido.getCliente().getEndereco().getCidade();
		String complemento = pedido.getCliente().getEndereco().getComplemento();
		String rua = pedido.getCliente().getEndereco().getRua();
		String numero = pedido.getCliente().getEndereco().getNumero();
		String pais = pedido.getCliente().getEndereco().getPais();
		String uf = pedido.getCliente().getEndereco().getUf();
		
		//Instanciando o entrega de envio com os dados do cliente
		EnderecoEnvio endereco = new EnderecoEnvio(bairro, cidade, complemento, rua, numero, pais, uf);
		
		//Atribuindo o endereço de entrega ao pedido
		this.enderecoEntrega = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Pedido pedido) {
		List<Item> itens;
		List<Produto> list = new ArrayList<Produto>();
		itens = pedido.getItens();
		//Loop sobre os itens do pedido original.
		for (Item item : itens) {
			
			float precoUnitario = item.getPreco();
			float quantidade = item.getQuantidade();
			String sku = item.getCodigo();
			float valorTotal = item.getValorTotal();
			
			//Instanciando o novo produto com os dados do pedido original.
			Produto produto = new Produto(precoUnitario, quantidade, sku, valorTotal);
			
			//Adiciona o novo produto convertido à lista de produtos
			list.add(produto);
		}
		//Atribui a lista de produtos ao pedido de destino.
		this.produtos = list;
	}

	public float getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
