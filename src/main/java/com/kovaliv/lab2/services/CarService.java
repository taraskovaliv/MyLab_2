package com.kovaliv.lab2.services;

import com.kovaliv.lab2.dtos.car.AddCarDto;
import com.kovaliv.lab2.dtos.car.CarDto;
import com.kovaliv.lab2.entities.Car;

import java.util.List;

public interface CarService {
    List<CarDto> getAll();

    Car getById(Long id);

    CarDto save(AddCarDto addCarDto);

    CarDto update(CarDto carDto);

    void delete(Long id);
}
