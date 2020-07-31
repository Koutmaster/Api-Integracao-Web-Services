package com.integracao.compra.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.integracao.compra.models.Pedido;
import com.integracao.compra.models.PedidoEnvio;
import com.integracao.compra.repository.PedidoRepository;

/**
 * Classe responsável por fazer o contato e integração entre os Web Services de origem e destino.
 */
@Component
@EnableScheduling 
@EnableJpaRepositories(basePackageClasses = PedidoRepository.class)
public class CallWebService implements CommandLineRunner{
	
	private static ResponseEntity<String> resposta;
	private static RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * Método que irá fazer o contato com o WebService de origem, inserir os dados no banco de dados e iniciar o envio ao destino.
	 */
	@Scheduled(fixedDelay = 300000)
	private static void callWebService(){
		try {
			//Faz a requisição da lista de Pedidos ao WebService usando restTemplate.
			Pedido[] pedidos = restTemplate.getForObject("http://origem.demacode.com.br:8181/WS/Pedido?data_inicial=2020-01-20T00:00&data_final=2020-10-20T00:00", Pedido[].class);
			//Loop sobre os pedidos da lista
			for(Pedido pedido: pedidos) {
				//Caso o cliente e representante do pedido possuam Cpf/Cnpj informados e existir pelo menos um item informado
				if (pedido.getCliente().getCpfCnpj() != null && pedido.getRepresentante().getCpfCnpj() != null && pedido.getItens() != null) {
					//Post para o método Controller de Pedido para inserir o pedido no banco de dados.
					resposta = restTemplate.postForEntity("http://localhost:8080/pedidoResource", pedido, String.class);
					System.out.println(resposta);
				}
			}
			//Tendo terminado de buscar os pedidos, inicia o processo de enviar os dados ao destino
			sendData();
		} catch(RestClientException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsável por fazer a conversão do pedido original para o pedido de destino e enviar o mesmo.
	 */
	private static void sendData() {
		try {
			//Requisição ao Controller de Pedido para buscar a lista de Pedidos do banco de dados.
			ResponseEntity<Pedido[]> respostaPedidos = restTemplate.getForEntity("http://localhost:8080/pedidoResource/get", Pedido[].class);
			//Insere o corpo da resposta na lista de pedidos de entrega.
			Pedido[] pedidosEntrega = respostaPedidos.getBody();
			//Loop sobre os pedidos da lista de entrega.
			for(Pedido pedido: pedidosEntrega) {
					//Instanciando o pedido a ser enviado utilizando os dados do pedido original.
					PedidoEnvio pedidoEnvio = new PedidoEnvio(pedido);
					//Envia o Pedido convertido para o Web Service de destino.
					resposta = restTemplate.postForEntity("http://destino.demacode.com.br:8282/v1/pedido", pedidoEnvio, String.class);
					System.out.println(resposta);
			}
		} catch(RestClientException e) {
				e.printStackTrace();
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		callWebService();
		
	}
	
}
