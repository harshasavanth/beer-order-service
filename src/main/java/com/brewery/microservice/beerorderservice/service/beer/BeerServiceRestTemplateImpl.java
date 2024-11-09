package com.brewery.microservice.beerorderservice.service.beer;

import com.brewery.microservice.beerorderservice.service.beer.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@ConfigurationProperties(prefix = "com.brewery", ignoreUnknownFields = false)
@Service
public class BeerServiceRestTemplateImpl implements BeerService {

    private final String BEER_PATH = "/api/v1/beer/";
    private final String BEER_UPC_PATH = "/api/v1/beerUpc/";

    private final RestTemplate restTemplate;

    private String beerServiceHost;

    public BeerServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }


    @Override
    public Optional<BeerDto> getBeerById(UUID uuid) {
        return Optional.ofNullable(restTemplate.getForObject(BEER_PATH + beerServiceHost + uuid.toString(), BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        return Optional.ofNullable(restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH + upc, BeerDto.class));
    }
}
