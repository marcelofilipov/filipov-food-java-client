package com.thefilipov.food.filipovfood.client.api;

import com.thefilipov.food.filipovfood.client.api.ClientApiException;
import com.thefilipov.food.filipovfood.client.model.RestauranteResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static final String RESOURCE_PATH = "/foodapi/restaurantesss";

    private RestTemplate restTemplate;
    private String url;

    public List<RestauranteResumoModel> listar() {

        try {
            URI resourceURI = URI.create(url + RESOURCE_PATH);

            RestauranteResumoModel[] restaurantes = restTemplate
                    .getForObject(resourceURI, RestauranteResumoModel[].class);

            return Arrays.asList(restaurantes);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }


    }
}
