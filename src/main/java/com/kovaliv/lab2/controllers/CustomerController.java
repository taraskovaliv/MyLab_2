package com.kovaliv.lab2.controllers;

import com.kovaliv.lab2.dtos.customer.AddCustomerDto;
import com.kovaliv.lab2.dtos.customer.CustomerDto;
import com.kovaliv.lab2.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody AddCustomerDto addCustomerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(addCustomerDto));
    }

    @PutMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.update(customerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
