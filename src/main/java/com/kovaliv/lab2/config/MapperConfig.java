package com.kovaliv.lab2.config;

import com.kovaliv.lab2.mappers.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MapperConfig {
    private final CarMapper carMapper;
    private final RentMapper rentMapper;
    private final CarDtoMapper carDtoMapper;
    private final RentDtoMapper rentDtoMapper;
    private final CustomerMapper customerMapper;
    private final CustomerDtoMapper customerDtoMapper;

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        addConverters(modelMapper);
        return modelMapper;
    }

    private void addConverters(ModelMapper modelMapper) {
        modelMapper.addConverter(carMapper);
        modelMapper.addConverter(rentMapper);
        modelMapper.addConverter(carDtoMapper);
        modelMapper.addConverter(rentDtoMapper);
        modelMapper.addConverter(customerMapper);
        modelMapper.addConverter(customerDtoMapper);
    }
}
