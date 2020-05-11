package com.kovaliv.lab2.mappers;

import com.kovaliv.lab2.dtos.rent.AddRentDto;
import com.kovaliv.lab2.entities.Rent;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class RentMapper extends AbstractConverter<AddRentDto, Rent> {
    @Override
    protected Rent convert(AddRentDto addRentDto) {
        return Rent.builder()
                .endOfRent(addRentDto.getEnd())
                .startOfRent(addRentDto.getStart())
                .build();
    }
}