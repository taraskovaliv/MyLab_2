package com.kovaliv.lab2.mappers;

import com.kovaliv.lab2.dtos.car.AddCarDto;
import com.kovaliv.lab2.entities.Car;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class CarMapper extends AbstractConverter<AddCarDto, Car> {
    @Override
    protected Car convert(AddCarDto addCarDto) {
        return Car.builder()
                .code(addCarDto.getCode())
                .name(addCarDto.getName())
                .build();
    }
}
