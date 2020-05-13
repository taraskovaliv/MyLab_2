package com.kovaliv.lab2.services;

import com.kovaliv.lab2.dtos.customer.AddCustomerDto;
import com.kovaliv.lab2.dtos.customer.CustomerDto;
import com.kovaliv.lab2.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAll();

    Customer getById(Long id);

    CustomerDto save(AddCustomerDto addCustomerDto);

    CustomerDto update(AddCustomerDto addCustomerDto, Long id);

    void delete(Long id);
}
