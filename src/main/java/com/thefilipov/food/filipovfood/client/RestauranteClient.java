package com.thefilipov.food.filipovfood.client;

import com.thefilipov.food.filipovfood.client.model.RestauranteResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static final String RESOURCE_PATH = "/foodapi/restaurantes";

    private RestTemplate restTemplate;
    private String url;

    public List<RestauranteResumoModel> listar() {

        URI resourceURI = URI.create(url + RESOURCE_PATH);

        RestauranteResumoModel[] restaurantes = restTemplate
                .getForObject(resourceURI, RestauranteResumoModel[].class);

        return Arrays.asList(restaurantes);
    }
}
