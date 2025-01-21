package br.com.marketplace.rabbitmq.api;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MarketplaceRabbitmqApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceRabbitmqApiApplication.class, args);
		System.out.println(
			"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
			"\nO sistema foi iniciado... port: 8080" +
			"\nBem vindo ao projeto Marketplace Rabbit MQ Api" + 
			"\nO objetivo deste projeto é implementar um sistema de integração utilizando o RabbitMQ, uma ferramenta de mensageria amplamente utilizada para comunicação entre sistemas e troca de informações de maneira assíncrona e escalável." + 
			"\nAcesse as funções do projeto de chamadas para as urls:  " + 
			"\n    1. \\pedido\\finalizar - para finalizar um pedido e gerar um pagamento." + 
			"\n    2. \\pagamento\\listar - para listar todos os pagamentos registrados." +
			"\n    3. \\usuario\\listar - para listar todos os usuarios registrados." +
			"\n    4. \\produto\\listar - para listar todos os produtos registrados." + 
			"\nO json de pagamento que será enviado na requisição deve conter o pedido. Segue um exemplo: " + 
			"\n{" + 
			"\n    \"metodoPagamento\": \"PIX\",\r\n" + //
			"    \"codigoUsuario\": 1,\r\n" + //
			"    \"items\": [\r\n" + //
			"           {\r\n" + //
			"            \"codigoProduto\": 1,\r\n" + //
			"            \"quantidade\": 2\r\n" + //
				 "      }\r\n" + //
				 "    ],\r\n" + //
				 "    \"observacao\": \"Cuidado no transporte\"\r\n" + //
			  "}" +
			  "\n-- IMPORTANTE -- " + 
			  "\nESSE PROJETO FUNCIONA EM CONJUNTO COM O MarketplaceRabbitmqIntegration" +
			  "\nAMBOS ESTAO CONFIGURADOS PRA RODAR EM PORTAS DIFERENTES" +
			  "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
			);
	}
	
}
