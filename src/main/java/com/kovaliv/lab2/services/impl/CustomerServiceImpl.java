package com.kovaliv.lab2.services.impl;

import com.kovaliv.lab2.ExceptionMessage;
import com.kovaliv.lab2.dtos.customer.AddCustomerDto;
import com.kovaliv.lab2.dtos.customer.CustomerDto;
import com.kovaliv.lab2.entities.Customer;
import com.kovaliv.lab2.repositories.CustomerRepo;
import com.kovaliv.lab2.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getAll() {
        return customerRepo.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ExceptionMessage.CUSTOMER_NOT_FOUND));
    }

    @Override
    public CustomerDto save(AddCustomerDto addCustomerDto) {
        Customer savedCustomer = customerRepo.save(modelMapper.map(addCustomerDto, Customer.class));
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto update(AddCustomerDto addCustomerDto, Long id) {
        Customer customer = getById(id);
        customer.setName(addCustomerDto.getName());
        customer.setSurname(addCustomerDto.getSurname());
        return modelMapper.map(customerRepo.save(customer), CustomerDto.class);
    }

    @Override
    public void delete(Long id) {
        Customer customer = getById(id);
        customerRepo.delete(customer);
    }
}
