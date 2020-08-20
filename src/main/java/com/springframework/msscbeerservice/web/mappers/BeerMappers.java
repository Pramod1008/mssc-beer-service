package com.springframework.msscbeerservice.web.mappers;

import com.springframework.msscbeerservice.domain.Beer;
import com.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMappers {
    BeerDto BeerToBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDto beerDto);
}

