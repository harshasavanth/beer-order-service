package com.microservice.beerorderservice.service.beer;

import com.microservice.beerorderservice.service.beer.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    Optional<BeerDto> getBeerById(UUID beerId);

    Optional<BeerDto> getBeerByUpc(String upc);

}
