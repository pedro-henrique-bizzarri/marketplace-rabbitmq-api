package br.com.marketplace.rabbitmq.api;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MarketplaceRabbitmqApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceRabbitmqApiApplication.class, args);
	}

}
