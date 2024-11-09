package com.brewery.microservice.beerorderservice.web.mapper;

import com.brewery.microservice.beerorderservice.domain.BeerOrderLine;
import com.brewery.microservice.beerorderservice.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}