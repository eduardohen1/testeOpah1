package br.com.ehsolucoes.testeOpah1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteOpah1ApplicationTests {

	private RestTemplate restTemplate;

	@Test
	public void testeSemParametros() {
		restTemplate = new RestTemplate();
		String response = restTemplate
				.getForObject("http://localhost:8080/calc_hospedagem/", String.class);
	}

	@Test
	public void testeComParametros(){
		restTemplate = new RestTemplate();
		String response = restTemplate
				.getForObject("http://localhost:8080/calc_hospedagem/?citycode=9626&checkin=13/11/2019&checkout=20/11/2019&qteadulto=2&qtecrianca=1", String.class);
	}

	@Test
	public void testeComDatasInvalidas(){
		restTemplate = new RestTemplate();
		String response = restTemplate
				.getForObject("http://localhost:8080/calc_hospedagem/?citycode=9626&checkin=31/11/2019&checkout=01/01/2020&qteadulto=2&qtecrianca=1", String.class);
		response = restTemplate
				.getForObject("http://localhost:8080/calc_hospedagem/?citycode=9626&checkin=15/11/2019&checkout=10/11/2019&qteadulto=2&qtecrianca=1", String.class);
	}



}
