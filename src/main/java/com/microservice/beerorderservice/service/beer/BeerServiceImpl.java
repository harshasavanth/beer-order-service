package com.microservice.beerorderservice.service.beer;

import com.microservice.beerorderservice.service.beer.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@ConfigurationProperties(prefix = "microservice", ignoreUnknownFields = false)
@Component
public class BeerServiceImpl implements BeerService {

    private final String BEER_PATH = "/api/vi/beer/";
    private final String BEER_UPC_PATH = "/api/v1/beerUpc/";

    private final RestTemplate restTemplate;

    public BeerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @lombok.Setter
    private String beerServiceHost;

    @Override
    public Optional<BeerDto> getBeerById(UUID beerId) {
        log.debug("Calling beer service");
        return Optional.ofNullable(restTemplate.getForObject(beerServiceHost + BEER_PATH + beerId, BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        return Optional.ofNullable(restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH + upc, BeerDto.class));

    }
}
