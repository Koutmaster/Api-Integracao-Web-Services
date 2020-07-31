package com.integracao.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integracao.compra.models.Pedido;

/**
 * Classe de repositório do Pedido.
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	
	
}
