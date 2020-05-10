package com.kovaliv.lab2.repositories;

import com.kovaliv.lab2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}