package com.kovaliv.lab2.mappers;

import com.kovaliv.lab2.dtos.customer.AddCustomerDto;
import com.kovaliv.lab2.entities.Customer;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper extends AbstractConverter<AddCustomerDto, Customer> {
    @Override
    protected Customer convert(AddCustomerDto addCustomerDto) {
        return Customer.builder()
                .name(addCustomerDto.getName())
                .surname(addCustomerDto.getSurname())
                .build();
    }
}
