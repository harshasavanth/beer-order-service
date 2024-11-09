package com.brewery.microservice.beerorderservice.web.mapper;

import com.brewery.microservice.beerorderservice.domain.BeerOrder;
import com.brewery.microservice.beerorderservice.web.model.BeerOrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}