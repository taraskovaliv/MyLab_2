package com.kovaliv.lab2.services.impl;

import com.kovaliv.lab2.ExceptionMessage;
import com.kovaliv.lab2.dtos.car.AddCarDto;
import com.kovaliv.lab2.dtos.car.CarDto;
import com.kovaliv.lab2.entities.Car;
import com.kovaliv.lab2.repositories.CarRepo;
import com.kovaliv.lab2.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Car getById(Long id) {
        return carRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ExceptionMessage.CAR_NOT_FOUND));
    }

    @Override
    public CarDto save(AddCarDto addCarDto) {
        Car savedCar = carRepo.save(modelMapper.map(addCarDto, Car.class));
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    public CarDto update(AddCarDto addCarDto, Long id) {
        Car car = getById(id);
        car.setCode(addCarDto.getCode());
        car.setName(addCarDto.getName());
        return modelMapper.map(carRepo.save(car), CarDto.class);
    }

    @Override
    public void delete(Long id) {
        Car car = getById(id);
        carRepo.delete(car);
    }
}
