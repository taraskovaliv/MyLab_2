package com.kovaliv.lab2.services.impl;

import com.kovaliv.lab2.dtos.car.AddCarDto;
import com.kovaliv.lab2.dtos.car.CarDto;
import com.kovaliv.lab2.entities.Car;
import com.kovaliv.lab2.repositories.CarRepo;
import com.kovaliv.lab2.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CarDto> getAll() {
        return carRepo.findAll().stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDto save(AddCarDto addCarDto) {
        Car savedCar = carRepo.save(modelMapper.map(addCarDto, Car.class));
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    public CarDto update(CarDto carDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Car> car = carRepo.findById(id);
        if (car.isPresent()) {
            carRepo.delete(car.get());
        } else {
            throw new RuntimeException("Car not found");
        }
    }
}
