package com.kovaliv.lab2.services.impl;

import com.kovaliv.lab2.ExceptionMessage;
import com.kovaliv.lab2.dtos.rent.AddRentDto;
import com.kovaliv.lab2.dtos.rent.RentDto;
import com.kovaliv.lab2.entities.Rent;
import com.kovaliv.lab2.repositories.RentRepo;
import com.kovaliv.lab2.services.CarService;
import com.kovaliv.lab2.services.CustomerService;
import com.kovaliv.lab2.services.RentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentService {
    private final RentRepo rentRepo;
    private final CarService carService;
    private final ModelMapper modelMapper;
    private final CustomerService customerService;

    @Override
    public List<RentDto> getAll() {
        return rentRepo.findAll().stream()
                .map(rent -> modelMapper.map(rent, RentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RentDto save(AddRentDto addRentDto) {
        Rent rent = modelMapper.map(addRentDto, Rent.class);
        rent.setCar(carService.getById(addRentDto.getCarId()));
        rent.setCustomer(customerService.getById(addRentDto.getCustomerId()));
        return modelMapper.map(rentRepo.save(rent), RentDto.class);
    }

    @Override
    public RentDto update(AddRentDto addRentDto, Long id) {
        Rent rent = rentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(ExceptionMessage.RENT_NOT_FOUND));
        rent.setEndOfRent(addRentDto.getEnd());
        rent.setStartOfRent(addRentDto.getStart());
        rent.setCar(carService.getById(addRentDto.getCarId()));
        rent.setCustomer(customerService.getById(addRentDto.getCustomerId()));
        return modelMapper.map(rentRepo.save(rent), RentDto.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Rent> rent = rentRepo.findById(id);
        if (rent.isPresent()) {
            rentRepo.delete(rent.get());
        } else {
            throw new RuntimeException(ExceptionMessage.RENT_NOT_FOUND);
        }
    }
}
