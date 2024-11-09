package com.brewery.microservice.beerorderservice.web.mapper;

import com.brewery.microservice.beerorderservice.domain.BeerOrderLine;
import com.brewery.microservice.beerorderservice.service.beer.BeerService;
import com.brewery.microservice.beerorderservice.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper{

    private BeerService beerService;
    private BeerOrderLineMapper beerOrderLineMapper;

    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }

    @Autowired
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine) {
        BeerOrderLineDto beerOrderLineDto = beerOrderLineMapper.beerOrderLineToDto(beerOrderLine);
        beerService.getBeerByUpc(beerOrderLine.getUpc()).ifPresent(beerDto -> {
            beerOrderLineDto.setBeerId(beerDto.getId());
            beerOrderLineDto.setBeerName(beerDto.getBeerName());
            beerOrderLineDto.setBeerStyle(beerDto.getBeerStyle());
            beerOrderLineDto.setPrice(beerDto.getPrice());
        });
        return beerOrderLineDto;
    }

}
