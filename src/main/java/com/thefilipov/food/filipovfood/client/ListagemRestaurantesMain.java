package com.thefilipov.food.filipovfood.client;

import com.thefilipov.food.filipovfood.client.api.ClientApiException;
import com.thefilipov.food.filipovfood.client.api.RestauranteClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class ListagemRestaurantesMain {

    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient restauranteClient = new RestauranteClient(
                    restTemplate, "http://api.filipov-food.local:8082");

            restauranteClient.listar().stream()
                    .forEach(restaurante -> System.out.println(restaurante));
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                log.error(e.getProblem().getUserMessage());
            } else {
                log.error("Erro desconhecido");
                e.printStackTrace();
            }
        }

    }
}
