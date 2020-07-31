package com.integracao.compra.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integracao.compra.models.Pedido;
import com.integracao.compra.service.PedidoService;

/**
 * Classe controller do Pedido de origem.
 */
@RestController
@RequestMapping(value = "/pedidoResource")
public class PedidoResource {
	
	//Injeção de dependência da classe PedidoService no Controller PedidoResource
	@Autowired
	private PedidoService pedidoService;
	
	public PedidoResource() {
		
	}
	
	/**
	 * Método que salva os pedidos de origem no banco de dados.
	 * @param pedido - objeto Pedido
	 * @return String - "Pedido Salvo"
	 */
	@RequestMapping(value = "")
	public String salvaPedido(@RequestBody Pedido pedido) {
		this.pedidoService.salvarPedido(pedido);
		return "Pedido Salvo.";
	}
	
	/**
	 * Método que retorna uma lista com os pedidos salvos no banco de dados.
	 * @return List<Pedido>
	 */
	@RequestMapping(value = "/get")
	public List<Pedido> getPedidos() {
		return this.pedidoService.getPedidos();
	}
	
}
