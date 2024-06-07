package com.microservice.beerorderservice.mapper;

import com.microservice.beerorderservice.domain.BeerOrderLine;
import com.microservice.beerorderservice.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}