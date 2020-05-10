package com.kovaliv.lab2.config;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        addConverters(modelMapper);
        return modelMapper;
    }

    private void addConverters(ModelMapper modelMapper) {

    }
}
