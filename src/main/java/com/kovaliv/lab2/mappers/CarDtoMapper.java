package com.kovaliv.lab2.mappers;

import com.kovaliv.lab2.dtos.car.CarDto;
import com.kovaliv.lab2.entities.Car;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class CarDtoMapper extends AbstractConverter<Car, CarDto> {
    @Override
    protected CarDto convert(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .name(car.getName())
                .code(car.getCode())
                .build();
    }
}
