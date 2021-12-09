package com.example.consumingrest;

import com.example.consumingrest.model.Localizacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.net.URLEncoder;
import java.util.List;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run1(RestTemplate restTemplate) throws Exception {
		return args -> {
			Localizacao localizacao = restTemplate.getForObject("https://viacep.com.br/ws/68900010/json/", Localizacao.class);
			log.info(localizacao.toString());
		};
	}

	@Bean
	public CommandLineRunner run2(RestTemplate restTemplate) throws Exception {
		return args -> {
			List<Localizacao> localizacoes = restTemplate.exchange("https://viacep.com.br/ws/AP/Macapa/Avenida FAB/json/",
					HttpMethod.GET,null,new ParameterizedTypeReference<List<Localizacao>>(){}).getBody();
			log.info(localizacoes.toString());
		};
	}


}
