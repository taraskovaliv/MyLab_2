package com.kovaliv.lab2.repositories;

import com.kovaliv.lab2.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent, Long> {
}