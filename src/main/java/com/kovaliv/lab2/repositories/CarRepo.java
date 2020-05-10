package com.kovaliv.lab2.repositories;

import com.kovaliv.lab2.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}
