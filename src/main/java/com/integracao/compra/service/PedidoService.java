package com.integracao.compra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integracao.compra.models.Pedido;
import com.integracao.compra.repository.PedidoRepository;

/**
 * Classe de Serviço com faz o intermédio entre o Repositório e o Controller de Pedido.
 */
@Service
public class PedidoService implements IPedidoService{

	//Injeção de dependência da classe PedidoRepository em PedidoService
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public PedidoService() {
		
	}
	
	/**
	 * Método que salva os pedidos de origem no banco de dados.
	 * @param pedido - objeto Pedido
	 */
	@Override
	public Pedido salvarPedido(Pedido pedido) {
		return this.pedidoRepository.save(pedido);
	}
	
	/**
	 * Método que retorna a lista de Pedidos do banco de dados.
	 * @return List<Pedido>
	 */
	@Override
	public List<Pedido> getPedidos() {
		return this.pedidoRepository.findAll();
	}
	
}
