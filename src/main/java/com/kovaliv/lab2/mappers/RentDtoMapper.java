package com.kovaliv.lab2.mappers;

import com.kovaliv.lab2.dtos.rent.RentDto;
import com.kovaliv.lab2.entities.Rent;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class RentDtoMapper extends AbstractConverter<Rent, RentDto> {
    @Override
    protected RentDto convert(Rent rent) {
        return RentDto.builder()
                .end(rent.getEndOfRent())
                .start(rent.getStartOfRent())
                .build();
    }
}