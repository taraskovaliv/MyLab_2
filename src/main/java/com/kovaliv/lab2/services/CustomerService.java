package com.kovaliv.lab2.services;

import com.kovaliv.lab2.dtos.customer.AddCustomerDto;
import com.kovaliv.lab2.dtos.customer.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAll();

    CustomerDto save(AddCustomerDto addCustomerDto);

    CustomerDto update(CustomerDto customerDto);

    void delete(Long id);
}
