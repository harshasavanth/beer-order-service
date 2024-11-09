package com.brewery.microservice.beerorderservice.service.beer;

import com.brewery.microservice.beerorderservice.service.beer.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    Optional<BeerDto> getBeerById(UUID uuid);

    Optional<BeerDto> getBeerByUpc(String upc);

}
