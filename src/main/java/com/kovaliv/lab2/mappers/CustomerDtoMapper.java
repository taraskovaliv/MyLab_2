package com.kovaliv.lab2.mappers;

import com.kovaliv.lab2.dtos.customer.CustomerDto;
import com.kovaliv.lab2.entities.Customer;
import com.kovaliv.lab2.entities.Rent;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoMapper extends AbstractConverter<Customer, CustomerDto> {
    @Override
    protected CustomerDto convert(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surmane(customer.getSurname())
                .rents(customer.getRents().stream()
                        .map(Rent::toString)
                        .collect(Collectors.toList()))
                .build();
    }
}
