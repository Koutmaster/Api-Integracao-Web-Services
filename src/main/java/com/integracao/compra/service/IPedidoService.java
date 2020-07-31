package com.integracao.compra.service;

import java.util.List;

import com.integracao.compra.models.Pedido;

public interface IPedidoService {

	Pedido salvarPedido(Pedido pedido);

	List<Pedido> getPedidos();
	
}
